import datetime  # library from python api. Not user defined


class DateTime:
    def __init__(self):
        self.dt = datetime.datetime.now()

    # -> str is just an annotation telling what the method should return, doesn't affect anything
    def getCurrentDate(self) -> str:
        """gets current date in string"""
        return str(self.dt.date())

    def getCurrentTime(self) -> str:
        """gets current time in string"""
        return str(self.dt.time())

    def getDate(self) -> datetime:
        """helps check if user should be charged extra"""
        date = self.getCurrentDate().split('-')
        return datetime.date(int(date[0]), int(date[1]), int(date[2]))

    @staticmethod
    def getBorrowedDate(file) -> datetime:
        f = open(file)  # open in read mode
        lines = f.readlines()
        f.close()
        for data_line in lines:
            if 'Date:' in data_line:
                # remove useless info, strip down spaces, line breaks and convert to array
                data = data_line.replace('Date:', '').strip().strip('\n').split('-')
                return datetime.date(int(data[0]), int(data[1]), int(data[2]))


class Lib:
    """Stores info about books in a 2D array(list) data structure"""

    def __init__(self):
        self.bookList = []
        self.authorList = []
        self.quantityList = []
        self.priceList = []
        """initializes the values of lists by reading the file and using proper data structures"""
        f = open("text/library.txt")
        content = [c.strip("\n") for c in f.readlines()]  # read and strip down line breaks, store lines in an array
        f.close()
        for i in range(len(content)):
            j = 0
            for c in content[i].split(","):
                if j == 0:  # for first element(there should normally be 4 because it is separated by comma in file)
                    self.bookList.append(c)  # 2d list
                elif j == 1:
                    self.authorList.append(c)
                elif j == 2:
                    self.quantityList.append(c)
                elif j == 3:
                    self.priceList.append(c.strip("$"))  # remove/strip down $ chars
                j += 1


dt = DateTime()


class Borrow:
    """Handles operations for borrowing book"""

    def __init__(self):
        first_name = input("Enter your first name: ")
        last_name = input("Enter your last name: ")

        borrow_rec = f"text/Borrowed-{first_name}.txt"
        f = open(borrow_rec, "w+")
        f.write(f'''Library Management System: \n\n\n
    Borrowed by: {first_name} {last_name} 
    Date: {dt.getCurrentDate()}
    Time: {dt.getCurrentTime()}
    S.N.\tBook Name\t\t\t\t\t\tAuthor\t\t\t\tCost\n''')
        f.close()

        count = 1
        while True:  # until break
            lib = Lib()
            print("Please select an option: ")
            [print(f"Enter {i} to borrow book {lib.bookList[i]}") for i in range(len(lib.bookList))]

            try:
                index = int(input("Please input book number: "))
                try:  # can throw index out of bounds exception
                    if int(lib.quantityList[index]) > 0:
                        print("Book is available")
                        f = open(borrow_rec, "a")  # in append mode
                        f.write(
                            f"\t{count} \t\t{lib.bookList[index]}\t\t\t\t{lib.authorList[index]}\t\t\t\t"
                            f"{lib.priceList[index]}\n")
                        f.close()

                        lib.quantityList[index] = str(int(lib.quantityList[index]) - 1)
                        f = open("text/library.txt", "w+")
                        for i in range(3):
                            f.write(
                                f"{lib.bookList[i]},{lib.authorList[i]},{lib.quantityList[i]},${lib.priceList[i]}\n")
                        f.close()
                        yn = input("Do you want to borrow more books?(y/n): ")
                        if yn.lower() != "y":
                            break  # end loop
                        count += 1
                    else:
                        print("Book is not available in stock")
                        Borrow()
                except IndexError:
                    print("\nPlease choose book as per their number.")
            except ValueError as err:
                print(f"\nPlease choose as suggested. {err}")


class Return:
    """Handles operations for returning book"""

    def __init__(self):
        count_ = 1
        name = input("Enter your first name: ")
        borrow_rec = f"text/Borrowed-{name}.txt"
        return_rec = f"text/Return-{name}.txt"
        try:
            f = open(borrow_rec)  # opens in read mode by default
            data = f.read()
            print(data)
            f.close()
        except FileNotFoundError:
            print("Please enter correct name")
            self.__init__()  # recurse

        f = open(return_rec, "w+")
        f.write(f'''Library Management System: \n\n\n
        Borrowed by: {name} 
        Date: {dt.getCurrentDate()}
        Time: {dt.getCurrentTime()}
        S.N.\tBook Name\t\t\t\t\t\tAuthor\t\t\t\t\tCost\n''')
        f.close()

        total = 0.0
        lib = Lib()
        for i in range(3):
            book = lib.bookList[i]
            if book in data:
                f = open(return_rec, "a")  # open in append mode
                f.write(f"\t{count_} \t\t{book}\t\t\t\t\t{lib.authorList[i]}\t\t\t\t{lib.priceList[i]}\n")
                count_ += 1
                f.close()
                total += float(lib.priceList[i])

                f = open(borrow_rec)  # open in read mode
                lib.quantityList[i] = str(int(lib.quantityList[i]) + f.read().count(
                    book))  # get how many times this string has repeated in file
                f.close()

        print(f"\t\t\t\t\t\t\t\t\t\t\t\t\t${total}")
        stat = (dt.getDate() - dt.getBorrowedDate(borrow_rec)).days
        print(f"You have returned after {stat} days")
        if stat > 10:
            fine = 2 * (stat - 10)
            f = open(return_rec, "a")
            f.write(f"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tFine: ${fine}\n")
            f.close()
            total = total + fine

        print(f"Final Total: ${total}")

        f = open(return_rec, "a")
        f.write(f"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal: ${total}")
        f.close()

        f = open("text/library.txt", "w+")
        for i in range(3):
            # writing new data to library record file
            f.write(f"{lib.bookList[i]},{lib.authorList[i]},{str(lib.quantityList[i])},${lib.priceList[i]}\n")
        f.close()

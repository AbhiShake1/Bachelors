import DateTime as dt
import Library as lib

"""Handles operations for returning book"""


def return_book():
    count_ = 1
    name = input("Enter your first name: ")
    borrow_rec = f"text/Borrowed-{name}.txt"
    return_rec = f"text/Return-{name}.txt"
    try:
        f = open(borrow_rec)  # opens in read mode by default
        data = f.read()
        print(data)
        f.close()
        f = open(return_rec, "w+")
        f.write(f'''Library Management System: \n\n\n
        Borrowed by: {name} 
        Date: {dt.getCurrentDate()}
        Time: {dt.getCurrentTime()}
        S.N.\tBook Name\t\t\t\t\t\tAuthor\t\t\t\t\tCost\n''')
        f.close()

        total = 0.0
        for i in range(3):
            book = lib.bookList[i]
            if book in data:
                f = open(return_rec, "a")  # open in append mode
                f.write(f"\t{count_} \t\t{book}\t\t\t\t\t{lib.authorList[i]}\t\t\t\t{lib.priceList[i]}\n")
                count_ += 1
                f.close()
                total += lib.priceList[i]

                f = open(borrow_rec)  # open in read mode
                lib.quantityList[i] = str(lib.quantityList[i] + f.read().count(
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
            f.write(f"{lib.bookList[i]},{lib.authorList[i]},{lib.quantityList[i]},${lib.priceList[i]}\n")
        f.close()
    except FileNotFoundError:  # if non existing name is inputted
        print("Please enter correct name")
        return_book()  # recurse

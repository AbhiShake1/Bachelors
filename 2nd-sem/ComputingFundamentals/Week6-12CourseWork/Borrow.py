import DateTime as dt
import Library as lib

"""Handles operations for borrowing book"""


def borrow_book():
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
        print("Please select an option: ")
        [print(f"Enter {i} to borrow book {lib.bookList[i]}") for i in range(len(lib.bookList))]

        try:
            index = int(input("Please enter book number: "))
            try:  # can throw index out of bounds exception
                if lib.quantityList[index] > 0:
                    print("Book is available")
                    f = open(borrow_rec, "a")  # in append mode
                    f.write(
                        f"\t{count} \t\t{lib.bookList[index]}\t\t\t\t{lib.authorList[index]}\t\t\t\t"
                        f"{lib.priceList[index]}\n")
                    f.close()

                    lib.quantityList[index] = lib.quantityList[index] - 1
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
            except IndexError:
                print("\nPlease choose book as per their number.")
        except ValueError:
            print(f"\nPlease enter a valid number.")

import DateTime as dt
import Library as lib

def borrowBook() -> None: #-> None is an annotation indicating the method should always return void, doesn't affect anything
    firstName = input("Enter your first name: ")
    lastName = input("Enter your last name: ")

    borrowRec = f"text/Borrowed-{firstName}.txt"
    f = open(borrowRec, "w+")
    f.write(f'''Library Management System: \n\n\n
Borrowed by: {firstName} {lastName} 
Date: {dt.getCurrentDate()}
Time: {dt.getCurrentTime()}
\tS.N.\t\tBook Name\t\t\t\t\t\tAuthor\t\t\t\tCost\n''')
    f.close()
    
    count = 1
    while True:  #until break
        print("Please select an option: ")
        [print(f"Enter {i} to borrow book {lib.bookList[i]}") for i in range(len(lib.bookList))]

        try:
            index = int(input("Please input book number: "))
            try:  #can throw index out of bounds exception
                if int(lib.quantityList[index]) > 0:
                    print("Book is available")
                    f = open(borrowRec, "a")  #in append mode
                    f.write(f"\t{count} \t\t{lib.bookList[index]}\t\t\t\t{lib.authorList[index]}\t\t\t\t{lib.priceList[index]}\n")
                    f.close()

                    lib.quantityList[index] = int(lib.quantityList[index]) - 1
                    f = open("text/library.txt", "w+")
                    for i in range(3):
                        f.write(f"{lib.bookList[i]},{lib.authorList[i]},{lib.quantityList[i]},${lib.priceList[i]}\n")
                    f.close()
                    yn = input("Do you want to borrow more books?(y/n): ")
                    if yn.lower() != "y":
                        break  #end loop
                    count += 1
                else:
                    print("Book is not available in stock")
                    borrowBook()
            except IndexError:
                print("\nPlease choose book as per their number.")
        except ValueError as err:
            print(f"\nPlease choose as suggested. {err}")
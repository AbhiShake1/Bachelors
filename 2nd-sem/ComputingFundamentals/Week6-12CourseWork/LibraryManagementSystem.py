bookList = []
authorList = []
quantityList = []
priceList = []

def getList():
    with open("library.txt") as f:
        content = [c.strip("\n") for c in f.readlines()]  #read and strip down line breaks
        for i in range(len(content)):
            j = 0
            for c in content[i].split(","):
                if j == 0: #for first element(there should normally be 4 because it is separated by comma in file)
                    bookList.append(c)
                elif j == 1:
                    authorList.append(c)
                elif j == 2:
                    quantityList.append(c)
                elif j == 3:
                    priceList.append(c.strip("$")) #remove/strip down $ chars
                j += 1

import datetime as dt
dt = dt.datetime.now()

def getCurrentDate():
    return str(dt.date())

def getCurrentTime():
    return str(dt.time())

def returnBook():
    count = 1
    name = input("Enter your name: ")
    borrowRec = "Borrowed-" + name + ".txt"
    try:
        with open(borrowRec, "r") as f:
            lines = f.readlines()
            lines = [borrowRec.strip("$") for borrowRec in lines]
    
        with open(borrowRec, "r") as f:
            data = f.read()
            print(data)
    except:
        print("Please enter correct name")

    returnRec = "Return-" + name + ".txt"
    with open(returnRec, "w+") as f:
        f.write(f'''Library Management System: \n\n\n
                    Borrowed by: {name} 
                    Date: {getCurrentDate()}
                    Time: {getCurrentTime()}
        S.N.\t\tBook Name\t\t\tAuthor\t\t\tCost\n''')        

    total = 0.0
    for i in range(3):
        if bookList[i] in data:
            with open(returnRec, "a") as f:
                f.write(f"\t{count} \t\t{bookList[i]}\t\t\t{authorList[i]}\t\t{priceList[i]}\n")
                quantityList[i] = int(quantityList[i]) + 1
                count += 1
            total += float(priceList[i])
            
    print("\t\t\t\t\t\t\t" + "$" + str(total))
    stat = input(("Is the book return date expired?(y/n): "))
    if (stat.lower() == "y"):
        print("By how many days was the book returned late?")
        day = int(input())
        fine = 2 * day
        with open(returnRec, "a") as f:
            f.write("\t\t\t\t\tFine: $" + str(fine) + "\n")
        total = total + fine
        
    print("Final Total: " + "$" + str(total))
    with open(returnRec, "a") as f:
        f.write("\t\t\t\t\t\t\t\t\t\tTotal: $" + str(total))

def borrowBook():
    firstName = input("Enter your first name: ")
    lastName = input("Enter your last name: ")

    borrowRec = "Borrowed-" + firstName + ".txt"
    with open(borrowRec, "w+") as f:
        f.write(f'''Library Management System: \n\n\n
        Borrowed by: {firstName+" "+lastName} 
        Date: {getCurrentDate()}
        Time: {getCurrentTime()}
        S.N.\t\tBook Name\t\t\tAuthor\t\t\tCost\n''')
    
    count = 1
    while True:  #until break
        print("Please select an option: ")
        [print(f"Enter {i} to borrow book {bookList[i]}") for i in range(len(bookList))]

        try:
            index = int(input("Please input book number: "))
            try:  #can throw index out of bounds exception
                if int(quantityList[index]) > 0:
                    print("Book is available")
                    with open(borrowRec, "a") as f:  #in append mode
                        f.write(f"\t{count} \t\t{bookList[index]}\t\t\t{authorList[index]}\t\t{priceList[index]}\n")

                    quantityList[index] = int(quantityList[index]) - 1
                    with open("library.txt", "w+") as f:
                        for i in range(3):
                            f.write(bookList[i] + "," + authorList[i] + "," + str(quantityList[i]) + ",$" + priceList[i] + "\n")
                    yn = input("Do you want to borrow more books?(y/n): ")
                    if yn.lower() != "y":
                        break  #end loop
                    count += 1
                else:
                    print("Book is not available")
                    borrowBook()
            except IndexError:
                print("\nPlease choose book as per their number.")
        except ValueError as err:
            print("\nPlease choose as suggested. " + str(err))

def init():
    while (True):  #infinite loop
        print(f'''
        Welcome to Library Management System
{"-"*50} 
        Enter 1 to display,
              2 to borrow a book,
              3 to return a book
              4 to exit
{"-"*50} 
        ''')

        try:
            choice = int(input("Please select a number from 1 to 4: "))
            if (choice == 1):
                with open("library.txt") as f:
                    print(f.read() + "\n")
            elif (choice == 2):
                getList()  #initialize values of global lists
                borrowBook()
            elif (choice == 3):
                getList()  #initialize values of global lists
                returnBook()
            elif (choice == 4):
                print("Thank you for using our service")
                break  #get out of loop
            else:
                print("Invalid number. Please read instructions carefully.")
        except ValueError as err:  #if input can not be parsed
            print("Please input a valid number. " + str(err))


#initialize the program
init()
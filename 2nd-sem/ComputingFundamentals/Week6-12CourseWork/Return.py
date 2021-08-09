import DateTime as dt
import Library as lib

def returnBook() -> None: #-> None is an annotation indicating the method should always return void, doesn't affect anything
    '''Handles operations for returning book'''
    count = 1
    name = input("Enter your name: ")
    borrowRec = "text/Borrowed-" + name + ".txt"
    try: 
        f = open(borrowRec) #opens in read mode by default
        lines = f.readlines()
        lines = [borrowRec.strip("$") for borrowRec in lines]
        
        data = f.read()
        f.close()
        print(data)
    except:
        print("Please enter correct name")
        return #end method, return None

    returnRec = "text/Return-" + name + ".txt"
    f = open(returnRec, "w+")
    f.write(f'''Library Management System: \n\n\n
    Borrowed by: {name} 
    Date: {dt.getCurrentDate()}
    Time: {dt.getCurrentTime()}
    S.N.\tBook Name\t\t\t\t\t\tAuthor\t\t\t\t\t\t\t\t\t\tCost\n''')
    f.close()

    total = 0.0
    for i in range(3):
        if lib.bookList[i] in data:
            f = open(returnRec, "a") #open in append mode
            f.write(f"\t{count} \t\t{lib.bookList[i]}\t\t\t\t\t{lib.authorList[i]}\t\t\t{lib.priceList[i]}\n")
            lib.quantityList[i] = int(lib.quantityList[i]) + 1
            count += 1
            f.close()
            total += float(lib.priceList[i])
            
    print("\t\t\t\t\t\t\t\t\t\t" + "$" + str(total))
    stat = input(("Is the book return date expired?(y/n): "))
    if (stat.lower() == "y"):
        print("By how many days was the book returned late?")
        day = int(input())
        fine = 2 * day
        open(returnRec, "a")
        f.write("\t\t\t\t\tFine: $" + str(fine) + "\n")
        f.close()
        total = total + fine
        
    print("Final Total: " + "$" + str(total))
    f = open(returnRec, "a")
    f.write("\t\t\t\t\t\t\t\t\t\tTotal: $" + str(total))
    f.close()
import DateTime as dt
import Library as lib

def returnBook() -> None: #-> None is an annotation indicating the method should always return void, doesn't affect anything
    '''Handles operations for returning book'''
    count_ = 1
    name = input("Enter your first name: ")
    borrowRec = f"text/Borrowed-{name}.txt"
    try: 
        f = open(borrowRec) #opens in read mode by default        
        data = f.read()
        print(data)
        f.close()
    except:
        print("Please enter correct name")
        return #end method, return None

    returnRec = f"text/Return-{name}.txt"
    borrowRec = f"text/Borrowed-{name}.txt"
    f = open(returnRec, "w+")
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
            f = open(returnRec, "a") #open in append mode
            f.write(f"\t{count_} \t\t{book}\t\t\t\t\t{lib.authorList[i]}\t\t\t\t{lib.priceList[i]}\n")
            count_ += 1
            f.close()
            total += float(lib.priceList[i])

            f = open(borrowRec)  #open in read mode
            lib.quantityList[i] = int(lib.quantityList[i]) + f.read().count(book)  #get how many times this string has repeated in file
            f.close()
            
    print(f"\t\t\t\t\t\t\t\t\t\t\t\t\t${total}")
    stat = int(input(("How many days ago did you borrow the book?: ")))
    if (stat > 10):
        fine = 2 * (stat - 10)
        f = open(returnRec, "a")
        f.write(f"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tFine: ${fine}\n")
        f.close()
        total = total + fine
        
    print(f"Final Total: ${total}")

    f = open(returnRec, "a")
    f.write(f"\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tTotal: ${total}")
    f.close()

    f = open("text/library.txt", "w+")
    for i in range(3):
        #writing new data to library record file
        f.write(f"{lib.bookList[i]},{lib.authorList[i]},{str(lib.quantityList[i])},${lib.priceList[i]}\n")
    f.close()
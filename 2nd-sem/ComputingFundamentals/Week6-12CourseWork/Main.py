from Utils import *


def init() -> None:  # -> None is an annotation indicating the method should always return void, doesn't affect anything
    """initialize the program"""
    while True:  # infinite loop
        print(f'''
        Welcome to Library Management System
{"-" * 100} 
        Enter 1 to display
              2 to borrow a book
              3 to return a book
              4 to exit
{"-" * 100} 
        ''')

        try:
            choice = int(input("Please select a number from 1 to 4: "))
            if choice == 1:
                f = open("text/library.txt")
                print(f.read() + "\n")
                f.close()
            elif choice == 2:
                Lib()  # initialize values of global lists
                Borrow()
            elif choice == 3:
                Lib()  # initialize values of global lists
                Return()
            elif choice == 4:
                print("Thank you for using our service")
                break  # get out of loop
            else:
                print("Invalid number. Please read instructions carefully.")
        except ValueError as err:  # if input can not be parsed
            print(f"Please input a valid number. {err}")


# initialize the program
init()

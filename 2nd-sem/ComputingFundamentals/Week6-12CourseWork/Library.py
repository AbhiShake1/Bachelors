"""Stores info about books in a 1D array(list) data structure"""
bookList = []
authorList = []
quantityList = []
priceList = []


def fill_data():
    """initializes the values of lists by reading the file and using proper data structures"""
    f = open("text/library.txt")
    content = [c.strip("\n") for c in f.readlines()]  # read and strip down line breaks, store lines in an array
    f.close()
    for i in range(len(content)):
        j = 0  # internal counter
        for c in content[i].split(","):
            if j == 0:  # for first element(there should normally be 4 because it is separated by comma in file)
                bookList.append(c)  # 1d list
            elif j == 1:
                authorList.append(c)
            # convert to int before appending
            elif j == 2:
                quantityList.append(int(c))
            # convert to float since price can be in decimal as well
            elif j == 3:
                priceList.append(float(c.strip("$")))  # remove/strip down $ chars
            j += 1

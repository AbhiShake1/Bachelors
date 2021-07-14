listLength = int(input("Enter the length of list: "))
list_ = []

for i in range(listLength):
    list_.append(int(input("Enter a number: ")))
    
uniqueList = []

for l in list_:
    if not (l in uniqueList): #checking if element to be appeneded already exists
        uniqueList.append(l)

#print(list_)
#print(uniqueList)

listLength = int(input("Enter the length of list: "))
list_ = []

for i in range(listLength):
    list_.append(int(input("Enter a number: ")))

#swapping
startIndex = 0
endIndex = listLength - 1
while (startIndex < endIndex):
    #wont need a new list since lists are mutable
    list_[startIndex], list_[endIndex] = list_[endIndex], list_[startIndex]  
    startIndex += 1
    endIndex -= 1

#print(list_)

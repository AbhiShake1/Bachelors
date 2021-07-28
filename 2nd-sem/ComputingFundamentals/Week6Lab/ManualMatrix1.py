m = int(input("Enter number of rows: "))
n = int(input("Enter number of columns: "))

list_ = []

for row in range(m):
    rowList = []
    
    for _ in range(n):
        rowList.append(3) #making all elements 3 initially
        
    rowList[row] = 1
    for u in range(row+1, len(rowList)):
        rowList[u] = 2
        
    list_.append(rowList)
    
#output matrix
for l in list_:
    [print(i, end=" ") for i in l]
    print() #line break after every inner iteration

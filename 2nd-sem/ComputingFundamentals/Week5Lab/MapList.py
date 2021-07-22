list1 = [1,2,3,4,5,6]
list2 = [2,4,6,8,10,12]

sumList = []

for i,j in zip(list1,list2):
    sumList.append(i+j)

[print(i, end=" ") for i in sumList]

list1 = ["a","b","c"]
list2 = [1,2,3]

finalList = []

for i,j in zip(list1,list2):
    finalList.append(i)
    finalList.append(j)

#print
[print(i, end=" ") for i in finalList]
    

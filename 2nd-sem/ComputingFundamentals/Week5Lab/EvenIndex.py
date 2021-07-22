nums = [43,23,21,44,56,75]

newList = []

for i in range(1,len(nums),2): #even position/ odd index
        newList.append(nums[i])

#print
#[print(i, end=" ") for i in newList]

myList = [1,5,5,5,5,1]
max = myList[0]
indexOfMax = 0
for i in range(1,len(myList)):
        if myList[i]>max:
                max = myList[i]
                indexOfMax=i
print(indexOfMax)

matrixList = [[24, 3, 6], [8, 12, 18], [2,66,7]]

for outer in matrixList:
    [print(i, end=" ") for i in outer if i%2==0 and i%3==0]
    print() #add line break after every inner array iteration

#suppose that first element is initially the smallest as well as largest
max_ = matrixList[0][0]
min_ = matrixList[0][0]

for outer in matrixList:
    for num in outer:
        if num > max_:
            max_ = num
        if num < min_:
            min_ = num

print(f"The largest element of the matrix is {max_} and the smallest is {min_}")

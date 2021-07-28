#given list
gList = [1,1,2,3,3,4,4,5,6,5,6]

#removing repeating elements
uList = list(set(gList))

#sorting in descending order using bubble sort
sorted_ = False

while not sorted_:
    nSwap = 0
    for i in range(1, len(uList)):
        if uList[i] > uList[i-1]:
            uList[i], uList[i-1] = uList[i-1], uList[i] #swap
            nSwap+=1
        if nSwap == 0:
            sorted_ = True #break outer while loop

[print(i) for i in uList] 

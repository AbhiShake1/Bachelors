unsortedArray = []

length = int(input("Enter length of array: "))
for _ in range(length):
    i = int(input("Enter the element: "))
    unsortedArray.append(i)

unsorted = True

while unsorted:
    nSwap = 0
    for i in range(1, len(unsortedArray)):
        if unsortedArray[i-1] > unsortedArray[i]:
            unsortedArray[i-1], unsortedArray[i] = unsortedArray[i], unsortedArray[i-1] #swap
            nSwap += 1
        if nSwap == 0:
            unsorted = False #break loop

#output
[print(i) for i in unsortedArray] #sorted array

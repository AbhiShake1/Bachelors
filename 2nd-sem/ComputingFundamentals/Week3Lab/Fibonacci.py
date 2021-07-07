i = 0
j = 1
temp = 1

limit = int(input("Enter the limit: "))

for n in range(limit):
    print(temp)
    temp = i+j
    i = j
    j = temp

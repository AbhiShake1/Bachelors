i = 0
j = 1
temp = 1
n=0

limit = int(input("Enter the limit: "))

while(n<limit):
    print(temp)
    temp = i+j
    i = j
    j = temp
    n+=1

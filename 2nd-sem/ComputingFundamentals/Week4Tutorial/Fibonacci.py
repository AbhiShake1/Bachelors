limit = int(input("Enter the limit: "))

a = 0
b = 1
temp = 1

fibo = []

for i in range(limit):
    fibo.append(temp) #adding to the end of list
    temp = a + b
    a = b
    b = temp

#printing
[print(i) for i in fibo]

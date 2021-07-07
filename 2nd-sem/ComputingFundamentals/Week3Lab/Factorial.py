factorial = 1

n = int(input("Enter a positive number: "))

counter = 1

while(n>=counter):
    factorial*=counter
    counter+=1

print(f"{n}! = {factorial}")

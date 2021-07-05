#1:
num = int(input("Enter a number:\n"))

if(num%2==0):
    print("The number is even")
else:
    print("The number is odd")



#2:
num1 = int(input("Enter first number:\n"))
num2 = int(input("Enter second number:\n"))
num3 = int(input("Enter third number:\n"))

if num1 == num2 == num3:
    print("All the numbers are equal")

elif num1 > num2 and num2 >= num3:
    print(f"{num1} is the greatest number")
    
elif num2 > num1 and num1 >= num3:
    print(f"{num2} is the greatest number")

else:
    print(f"{num3} is the greatest number")



#3
m = int(input("Enter a number:\n"))
n = int(input("Enter another number:\n"))

if m < n: #swap
    temp = m
    m = n
    n = temp
    
r = m % n;

while(r!=0):
    m = n
    n = r
    r = m % n
print(f"The GCD is {n}")

#4
n = int(input("Enter a non negative number:\n"))
factorial = 1
while(n > 1):
    factorial *= n
    n -= 1
print(f"The factorial of {n} is {factorial}")


#Homework
#1
n = int(input("Enter a number:\n"))
counter = 0
i = 2 #since 1 always divides all numbers

while n > i: #since the number divides itself too 
    if n % i == 0:
        counter+=1
    i+=1
    
if counter > 0 or n==2:
    print(f"{n} is composite")
else:
    print(f"{n} is prime")
    

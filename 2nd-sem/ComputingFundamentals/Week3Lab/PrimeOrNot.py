n = int(input("Enter positive a number: "))

counter = 0
c = 2

while n>c:
    if n%c==0:
        counter+=1
    c+=1

if counter>0 or n==2:
    print("The number is composite")

else:
    print("The number is prime")
    

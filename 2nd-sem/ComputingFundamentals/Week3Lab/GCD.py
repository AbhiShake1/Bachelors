m = int(input("Enter a number: "))
n = int(input("Enter another number: "))

if m < n: #swap
    m, n = n, m

r = m%n

while(r!=0):
    m = n
    n = r
    r = m%n

print(f"The GCD is {n}")

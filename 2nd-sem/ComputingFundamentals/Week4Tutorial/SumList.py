length = int(input("Enter length of list: "))

nums = []

for i in range(length):
    i = int(input("Enter the number: "))
    nums.append(i)

sumEven = 0
sumOdd = 0

for num in nums:
    num = int(num)
    if num % 2 == 0: #if even
        sumEven += num #sum of even numbers
    else: #if odd
        sumOdd += num #sum of odd numbers

print(f"The sum of even and odd numbers is {sumEven} and {sumOdd} respectively")

length = int(input("Enter length of list: "))

nums = []

for i in range(length):
    i = int(input("Enter the number: "))
    nums.append(i)

sum_ = 0

for num in nums:
    num = int(num)
    sum_+=num
    

print(f"The sum of numbers in given list is {sum_}")

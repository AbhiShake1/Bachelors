length = int(input("Enter length of list: "))

nums = []

for i in range(length):
    i = int(input("Enter the number: "))
    nums.append(i) #convert inputted string to int and add to end of nums list

#assuming that the first number is initially the smallest as well as largest,
max_ = nums[0]
min_ = nums[0]

for i in nums:
    if i > max_:
        max_ = i
    if i < min_:
        min_ = i

print(f"Max: {max_}, Min: {min_}")

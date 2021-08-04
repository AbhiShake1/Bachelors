def sumOfString(nums) -> int:
    sum_ = 0

    for num in nums:
        if num.isnumeric():
            sum_ += int(num) #convert to int and add

    return sum_

nums = input("Enter a number: ")

print("The sum is", sumOfString(nums))

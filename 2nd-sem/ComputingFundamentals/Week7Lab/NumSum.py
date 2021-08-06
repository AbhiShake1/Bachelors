def sum_(num):
    num = list(str(num))
    sum_ = 0
    for n in num:
        sum_ += int(n)
    print(sum_)

sum_(int(input("Enter a number: ")))

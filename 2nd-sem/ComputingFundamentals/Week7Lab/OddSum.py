def oddSum(limit):
    sum_ = 0
    for n in range(1, limit+1): #rangeClosed
        if n%2 != 0: #if odd
            sum_ += n
    return sum_

#invoke
l = int(input("Enter limit: "))
sum_ = oddSum(l);

#output
print(sum_)

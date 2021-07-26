set_ = {}

num = int(input("Enter number of students: "))

for i in range(num):
    name = input(f"Enter name of student {i+1}: ")
    marks = float(input("Enter the marks obtained: "))
    set_[name] = marks

#print
[print(k,v) for k,v in set_.items()]

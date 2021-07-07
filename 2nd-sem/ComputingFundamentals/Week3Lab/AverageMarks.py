name = input("Enter name of student: ")

m1 = float(input("Enter marks obtained in maths: "))
m2 = float(input("Enter marks obtained in computing fundamentals: "))
m3 = float(input("Enter marks obtained in hardware architecture: "))
m4 = float(input("Enter marks obtained in programming: "))
m5 = float(input("Enter marks obtained in information systems: "))

average = (m1+m2+m3+m4+m5)/5

print(f"Name of student: {name}")
print(f"Marks: {m1}, {m2}, {m3}, {m4}, {m5}")
print(f"Average marks: {average}")

if average <= 100 and average >= 70:
    print("Grade A")

elif average <= 69 and average >= 60:
    print("Grade B")

elif average <= 59 and average >= 50:
    print("Grade C")

elif average <= 49 and average >= 43:
    print("Grade D")

elif average <= 42 and average >= 40:
    print("Grade E")

elif average <= 39 and average >= 0:
    print("Grade F")

else:
    print("Invalid marks")

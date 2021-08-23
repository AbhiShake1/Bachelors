def calcMarks(dict):
    highest = 0 #very low num initially as highest
    lowest = 100 #very big num initially as lowest
    sum = 0
    for m in dict.values():
        m = int(m)
        sum += m
        if m > highest:
            highest = m
        if m < lowest:
            lowest = m
    
    average = sum / len(dict)
    return highest, lowest, average #return tuple


marks = {}
n = input("Enter number of students: ")
for i in range(int(n)):
    n = input(f"Enter name of student {i+1}: ")
    m = input(f"Enter marks of student {i+1}: ")
    marks[n] = m

c = calcMarks(marks)
f = open("result.txt", "w")
f.write(f"highest: {c[0]}, lowest: {c[1]}, average: {c[2]}")
f.close()
    

''' 2:'''
print("Hello world")
[print("Hello world",end=" ") for i in range(10)] #comprehending list and printing 10 times

'''3:'''
n = input("Enter your name: ")
print(f"Hello {n}, have a nice day")
'''4:'''
i = int(input("enter a nummber: "))
j = int(input("enter another nummber: "))
print(f"the sum and difference of {i} and {j} is {i+j} and {abs(i-j)} respectively")
'''5:'''
i = int(input("enter x: "))
j = int(input("enter y: "))
v = (x**3)+(3*(x*x)*y)+(3*x*(y*y))+(y**3)
print(f"The value is {v}")
'''6:'''
PI = 22/7;
#taking input from console and storing in r
r = float(input("Enter radius of circle:\n")) #converting to float since it takes string input
a = PI*(r**2) #calculating area of circle
print(f"The area of given circle is {a}")
'''7:'''
l = int(input("Enter length of rectangle: "))
b = int(input("Enter breadth of rectangle: "))
print(f"area: {l*b} \n perimeter: {2*(l+b)}")
'''8:'''
a = int(input("Enter value of a: "));
b = int(input("Enter value of b: "));
c = int(input("Enter value of c: "));
root = ((b**2)-(4*a*c))**0.5 #**0.5 or **(1/2) -> sq root
x1 = (-b+root)/2*a
x2 = (-b-root)/2*a
print(f"The roots of given quadratic equation are: {x1} and\n {x2}")
'''9:'''
a = int(input("Enter value of a: "))
b = int(input("Enter value of b: "))
print(f"The value of a is {a} and b is {b} before swapping")
temp = a #backing up original value of a
a = b
b = temp
'''
#using tuples to swap
a,b = b,a
'''
print(f"The value of a is {a} and b is {b} after swapping")

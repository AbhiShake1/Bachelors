class Rectangle():
    def __init__(this, length, breadth):
        this.length = length
        this.breadth = breadth

    def area(this):
        return this.length * this.breadth

    def perimeter(this):
        return 2 * (this.length + this.breadth)

r = Rectangle(2, 2)
print(r.area())
print(r.perimeter())

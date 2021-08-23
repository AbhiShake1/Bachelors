class Circle():
    def __init__(this, diameter):
        this.diameter = diameter
        this.radius = diameter/2

    def area(this):
        return 3.14 * (this.radius**2)


c1 = Circle(4)
print(c1.area())

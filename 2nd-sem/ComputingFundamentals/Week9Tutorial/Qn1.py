class Student():
    def __init__(self, name, maths, science, english): #initializer
        self.name = name
        self.maths = maths
        self.science = science
        self.english = english

    def get_lname(self): #self->class reference
        last = self.name.split(" ") #split by space char and create an array
        return last[-1] #return last index of the array

    def get_average(self):
        total = self.maths + self.science + self.english
        return total/3 #avg=total/n

#outside class
s1 = Student("Harry Potter", 80, 80, 80)
print(s1.get_lname())
print(s1.get_average())

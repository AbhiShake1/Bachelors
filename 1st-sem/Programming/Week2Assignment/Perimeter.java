import java.util.Scanner;

public class Perimeter
{
       /*
        *This {} is an example of constructor <init> method and Scanner is a parameter. It receives a value when the method is invoked.
        *It can be used as local variable.
        *It is the method that loads at first when a class is invoked.
       */
       Perimeter(Scanner sc){    
           float l,b,perimeter; //declaring variables
           
           System.out.println("Enter the length of Rectangle: ");

           l = sc.nextFloat(); //stores the input received in a float variable 'l'

           System.out.println("Enter the width of Rectangle: ");

           b = sc.nextFloat();

           perimeter = 2*(l + b);

           System.out.println("The perimeter of given Rectangle is " + perimeter); 
       }
}

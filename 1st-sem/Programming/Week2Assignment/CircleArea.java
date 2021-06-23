import java.util.Scanner;

public class CircleArea
{
    CircleArea(Scanner sc){
        double A, C, r;
        
        System.out.println("Enter the radius of circle");
        
        r = sc.nextDouble();
        
        A=3.14*Math.pow(r,(int)2);
        
        C=2*3.14*r;
        
        System.out.println("The Area of given circle is "+ A +"\nThe circumference of given circle is "+ C);
    }
}

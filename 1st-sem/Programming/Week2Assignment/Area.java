import java.util.Scanner;

public class Area
{
    Area(Scanner sc){
        int A,h,l,b;

        System.out.println("Enter the length of wall: ");

        l = sc.nextInt();
        
        System.out.println("Enter the breadth of wall: ");

        b = sc.nextInt();
        
        System.out.println("Enter the height of wall: ");

        h = sc.nextInt();
        
        A=2*h*(l+b);
        
        System.out.println("The area of 4 walls is "+A);
    }
}

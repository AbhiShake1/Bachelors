import java.util.Scanner;

public class Average
{
    Average(Scanner sc){
        float a,b,c,average;

        System.out.println("Enter the first number: ");

        a = sc.nextFloat();
        
        System.out.println("Enter the second number: ");

        b = sc.nextFloat();
        
        System.out.println("Enter the third number: ");

        c = sc.nextFloat();
        
        average=(a+b+c)/3;
        
        System.out.println("The average of given 3 numbers is "+average);
    }
}


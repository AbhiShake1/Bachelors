import java.util.Scanner;

public class LargestNumber
{
    LargestNumber(Scanner sc){
        int i1, i2, isLarger;
        
        System.out.println("Enter the first number ");
        
        i1 = sc.nextInt();
        
        System.out.println("Enter the second number ");
        
        i2 = sc.nextInt();
        
        isLarger = i1 >= i2 ? i1==i2 ? i1=i2 : i1 : i2; 
        
        System.out.println("The larger number is "+isLarger);
        
        new Index().askFurther();
    }
}

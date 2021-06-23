import java.util.Scanner;

public class Distance
{
    Distance(Scanner sc){
        float s,u,t,a;
        
        System.out.println("Enter initial velocity (u)");
        
        u = sc.nextFloat();
        
        System.out.println("Enter time taken (t)");
        
        t = sc.nextFloat();
        
        a=9.8f;
        
        float t2=(float)Math.pow(t, (int)2);
        
        s=(u*t)+(a*t2)/2;
        
        System.out.println("The distance covered by the given body is "+s);
    }
}

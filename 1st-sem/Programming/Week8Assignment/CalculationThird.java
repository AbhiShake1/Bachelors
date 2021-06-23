import static java.lang.System.out;

public class CalculationThird extends CalculationSecond{
    public void fibonacci(){
        System.out.println("Fibonacci:");
        int a=0,b=1,limit=10,backup=0;
        out.println(a);
        out.println(b);
        for(int i=0;i<=limit;i++){
            backup=a+b;
            a=b;
            b=backup;
            out.println(backup);
        }
    }
}
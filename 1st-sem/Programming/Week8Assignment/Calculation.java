import static java.lang.System.out;

public class Calculation{
    public void add(int a, int b){
        int sum=a+b;
        out.printf("The sum of %d and %d is %d\n",a,b,sum);
    }
    public void subtract(int a, int b){
        int sub=a-b;
        out.printf("%d - %d is %d\n",a,b,sub);
    }
    public void multiply(int a, int b){
        int mul=a*b;
        out.printf("The multiplication of %d and %d is %d\n",a,b,mul);
    }
}
public class CalcFactorial{
    public static void getFactorial(int i){
        int factorial=1;
        for(int j=1;j<=i;j++){
            factorial*=j;
        }
        System.out.printf("factorial of %d is %d",i,factorial);
    }
}
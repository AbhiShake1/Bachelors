public class CalculationSecond extends Calculation{
    public void factorial(int a){
        int factorial=1;
        for(int i=1;i<=a;i++){
            factorial*=i;
        }
        System.out.printf("The factorial of %d is %d\n",a,factorial);
    }
}
import java.util.Scanner;

public class Square{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Input a number");
        float num = sc.nextFloat();
        float square=new Square().square(num);
        System.out.println("The square of "+num+" is "+square);
        System.out.println("Do you want to find squares of more numbers?(Y/N)");
        String yesNo = new Scanner(System.in).nextLine();
        if(yesNo.equalsIgnoreCase("y")){
            main(args);
        }else{
            System.out.println("Thank you for trying");
            sc.close();
        }    
    }
    private float square(float num){
        return (float)Math.pow(num,2);
    }
}

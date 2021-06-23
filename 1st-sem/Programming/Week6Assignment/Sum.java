import java.util.Scanner;

public class Sum{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Input any 2 numbers separated by \",\"");
        String numStr=sc.nextLine();
        String[] numArr=numStr.split(",");
        int sum = new Sum().sumOf(numArr);
        System.out.println("The sum is "+sum);
        System.out.println("Do you want to find sum of more numbers?(Y/N)");
        String yesNo=sc.nextLine();
        if(yesNo.equalsIgnoreCase("y")){
            main(args);
        }else{
            System.out.println("Thank you for trying");
            sc.close();
        }
    }
    private int sumOf(String[] numArr){
        int sum=0;
        for(String s : numArr){
            sum+=Integer.parseInt(s);
        }
        return sum;
    }
}
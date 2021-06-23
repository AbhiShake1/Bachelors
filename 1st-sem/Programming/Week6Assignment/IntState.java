import java.util.Scanner;

public class IntState{
    public static void main(String[] args){
        System.out.println("Input a number");
        int i = new Scanner(System.in).nextInt();
        new IntState().num(i);
        System.out.println("Do you want to continue?(Y/N)");
        String yesNo = new Scanner(System.in).nextLine();
        if(yesNo.equalsIgnoreCase("y")){
            main(args);
        }else{
            System.out.println("Good bye");
        }
    }
    public void num(int i){
        if(i<0){
            System.out.println(i+" is negative");
        }else if(i>0){
            System.out.println(i+" is positive");
        }else{
            System.out.println(i+" is 0");
        }
        if(i%2==0){
            System.out.println(i+" is even");
        }else{
            System.out.println(i+" is odd");
        }
    }
}
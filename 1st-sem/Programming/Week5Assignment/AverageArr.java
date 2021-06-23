import java.util.Scanner;

public class AverageArr{
    public static void main(String[] nums){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers separated by \",\"");
        String values = sc.nextLine();
        //sc.close();
        nums = values.split(",");
        float avg=0.0f;
        for(String str : nums){
            avg+=Integer.valueOf(str);
        }
        avg = avg/nums.length;
        System.out.println("The arerage of inputted "+nums.length+" numbers is "+avg);
        System.out.println("Again? (Y/N)");
        String yesNo = sc.nextLine();
        if(yesNo.equalsIgnoreCase("y")){
            main(nums);
        }else{
            System.out.println("Thank you for trying");
            sc.close();
        }
    }
}
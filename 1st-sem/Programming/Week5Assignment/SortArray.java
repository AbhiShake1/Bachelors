import java.util.Scanner;
import java.util.ArrayList;

public class SortArray{
    public static void main(String[] args){
        //int[] iArr = {0,2,3,7,4,5,6};
        Scanner sc = new Scanner(System.in);
        System.out.println("Input numbers in random order separated by \",\" to sort");
        String[] stArr = (sc.nextLine()).split(",");
        ArrayList arrayList = new ArrayList<Integer>();
        for(String s : stArr){
            arrayList.add(Integer.valueOf(s));
        }
        Object[] iArr=arrayList.toArray();
        java.util.Arrays.sort(iArr);
        System.out.println("Sorted in ascending order successfully");
        for(Object obj : iArr){
            System.out.println(obj);
        }
        System.out.println("Sort other numbers? (Y/N)");
        String yesNo = sc.nextLine();
        if(yesNo.equalsIgnoreCase("y")){
            main(args);
        }else{
            System.out.println("Thank yu and good bye");
            sc.close();
        }
    }
}
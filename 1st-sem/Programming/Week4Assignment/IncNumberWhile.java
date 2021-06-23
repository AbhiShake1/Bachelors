public class IncNumberWhile{
    public static void main(String[] args){
        int i=4;
        int j;
        int num=1;
        while(i>=1){
            j=i;
            while(j<=4){
                System.out.print(num);
                j++;
            }
            num++;
            System.out.print("\n");
            i--;
        }
    }
}
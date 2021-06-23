public class NumberWhile{
    public static void main(String[] args){
        int i=4;
        int j;
        while(i>=1){
            int num=1;
            j=i;
            while(j<=4){
                System.out.print(num);
                num++;
                j++;
            }
            System.out.print("\n");
            i--;
        }
    }
}
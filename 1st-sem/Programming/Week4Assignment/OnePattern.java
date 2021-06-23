public class OnePattern{
    public static void main(String[] args){
        int i=4;
        int j;
        while(i>=1){
            j=i;
            while(j<=4){
                System.out.print(1);
                j++;
            }           
            System.out.print("\n");
            i--;
        }
    }
}
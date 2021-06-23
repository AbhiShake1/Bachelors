public class IncNumPattern{
    public static void main(String[] args){
        int i=1;
        int j;
        int num=4;
        String space=" ";
        while(i<=4){
            j=i;
            while(j<=4){
                System.out.print(i);
                j++;
            }
            System.out.print("\n"+space);
            space+=" ";
            num--;
            i++;
        }
    }
}
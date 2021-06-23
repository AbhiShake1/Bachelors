public class ReverseNumPattern{
    public static void main(String[] args){
        int i=1;
        int j;
        int num=5;
        String space=" ";
        while(i<=5){
            j=i;
            while(j<=5){
                System.out.print(num);
                j++;
            }
            System.out.print("\n"+space);
            space+=" ";
            num--;
            i++;
        }
    }
}
public class SumDoWhile{
    public static void main(String[] args){
        int i=1;
        int j=0;
        do{
            j=(i*i)+j;
            i++;
        }while(i<=10);
        System.out.println(j);
    }
}
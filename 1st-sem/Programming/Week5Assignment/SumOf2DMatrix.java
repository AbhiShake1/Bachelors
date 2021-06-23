public class SumOf2DMatrix{
    public static void main(String[] args){
        int iArr[][]={{1,2,3},{4,5,6}};
        int sum=0;
        for(int[] i : iArr){
            for(int j : i){
                sum+=j;
            }
        }
        System.out.print("The sum of consructed 2x3 matrix is "+sum);
    }
}
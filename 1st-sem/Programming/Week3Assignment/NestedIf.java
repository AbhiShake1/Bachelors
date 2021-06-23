public class NestedIf
{
    {
        String msg="";
        int i = 5;
        if(i%3==0){
            if(i%5==0){
                msg=i+" is divisible by both 3 and 5\n";
            }
            else{
                msg=i+" is divisible by 3 but not by  5\n";
            }
        }
        else{
            if(i%5==0){
                msg=i+" is not divisible by 3 but divisible by 5\n";
            }
            else{
                msg=i+" is not divisible by both 3 and 5\n";
            }
        }
        System.out.print(msg);
    }
}

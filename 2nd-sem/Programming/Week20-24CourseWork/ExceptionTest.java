public class ExceptionTest{
    private void a(){
        System.out.println("doesnt throw");
    }
    
    private int a(){
        System.out.println("throws. returns int");
        return 0;
    }
    
    private int a(String str){
        System.out.println("throws "+str);
        return 0;
    }
    
    private void a() throws Exception{
        throw new Exception("Exception occured");
    }
}
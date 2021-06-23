public class Student{
    public static void main(String[] args){
        new Student().info("Ram,10,101");
    }
    private void info(String str){
        String[] infoArr="name: ,age: ,Roll no.: ".split(",");
        String[] stArr=str.split(",");
        for(int i=0;i<stArr.length;i++){
            System.out.println(infoArr[i]+stArr[i]);
        }
        
    }
}
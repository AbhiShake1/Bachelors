public class A{
    public static void main(String[] args){
        A a = new A();
        a.show();
        B b = new B();
        b.msg();
    }
    private void show(){
        System.out.print("Hello from the show method\n");
    }
}
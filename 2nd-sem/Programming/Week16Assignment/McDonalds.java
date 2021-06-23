public class McDonalds extends Restaurant{
    public void totalPrice(int price){
        var tax = (6*price)/100;
        System.out.println(price+tax);
    }

    public void menuItems(){

    }

    public String location(){
        return "New Baneshwor";
    }

    public boolean hasPlayPlace(){
        return false;
    }
    /*
    public static void main(String[] args){
    Restaurant r = new McDonalds();
    r.name();
    r.totalPrice(5000);
    }
     */

}
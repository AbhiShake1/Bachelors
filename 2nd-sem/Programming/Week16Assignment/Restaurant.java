public abstract class Restaurant{
    protected void name(){
        System.out.println(this.getClass().getName());
    }

    protected abstract void totalPrice(int price);

    protected abstract void menuItems();

    protected abstract String location();
}
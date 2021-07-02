public class Bus{
    private String numberPlate, color, route, customerName;
    private boolean available;
    private int rate;

    public Bus(String numberPlate, String color, String route, 
    String customerName, boolean available, int rate){
        this.numberPlate=numberPlate;
        this.color=color;
        this.route=route;
        this.customerName=customerName;
        this.available=available;
        this.rate=rate;
    }

    public String getNumberPlate(){return numberPlate;}

    public String getColor(){return color;}

    public String getRoute(){return route;}

    public String getCustomerName(){return customerName;}

    public boolean getAvailable(){return available;}

    public int getRate(){return rate;}

    public void setNumberPlate(String numberPlate){this.numberPlate=numberPlate;}

    public void setColor(String color){this.color=color;}

    public void setRoute(String route){this.route=route;}

    public void setCustomerName(String customerName){this.customerName=customerName;}

    public void setAvailable(boolean available){this.available=available;}

    public void setRate(){this.rate=rate;}
}
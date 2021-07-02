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

    public void setNumberPlate(){this.numberPlate=numberPlate;}

    public void setColor(){this.color=color;}

    public void setRoute(){this.route=route;}

    public void setCustomerName(){this.customerName=customerName;}

    public void setAvailable(){this.available=available;}

    public void setRate(){this.rate=rate;}
}
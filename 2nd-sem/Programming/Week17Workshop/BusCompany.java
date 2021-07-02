import java.util.List;
import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.Random;

public class BusCompany{
    private static List<Bus> busList = new ArrayList();

    public void add(){
        Bus b1 = new Bus("ABC123","red","ktm-kep","person1",true,1100);
        Bus b2 = new Bus("ABC124","green","ktm-skt","person2",true,1500);
        Bus b3 = new Bus("ABC125","blue","ktm-pkr","person3",false,1200);
        Bus b4 = new Bus("ABC126","green","kep-ktm","person4",true,900);
        Bus b5 = new Bus("ABC127","white","skt-ktm","person5",true,700);
        Bus b6 = new Bus("ABC128","yellow","pkr-ktm","person6",false,400);
        busList.add(b1);
        busList.add(b2);
        busList.add(b3);
        busList.add(b4);
        busList.add(b5);
        busList.add(b6);
    }

    public void remove(int index){//throw error if invalid index
        //since index starts from 0 and ends in size-1,;
        if(index>busList.size()-1 || index<0) System.err.println("Illegal index");
        busList.remove(index);
        System.out.println("removed data from index "+index);
    }

    //for reusability
    Consumer<Bus> details = b->System.out.printf(
                "number plate: %s, color: %s, route: %s, rate: %d, available?: %b\n",
                b.getNumberPlate(),b.getColor(),b.getRoute(),b.getRate(),b.getAvailable()
            );

    public void book(boolean available){
        if(available){
            System.out.println("bus is boooked with following details:");
            int busNum = new Random().nextInt(busList.size()-1);
            Bus bus = busList.get(busNum);
            System.out.printf(
                "number plate: %s, color: %s, route: %s, rate: %d, available?: %b\n",
                bus.getNumberPlate(),bus.getColor(),bus.getRoute(),bus.getRate(),bus.getAvailable()
            );
            bus.setAvailable(false);
        }else{
            System.out.println("Not available. Can not be booked currently");
        }
    }

    public void display(){
        busList.forEach(details);
    }

    public void displayIfLessThan500(){
        busList.stream().filter(b->b.getRate()<500)
        .forEach(details);
    }

    public void displayIfRB(){
        busList.stream().filter(b->b.getColor()=="red" 
                || b.getColor()=="blue")
        .forEach(details);
    }

    public void displayIfGG500(){
        //using streams and predicate to shorten
        busList.stream().filter(l->l.getColor().equalsIgnoreCase("green") 
                && l.getRate()>500).forEach(details);
    }
}
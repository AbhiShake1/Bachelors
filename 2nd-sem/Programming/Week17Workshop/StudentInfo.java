import java.util.ArrayList;
import java.util.List;

public class StudentInfo{
    public static void main(String[] args){
        List<Student> students = new ArrayList();
        //creating instances of the class
        Student ayush = new Student("Ayush","L1N1",9876543210L);
        Student rahul = new Student("Rahul","L1M1",9876543211L);
        Student gaurav = new Student("Gaurav","L1N2",9876543212L);
        //adding to list
        students.add(ayush);
        students.add(rahul);
        students.add(gaurav);
        //displaying values by passing a consumer
        students.forEach((l)->System.out.println(l.getName()+" "+l.getGroup()+" "+l.getPhone()));
        //changing group of rahul
        students.get(students.indexOf(rahul)).setGroup("L1N2");
        //removing gaurav from list
        students.remove(gaurav);
        //creating instance of new student
        Student aavaya = new Student("Aavaya","L1C1",9876543213L);
        //adding new student before ayush
        students.add(0,aavaya);//adding in x index pushes index>x by 1 index
        //changing name of Ayush to Aayush
        //getting index of ayush object
        students.get(students.indexOf(ayush)).setName("Aayush");
        //replacing aavayas info with gauravs info
        //1st->list name, 2nd -> target, 3rd-> replacement
        //cant use list.set(obj,obj2);
        java.util.Collections.replaceAll(students, aavaya, gaurav);
        //dispplaying with ordinary for loop
        for(int i=0;i<students.size();i++){
            System.out.println(students.get(i).getName()+" "+students.get(i).getGroup()+" "+students.get(i).getPhone());
        }
    }
}
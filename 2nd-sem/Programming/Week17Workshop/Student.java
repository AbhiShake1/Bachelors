public class Student{
    private String name, group;
    long phone;

    public Student(String name, String group, long phone){
        this.name=name;
        this.group=group;
        this.phone=phone;
    }

    public void setName(String name){
        this.name=name;
    }

    public void setGroup(String name){
        this.group=group;
    }

    public void setPhone(String name){
        this.phone=phone;
    }

    public String getName(){return name;}

    public String getGroup(){return group;}

    public long getPhone(){return phone;}
}
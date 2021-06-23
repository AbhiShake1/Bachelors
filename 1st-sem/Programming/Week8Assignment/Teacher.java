public class Teacher{
    private String designation="Teacher";
    private String collegeName="Islington";
    public String getDesignation(){
        return designation;
    }
    public void setDesignation(String designation){
        this.designation=designation;
    }
    public String getCollegeName(){
        return designation;
    }
    public void setCollegeName(String collegeName){
        this.collegeName=collegeName;
    }
    public void does(){
        System.out.print("Teaching\n");
    }
}
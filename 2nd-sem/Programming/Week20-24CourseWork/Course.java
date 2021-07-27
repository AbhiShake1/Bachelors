import static java.lang.System.out;

public abstract class Course{
    protected String courseID, courseName, completionDate, courseLeader;
    protected int duration;
    public Course(String courseID, String courseName, int duration){
        this.courseID = courseID;
        this.courseName = courseName;
        this.duration = duration;
        completionDate = "";
        courseLeader = "";
    }

    public String getCourseID(){
        return courseID;
    }

    //display suitable values
    public void display(){
        out.println("courseID: "+courseID);
        out.println("courseName: "+courseName);
        out.println("duration: "+duration);
        if(!courseLeader.isBlank()){
            out.println("courseLeader: "+courseLeader);
        }
    }
}
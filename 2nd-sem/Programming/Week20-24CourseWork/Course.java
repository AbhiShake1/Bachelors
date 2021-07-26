public abstract class Course{
    protected String courseID, courseName, completionDate;
    protected int duration;
    public Course(String courseID, String courseName, int duration){
        this.courseID = courseID;
        this.courseName = courseName;
        this.duration = duration;
        completionDate = "";
    }
    
    public String getCourseID(){
        return courseID;
    }
}
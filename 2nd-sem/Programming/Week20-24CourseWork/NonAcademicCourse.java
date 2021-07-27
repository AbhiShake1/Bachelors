import static java.lang.System.out;

public class NonAcademicCourse extends Course{
    private final String level, prerequisite;
    private String instructorName, examDate, startDate;
    private boolean isRegistered;
    
    public NonAcademicCourse(String courseID, String courseName, int duration, String level, String prerequisite){
        super(courseID, courseName, duration);
        this.prerequisite = prerequisite;
        this.level = level;
        examDate = "";
        startDate = "";
        completionDate = "";
        isRegistered = false;//reset for every instance
    }
    
    public void display(){
        out.println("Course ID: "+super.courseID);
        out.println("Course Name: "+super.courseName);
        out.println("Duration: "+super.duration);
        if(isRegistered){
            //print values from this class if course has been registered 
            out.println("Instructor Name: "+instructorName);
            out.println("Starting Date: "+startDate);
            out.println("Completion Date: "+completionDate);
            out.println("Exam Date: "+examDate);
        }
        StringBuilder info = new StringBuilder("Non Academic Course:\n");
        if(!courseID.isBlank()) info.append("Course ID: "+courseID+"\n");
        if(!courseName.isBlank()) info.append("Course name: "+courseName+"\n");
        if(!level.isBlank()) info.append("Level: "+level+"\n");
        info.append("Duration: "+duration+"\n");
        System.out.println(info);
    }
    
    public void register(String courseLeader, String instructorName, String startDate, String completionDate, String examDate){
        if(!isRegistered){
            this.instructorName = instructorName;
            this.startDate=startDate;
            this.completionDate=completionDate;
            this.examDate=examDate;
            super.courseLeader = courseLeader;
            isRegistered=true; //if block will not be executed next time if isRegertered is true
        }else{
            System.out.println("The course has already been registered"); //write a message to console if course has already been registered
        }
    }
}
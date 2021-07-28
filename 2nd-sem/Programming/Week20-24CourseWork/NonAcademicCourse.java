import static java.lang.System.out;
import javax.swing.JOptionPane;

public class NonAcademicCourse extends Course{
    private final String level, prerequisite;
    private String instructorName, examDate, startDate;
    private boolean isRegistered, isRemoved;

    public NonAcademicCourse(String courseID, String courseName, int duration, String level, String prerequisite){
        super(courseID, courseName, duration);
        this.prerequisite = prerequisite;
        this.level = level;
        examDate = "";
        startDate = "";
        completionDate = "";
        isRegistered = false;//reset for every instance
        isRemoved = false;
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
            JOptionPane.showMessageDialog(
                INGCollege.getInstance().getFrame(),"The course has already been registered.",
                "Warning",JOptionPane.WARNING_MESSAGE
            ); //pop if course has already been registered
        }
    }

    //reset values
    public void remove(){
        if(isRemoved){
            JOptionPane.showMessageDialog(
                INGCollege.getInstance().getFrame(),"The course has already been removed.",
                "Warning",JOptionPane.WARNING_MESSAGE
            );
        }else{
            //remove values of variables bellow(set values to empty string)
            courseLeader = "";
            startDate = "";
            completionDate = "";
            examDate = "";
            isRegistered = false; 
            isRemoved = true;
        }
    }
}
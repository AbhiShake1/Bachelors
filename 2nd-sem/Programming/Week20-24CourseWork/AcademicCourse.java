import static java.lang.System.out;

public class AcademicCourse extends Course{
    private final String level;
    private final int noOfAssessments, credit;
    private String startingDate, lecturerName;
    private boolean isRegistered;
    //injecting dependency once without setters. Variables can only be changed in another instance
    public AcademicCourse(String courseID, String courseName, int duration, String level, int credit, int noOfAssessments){
        super(courseID, courseName, duration);
        this.level = level;
        this.credit = credit;
        this.noOfAssessments = noOfAssessments;
        lecturerName = "";
        startingDate = "";
        completionDate = "";
        isRegistered = false;//reset for every instance
    }
    //instance variables ported over, don't need a super keyword
    public void display(){
        super.display();
        if(isRegistered){
            out.println("Lecturer Name: "+lecturerName);
            out.println("Level: "+level);
            out.println("Starting Date: "+startingDate);
            out.println("Completion Date: "+completionDate);
            out.println("Number Of Assessments: "+noOfAssessments);
        }
    }

    public void register(String courseLeader, String lecturerName, String startingDate, String completionDate){
        if(isRegistered){
            out.println("Lecturer name: "+this.lecturerName);
            out.println("Starting date: "+this.startingDate);
            out.println("Completion date: "+this.completionDate);
        }else{
            this.lecturerName = lecturerName;
            this.startingDate = startingDate;
            this.completionDate = completionDate;
            super.courseLeader = courseLeader;
            isRegistered = true;
        }
    }
}
public class AcademicCourse extends Course{
    private final String level;
    private final int noOfAssessments, credit;
    private String startingDate, lecturerName, courseLeader;
    //injecting dependency once without setters. Variables can only be changed in another instance
    public AcademicCourse(String courseID, String courseName, int duration, String level, int credit, int noOfAssessments){
        super(courseID, courseName, duration);
        this.level = level;
        this.credit = credit;
        this.noOfAssessments = noOfAssessments;
    }
    //instance variables ported over, don't need a super keyword
    @Override //from Object class
    public String toString(){
        StringBuilder info = new StringBuilder("Academic Course:\n");
        if(!courseID.isBlank()) info.append("Course ID: "+courseID+"\n");
        if(!courseName.isBlank()) info.append("Course name: "+courseName+"\n");
        if(!level.isBlank()) info.append("Level: "+level+"\n");
        info.append("Credit: "+credit+"\n");
        info.append("Number of assessments: "+noOfAssessments+"\n");
        info.append("Duration: "+duration+"\n");
        return info.toString();
    }
    
    private boolean isRegistered;
    
    public void register(String courseLeader, String lecturerName, String startingDate, String completionDate){
        if(isRegistered){
            System.out.println("Lecturer name: "+this.lecturerName);
            System.out.println("Starting date: "+this.startingDate);
            System.out.println("Completion date: "+this.completionDate);
        }else{
            this.lecturerName = lecturerName;
            this.startingDate = startingDate;
            this.completionDate = completionDate;
            this.courseLeader = courseLeader;
            isRegistered = true;
        }
    }
}
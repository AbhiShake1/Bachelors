public class AcademicCourse extends Course{
    private final String courseID, courseName, level;
    private final int duration, noOfAssessments, credit;
    
    public AcademicCourse(String courseID, String courseName, int duration, String level, int credit, int noOfAssessments){
        super(courseID, courseName, duration);
        this.courseID = courseID;
        this.courseName = courseName;
        this.duration = duration;
        this.level = level;
        this.credit = credit;
        this.noOfAssessments = noOfAssessments;
    }
    
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
}
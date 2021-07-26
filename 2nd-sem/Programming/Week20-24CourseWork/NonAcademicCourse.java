public class NonAcademicCourse extends Course{
    private final String level, prerequisite;
    private String instructorName, examDate, startDate;
    
    public NonAcademicCourse(String courseID, String courseName, int duration, String level, String prerequisite){
        super(courseID, courseName, duration);
        this.prerequisite = prerequisite;
        this.level = level;
        examDate = "";
        startDate = "";
        completionDate = "";
    }
    
    @Override //from object class
    public String toString(){
        StringBuilder info = new StringBuilder("Non Academic Course:\n");
        if(!courseID.isBlank()) info.append("Course ID: "+courseID+"\n");
        if(!courseName.isBlank()) info.append("Course name: "+courseName+"\n");
        if(!level.isBlank()) info.append("Level: "+level+"\n");
        info.append("Duration: "+duration+"\n");
        return info.toString();
    }
    
    private boolean isRegistered;
    
    public void register(String courseLeader, String instructorName, String startDate, String completionDate, String examDate){
        if(!isRegistered){
            this.instructorName = instructorName;
            this.startDate=startDate;
            this.completionDate=completionDate;
            this.examDate=examDate;
            isRegistered=true; //if block will not be executed next time if isRegertered is true
        }else{
            System.out.println("The course has already been registered"); //write a message to console if course has already been registered
        }
    }
}
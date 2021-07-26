public class NonAcademicCourse extends Course{
    String courseID, courseName, level, prerequisite;
    int duration;
    
    public NonAcademicCourse(String courseID, String courseName, int duration, String level, String prerequisite){
        super(courseID, courseName, duration);
        this.courseID = courseID;
        this.courseName = courseName;
        this.prerequisite = prerequisite;
        this.duration = duration;
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
}
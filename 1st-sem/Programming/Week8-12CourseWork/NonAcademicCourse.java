/*
 * AcademicCourse is subclass of Course class and extends it with additional attributes and properties
 * Created on Sat May 01 20:10 2021
 * @Author: Abhishek Pandey
 */

import static java.lang.System.out; //import static variable 'out' from System class

public class NonAcademicCourse extends Course/*inherits public,protected methods and variables from Course class*/{
    //private variables, can not be directly accessed by other classes
    private String instructorName, startDate, completionDate, examDate, prerequisite;
    private int duration;
    private boolean isRegistered, isRemoved;
    //parameterised constructor
    public NonAcademicCourse(String courseID, String courseName, int duration, String prerequisite){
        super(courseID, courseName, duration);
        //set initial values when object is created
        this.prerequisite=prerequisite; //need 'this' keyword here because there is variable with conflicting name in parameter.
        //'this' keyword points it to this class(NonAcademicsCourse) and the keyword can only be used in instance methods.
        startDate="";
        completionDate="";
        examDate="";
        isRegistered=false; //change value to false every time the object of class is created
    }
    //access values of private variables outside the class
    public String getInstructorName(){
        return instructorName;
    }

    public int getDuration(){
        return duration;
    }

    public String getStartDate(){
        return startDate;
    }

    public String getCompletionDate(){
        return completionDate;
    }

    public String getExamDate(){
        return examDate;
    }

    public String getPrerequisite(){
        return prerequisite;
    }

    public boolean getRegistered(){
        return isRegistered;
    }

    public boolean getRemoved(){
        return isRemoved;
    }
    //set values of private variables from outside the class
    public void setRemoved(boolean isRemoved){
        this.isRemoved=isRemoved;
    }

    public void setInstructorName(String instructorName){
        if(!isRegistered){//sets instructorName as per parameter if not set previously or set and cleared
            this.instructorName=instructorName;
        }else{
            out.println("It is not possible to change instructor name since non academic course has already been registered");
        }
    }
    //set initial value of variable in superclass
    public void register(String courseLeader, String instructorName, String startDate, String completionDate, String examDate){
        if(!isRegistered){
            setInstructorName(instructorName);
            this.startDate=startDate;
            this.completionDate=completionDate;
            this.examDate=examDate;
            isRegistered=true; //if block will not be executed next time if isRegertered is true
        }else{
            out.println("The course has already been registered"); //write a message to console if course has already been registered
        }
    }
    //reset values
    public void remove(){
        if(isRemoved){
            out.println("The course has already been removed");
        }else{
            //remove values of variables bellow(set values to empty string)
            super.setCourseLeader("");
            startDate="";
            completionDate="";
            examDate="";
            isRegistered=false; //code blocks to set values can run on next check(method call) again
            isRemoved=true;
        }
    }
    //display values if user is registered and if values are not empty/null
    public void display(){
        //calling getter methods from superclass to access private variables 
        out.println("Course ID: "+super.getCourseID());
        out.println("Course Name: "+super.getCourseName());
        out.println("Duration: "+super.getDuration());
        if(isRegistered){
            //print values from this class if course has been registered 
            out.println("Instructor Name: "+instructorName);
            out.println("Starting Date: "+startDate);
            out.println("Completion Date: "+completionDate);
            out.println("Exam Date: "+examDate);
        }
    }
}
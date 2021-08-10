/*
 * AcademicCourse is subclass of Course class and extends it with additional attributes and properties
 * Created on Sat May 01 19:57 2021
 * @Author: Abhishek Pandey
 */

import static java.lang.System.out; //import out variable from System class to avoid writing System.out multiple times in this class

public class AcademicCourse extends Course{ //inherit public, protected methods and variables from superclass Course
    private String lecturerName, level, startingDate, completionDate;
    private int noOfAssessments, credit;
    private boolean isRegistered;
    private boolean courseRemovedStatus;
    public AcademicCourse(String courseID, String courseName, int duration, String level, int credit, int noOfAssessments){
        super(courseID, courseName, duration);
        //initialize some variables
        lecturerName="";
        startingDate="";
        completionDate="";
        this.noOfAssessments = noOfAssessments;
        this.level = level;
        isRegistered=false;/*non premitive datatype gets defaultValue false but the value has to be set here for the variable to reset 
        its value every time the constructor object is invoked(called)*/
    }
    //access values stored in private variables outside the class
    public String getLecturerName(){
        return lecturerName;
    }

    public String getLevel(){
        return level;
    }

    public int getCredit(){
        return credit;
    }

    public String getStartingDate(){
        return startingDate;
    }

    public String getCompletionDate(){
        return completionDate;
    }

    public boolean getRegistered(){
        return isRegistered;
    }

    public int getnoOfAssessments(){
        return noOfAssessments;
    }
    //set values of private variables from outside the class
    public void setLecturerName(String lecturerName){
        this.lecturerName=lecturerName;
    }

    public void setnoOfAssessments(int noOfAssessments){
        this.noOfAssessments=noOfAssessments;
    }
    //set initial value(register value) of variable in superclass if not registered
    //else display values
    public void register(String courseLeader, String lecturerName, String startingDate, String completionDate){
        if(isRegistered){
            out.println("Instructor name: "+this.lecturerName);
            out.println("Starting date: "+this.startingDate);
            out.println("Completion date: "+this.completionDate);
        }else{
            this.lecturerName=lecturerName;
            this.startingDate=startingDate;
            this.completionDate=completionDate;
            super.setCourseLeader(courseLeader);
            isRegistered=true;
            courseRemovedStatus=false;
            //register(courseLeader, lecturerName, startingDate, completionDate); //recursion
        }
    }
    //display values if registered
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
}
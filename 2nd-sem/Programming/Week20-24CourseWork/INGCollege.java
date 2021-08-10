import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import static javax.swing.JOptionPane.*;

/*
 * Created on Fri Aug 06 20:12 2021
 * @Author: Abhishek Pandey
 */
class INGCollege{ //since constructor is private, class is final without the keyword
    //final keyword in field creates a constant
    private final JFrame frame;

    private final JPanel academicPanel, nonAcademicPanel;

    private final EventHandler eventHandler = new EventHandler();

    //store objects
    private final List<Course> courses = new ArrayList<>();

    private JButton academicButton, nonAcademicButton;

    private final List<JTextField> textFields = new ArrayList<>();

    public static void main(String[] args) {
        ingCollege = new INGCollege(); //first create and run object, then initialize the variable
    }

    //singleton instance. prevent 2 frames from showing up at a time
    private static INGCollege ingCollege;
    public static INGCollege getInstance() {
        return ingCollege;
    }

    private INGCollege() {
        class Panel { //do not expose methods of this local class outside constructor
            void setUpNonAcademicPanel(JPanel p) {
                addSwitcher(p);

                //labels
                setLabel(p,"Non Academic Course", 181, 0, 800, 100, 30);
                setLabel(p,"CourseID:", 20, 90, 70, 20, 15);
                setLabel(p,"Instructor Name:", 400, 140, 130, 20, 15);
                setLabel(p,"Course Name:", 400, 90, 125, 20, 15);
                setLabel(p,"Duration:", 20, 140, 125, 20, 15);
                setLabel(p,"Prerequisite:", 20, 195, 125, 20, 15);
                setLabel(p,"Course Leader:", 20, 245, 125, 20, 15);
                setLabel(p,"Start Date:", 400, 190, 130, 20, 15);
                setLabel(p,"Completion Date:", 400, 240, 130, 20, 15);
                setLabel(p,"Exam Date:", 400, 290, 130, 20, 15);

                //text fields
                setTextField(p,180, 85, 170); //course id
                setTextField(p,180, 135, 170); //duration
                setTextField(p,535, 85, 160); //course name
                setTextField(p,535, 135, 160); //instructor name
                setTextField(p,180, 190, 170); //prerequisite
                setTextField(p,180, 240, 170); //course leader
                setTextField(p,535, 185, 160); //start date
                setTextField(p,535, 285, 160); //exam date
                setTextField(p,535, 240, 160); //completion date

                //buttons
                setButton(p,"Remove", 290, 330, 130);
                setButton(p,"Add Non Academic Course", 5, 380, 250);
                setButton(p,"Display Non Academic Courses", 5, 330, 250);
                setButton(p,"Clear", 465, 330, 260);
                setButton(p,"Register Non Academic Course", 465, 380, 260);
            }

            void setUpAcademicPanel(JPanel p) {
                addSwitcher(p);

                //labels
                setLabel(p,"Academic Course", 250, 0, 800, 100, 30);
                setLabel(p,"CourseID:", 20, 90, 70, 20, 15);
                setLabel(p,"Duration:", 20, 140, 70, 20, 15);
                setLabel(p,"Completion Date:", 400, 240, 130, 20, 15);
                setLabel(p,"Level:", 440, 290, 130, 20, 15);
                setLabel(p,"Course Name:", 400, 90, 125, 20, 15);
                setLabel(p,"No. of Assessments:", 370, 140, 185, 20, 15);
                setLabel(p,"Start Date:", 400, 190, 130, 20, 15);
                setLabel(p,"Credit:", 20, 240, 125, 20, 15);
                setLabel(p,"Lecturer Name:", 20, 190, 125, 20, 15);
                setLabel(p,"Course Leader:", 20, 290, 125, 20, 15);

                //text fields
                setTextField(p,180, 85, 170); //course id
                setTextField(p,535, 85, 160); //course name
                setTextField(p,180, 135, 170); //duration
                setTextField(p, 535, 285, 160); //level
                setTextField(p,535, 240, 160); //completion date
                setTextField(p,535, 185, 160); //start date
                setTextField(p,180, 285, 170); //credit
                setTextField(p,535, 135, 160); //number of assessments
                setTextField(p,180, 190, 170); //lecturer name
                setTextField(p,180, 240, 170); //course leader

                //buttons
                setButton(p,"Add Academic Course", 5, 380, 250);
                setButton(p,"Display Academic Courses", 5, 330, 250);
                setButton(p,"Clear", 465, 330, 260);
                setButton(p,"Register Academic Course", 465, 380, 260);
            }

            void addSwitcher(JPanel panel) {
                academicButton = new JButton("Academic");//enabled by default
                nonAcademicButton = new JButton("Non Academic");
                academicButton.setBackground(new Color(6,181,223));//light blue
                nonAcademicButton.setBackground(Color.GRAY);
                academicButton.setBounds(350,5,100,20);
                nonAcademicButton.setBounds(450,5,135,20);
                //when something is clicked
                academicButton.addActionListener(eventHandler);
                nonAcademicButton.addActionListener(eventHandler);
                panel.add(academicButton);
                panel.add(nonAcademicButton);
                //question
                setLabel(panel, "Which type of course do you want to enroll in?",0,0,350,30,15);
            }

            void setLabel(JPanel panel, String text, int x, int y, int width, int height, int fontSize) {
                new JLabel(text) { //creating anonymous class extending JLabel with this object
                    { //default constructor without parameters (instance initializer)
                        setBounds(x, y, width, height);
                        setFont(new Font(null, Font.PLAIN, fontSize));

                        /*block scope, do not expose txt variable to anything except this block scope
                         * (not even to anything beyond that inside this method)
                         */
                        {
                            String txt = getText();
                            if(txt.contains("Academic"))setForeground(Color.BLUE);
                            else if(txt.contains("Which"))setForeground(new Color(223,48,6)); //red
                        }

                        panel.add(this); //add this JLabel instance to panel
                    }
                };
            }

            void setButton(JPanel panel, String text, int x, int y, int width) {
                new JButton(text) { //creating anonymous class extending JButton with this object
                    { //default constructor without parameters (instance initializer)
                        setBounds(x, y, width, 30); //position and size of button
                        addActionListener(eventHandler); //when button is clicked
                        panel.add(this); //add this JButton instance to panel
                    }
                };
            }

            void setTextField(JPanel panel, int x, int y, int width) {
                new JTextField() { //creating anonymous class extending JTextField with this object
                    { //default constructor without parameters
                        setBounds(x, y, width, 25);
                        textFields.add(this);
                        panel.add(this); //add this JTextField instance to panel
                    }
                };
            }
        }

        academicPanel = new JPanel(null); //with null layout manager for absolute position
        nonAcademicPanel = new JPanel(null);

        new Panel(){
            {//default constructor without parameters (instance initializer)
                setUpAcademicPanel(academicPanel);
                setUpNonAcademicPanel(nonAcademicPanel);
            }
        };

        //Academic panel
        //border around panel
        academicPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        academicPanel.setSize(740,500);

        //Non academic panel
        //border around panel
        nonAcademicPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        nonAcademicPanel.setSize(740,500); //width, height
        nonAcademicPanel.setVisible(false); //hide by default

        //anonymous class extending JFrame with this object
        frame = new JFrame("Course Registration"){ //title->Course Registration
            { //default constructor without parameters (instance initializer)
                setSize(740,500);
                add(academicPanel); //show by defareult
                add(nonAcademicPanel); //hide by default
                setLocationRelativeTo(null); //center the frame by default(0,0 otherwise)
                //do not add non academic panel to frame initially
                addWindowListener(eventHandler); //when user presses X button to close program
                setVisible(true);
            }
        };
    }

    public JFrame getFrame() {
        return frame; //return current frame
    }

    //WindowAdapter is an abstract class, ActionListener is an interface
    private class EventHandler extends WindowAdapter implements ActionListener{

        private boolean hideError; //primitive boolean, false by default

        private String getText(int index) {
            //get text at index-th index
            return textFields.get(index).getText();
        }

        @Override //when user presses X button to close program
        public void windowClosing(WindowEvent e) {
            showMessageDialog(frame, "Thank you for trying");
            System.exit(0); //terminate program with safe signal
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()) { //enhanced switch
                case "Clear"->{
                        //clear text of all textFields
                        for(JTextField t : textFields)t.setText("");
                    }
                case "Add Academic Course"->addAcademicCourse();
                case "Add Non Academic Course"->addNonAcademicCourse();
                case "Display Academic Courses"->{
                        for(Course c : courses)
                        //check if c is AcademicCourse
                            if(c instanceof AcademicCourse) {
                                AcademicCourse ac = (AcademicCourse)c;
                                ac.display();
                            }
                    }
                case "Display Non Academic Courses"->{
                        for(Course c : courses)
                        //check if c is NonAcademicCourse
                            if(c instanceof NonAcademicCourse) {
                                NonAcademicCourse nac = (NonAcademicCourse)c;
                                nac.display();
                            }
                    }
                case "Remove"->removeNonAcademicCourse();
                case "Register Academic Course"->registerAcademicCourse();
                case "Register Non Academic Course"->registerNonAcademicCourse();
                case "Academic"->{
                        academicPanel.setVisible(true);
                        nonAcademicPanel.setVisible(false);
                    }
                case "Non Academic"->{
                        nonAcademicButton.setBackground(Color.RED);
                        academicButton.setBackground(Color.GRAY);
                        academicPanel.setVisible(false);
                        nonAcademicPanel.setVisible(true);
                    }
            }
        }

        private int parseInt(String s) {
            int value = 0;
            try{
                //avoid crash if user enters decimal, parse and truncc down instead
                value = (int)Double.parseDouble(s);
            }catch(NumberFormatException nfe) {
                //parent component->main frame
                if(!hideError)showMessageDialog(frame, "Please input valid integer", "Number Error", ERROR_MESSAGE);
                hideError = true;
            }catch(Exception e) {  //any exception except number format
                if(!hideError)showMessageDialog(frame, e.getMessage(), "Unexpected Error", ERROR_MESSAGE);
                hideError = true;
            }//do not need finally block since program will not terminate so 0 will be returned
            return value;
        }

        //to not reset on action event
        private NonAcademicCourse removeNonAcademic;

        private void removeNonAcademicCourse() {
            final String courseID = getText(10);
            for(Course c : courses)
                if(c instanceof NonAcademicCourse && c.getCourseID().equals(courseID)) {
                    removeNonAcademic = (NonAcademicCourse)c;
                    courses.remove(c);
                    break; //break loop and avoid concurrent modification exception
                }
            //removeNonAcademic is not null means that if condition in above loop
            //was true in some point. So we dont need to check text
            if(removeNonAcademic!=null)removeNonAcademic.remove(); //remove if exists
        }

        private void addAcademicCourse() {
            hideError = false; //reset
            final String courseID = getText(0);
            final String courseName = getText(1);
            final int duration = parseInt(getText(2));
            final String level = getText(4);
            final int credit = parseInt(getText(9));
            final int noOfAssessments = parseInt(getText(7));
            Course course = new AcademicCourse(courseID, courseName, duration, level, credit, noOfAssessments);
            addCourse(course);
        }

        private void addNonAcademicCourse() {
            hideError = false; //reset
            final String courseID = getText(10);
            final String courseName = getText(12);
            final int duration = parseInt(getText(11));
            final String prerequisite = getText(14);
            Course course = new NonAcademicCourse(courseID, courseName, duration, prerequisite);
            addCourse(course);
        }

        private void addCourse(Course course) {
            String text;
            boolean show = false;
            //if add academic course button is pressed, check courseID from AcademicPanel
            if(course instanceof AcademicCourse)text = getText(0); //AcademicCourseID
            //if add non academic course button is pressed, check courseID from NonAcademicPanel
            else text = getText(10); //NonAcademicCourseID
            courses.add(course);
            for(Course c : courses)
                if(c.getCourseID().equals(text)) {
                    if(show) {
                        showMessageDialog(
                            //'this' can not be used directly as this block is in an internal class
                            INGCollege.this.getFrame(),"The course has already been added.",
                            "Warning",WARNING_MESSAGE
                        );
                        courses.remove(c);
                        break; //break after removing object to prevent concurrent modification exception
                    }
                    show = true;
                }
        }

        private void registerAcademicCourse() {
            final String courseLeader = getText(6);
            final String lecturerName = getText(8);
            final String startingDate = getText(3);
            final String completionDate = getText(5);
            for(Course c : courses)
                if(c instanceof AcademicCourse && getText(0).equals(c.getCourseID())) {
                    AcademicCourse ac = (AcademicCourse)c;
                    ac.register(
                        courseLeader, lecturerName, startingDate, completionDate
                    );
                }
        }

        private void registerNonAcademicCourse() {
            final String courseLeader = getText(15);
            final String instructorName = getText(13);
            final String startingDate = getText(16);
            final String completionDate = getText(18);
            final String examDate = getText(17);
            for(Course c : courses)
                if(c instanceof NonAcademicCourse && getText(10).equals(c.getCourseID())) {
                    NonAcademicCourse nac = (NonAcademicCourse)c;
                    nac.register(
                        courseLeader, instructorName, startingDate, completionDate, examDate
                    );
                }
        }
    }
}

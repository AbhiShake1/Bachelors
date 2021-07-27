import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class INGCollege{
    private static JFrame frame;

    private static JPanel academicPanel, nonAcademicPanel;

    private static final EventHandler eventHandler = new EventHandler();

    //store objects
    private static final List<Course> courses = new ArrayList<>();

    public static void main(String[] args){
        frame = new JFrame("Course Registration");
        academicPanel = new JPanel(null); //with null layout manager for absolute position
        nonAcademicPanel = new JPanel(null);

        setUpAcademicPanel(academicPanel);
        setUpNonAcademicPanel(nonAcademicPanel);

        //academic panel
        academicPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        academicPanel.setSize(740,500);
        frame.setSize(740,500);
        frame.add(academicPanel);

        //Non academic panel
        nonAcademicPanel.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        nonAcademicPanel.setSize(740,500);
        frame.setSize(740,500);
        //frame.add(nonAcademicPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void setUpNonAcademicPanel(JPanel p){
        addSwitcher(p);

        //labels
        setLabel(p,"Non Academic Course", 250, 0, 800, 100, 30);
        setLabel(p,"CourseID:", 20, 90, 70, 20, 15);
        setLabel(p,"Course Name:", 20, 140, 125, 20, 15);
        setLabel(p,"Instructor Name:", 400, 90, 125, 20, 15);
        setLabel(p,"Duration:", 400, 140, 130, 20, 15);
        setLabel(p,"Prerequisite:", 20, 195, 125, 20, 15);
        setLabel(p,"Course Leader:", 20, 245, 125, 20, 15);
        setLabel(p,"Start Date:", 400, 190, 130, 20, 15);
        setLabel(p,"Completion Date:", 400, 240, 130, 20, 15);
        setLabel(p,"Exam Date:", 400, 290, 130, 20, 15);

        //text fields
        setTextField(p,180, 85, 170); //course id
        setTextField(p,180, 135, 170); //course name
        setTextField(p,535, 85, 160); //level
        setTextField(p,535, 135, 160); //duration
        setTextField(p,180, 190, 170); //prerequisite
        setTextField(p,180, 240, 170); //course leader
        setTextField(p,535, 185, 160); //start date
        setTextField(p,535, 285, 160); //exam date
        setTextField(p,535, 235, 160); //completion date

        //buttons
        setButton(p,"Remove", 290, 330, 130);
        setButton(p,"Add Non Academic Course", 5, 380, 250);
        setButton(p,"Display Non Academic Courses", 5, 330, 250);
        setButton(p,"Clear", 465, 330, 260);
        setButton(p,"Register Non Academic Course", 465, 380, 260);
    }

    private static void setUpAcademicPanel(JPanel p){
        addSwitcher(p);

        //labels
        setLabel(p,"Academic Course", 250, 0, 800, 100, 30);
        setLabel(p,"CourseID:", 20, 90, 70, 20, 15);
        setLabel(p,"Duration:", 20, 140, 70, 20, 15);
        setLabel(p,"Completion Date:", 390, 290, 130, 20, 15);
        setLabel(p,"Level:", 400, 190, 70, 20, 15);
        setLabel(p,"Course Name:", 400, 90, 125, 20, 15);
        setLabel(p,"No. of Assessments:", 370, 140, 185, 20, 15);
        setLabel(p,"Start Date:", 400, 240, 125, 20, 15);
        setLabel(p,"Credit:", 20, 240, 125, 20, 15);
        setLabel(p,"Lecturer Name:", 20, 190, 125, 20, 15);
        setLabel(p,"Course Leader:", 20, 290, 125, 20, 15);

        //text fields
        setTextField(p,180, 85, 170); //course id
        setTextField(p,535, 85, 160); //course name
        setTextField(p,180, 135, 170); //duration
        setTextField(p,535, 190, 160); //level
        setTextField(p,535, 285, 160); //completion date
        setTextField(p,535, 235, 160); //start date
        setTextField(p,180, 235, 170); //credit
        setTextField(p,535, 135, 160); //number of assessments
        setTextField(p,180, 190, 170); //lecturer name
        setTextField(p,180, 285, 170); //course leader

        //buttons
        setButton(p,"Add Academic Course", 5, 380, 250);
        setButton(p,"Display Academic Courses", 5, 330, 250);
        setButton(p,"Clear", 465, 330, 260);
        setButton(p,"Register Academic Course", 465, 380, 260);
    }

    private static JButton academicButton, nonAcademicButton;

    private static void addSwitcher(JPanel panel){
        academicButton = new JButton("Academic");//enabled by default
        nonAcademicButton = new JButton("Non Academic");
        academicButton.setBackground(Color.BLUE);
        nonAcademicButton.setBackground(Color.GRAY);
        academicButton.setBounds(350,5,100,20);
        nonAcademicButton.setBounds(450,5,135,20);
        academicButton.addActionListener(eventHandler);
        nonAcademicButton.addActionListener(eventHandler);
        panel.add(academicButton);
        panel.add(nonAcademicButton);
        //question
        setLabel(panel, "Which type of course do you want to enroll in?",0,0,350,30,15);
    }

    private static void setLabel(JPanel panel, String text, int x, int y, int width, int height, int fontSize){
        JLabel label = new JLabel(text);
        label.setBounds(x, y, width, height);
        label.setFont(new Font(null, Font.PLAIN, fontSize));
        String txt = label.getText();
        if(txt.contains("Academic"))label.setForeground(Color.BLUE);
        else if(txt.contains("Which"))label.setForeground(Color.MAGENTA);
        panel.add(label);
    }

    private static void setButton(JPanel panel, String text, int x, int y, int width){
        JButton button = new JButton(text);
        button.setBounds(x, y, width, 30);
        button.addActionListener(eventHandler);
        panel.add(button);
    }

    private static void setTextField(JPanel panel, int x, int y, int width){
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, 25);
        textField.addActionListener(eventHandler);
        textFields.add(textField);
        panel.add(textField);
    }

    private static final List<JTextField> textFields = new ArrayList<>();

    public static JFrame getFrame(){
        return frame;
    }

    private static class EventHandler implements ActionListener{
        private static  String getText(int index){
            return textFields.get(index).getText();
        }
        private static int errorNumber;

        @Override
        public void actionPerformed(ActionEvent e){
            switch(e.getActionCommand()){
                case "Clear":
                    textFields.forEach(l->l.setText(""));
                    break;
                case "Add Academic Course":
                    addAcademicCourse();
                    break;
                case "Add Non Academic Course":
                    addNonAcademicCourse();
                    break;
                case "Display Academic Courses":
                    courses.stream().filter(a->a instanceof AcademicCourse).map(c->(AcademicCourse)c).forEach(AcademicCourse::display);
                    break;
                case "Display Non Academic Courses":
                    courses.stream().filter(n->n instanceof NonAcademicCourse).map(c->(NonAcademicCourse)c).forEach(NonAcademicCourse::display);
                    break;
                case "Remove":
                    courses.removeIf(n->n instanceof NonAcademicCourse
                            && n.getCourseID().equals(getText(10)));
                    break;
                case "Register Academic Course":
                    registerAcademicCourse();
                    break;
                case "Register Non Academic Course":
                    registerNonAcademicCourse();
                    break;
                case "Academic":
                    frame.remove(nonAcademicPanel);
                    frame.add(academicPanel);
                    frame.repaint();
                    break;
                case "Non Academic":
                    nonAcademicButton.setBackground(Color.RED);
                    academicButton.setBackground(Color.GRAY);
                    frame.remove(academicPanel);
                    frame.add(nonAcademicPanel);
                    frame.repaint();
                    break;
            }
        }

        private static int parseInt(String s){
            int value = 0;
            try{
                value = Integer.parseInt(s);
            }catch(NumberFormatException nfe){
                if(errorNumber == 0)
                //parent component->main frame
                    JOptionPane.showMessageDialog(frame, "Please input valid integer", "Error", JOptionPane.ERROR_MESSAGE);
                errorNumber++;
            }
            return value;
        }

        private void addAcademicCourse(){
            errorNumber = 0;
            String courseID = getText(0);
            String courseName = getText(1);
            int duration = parseInt(getText(2));
            String level = getText(3);
            int credit = parseInt(getText(6));
            int noOfAssessments = parseInt(getText(7));
            Course course = new AcademicCourse(courseID, courseName, duration, level, credit, noOfAssessments);
            courses.add(course);
        }

        public void addNonAcademicCourse(){
            errorNumber = 0;
            String courseID = getText(10);
            String courseName = getText(11);
            int duration = parseInt(getText(13));
            String level = getText(12);
            String prerequisite = getText(14);
            Course course = new NonAcademicCourse(courseID, courseName, duration, level, prerequisite);
            courses.add(course);
        }

        public void registerAcademicCourse(){
            String courseLeader = getText(9);
            String lecturerName = getText(8);
            String startingDate = getText(5);
            String completionDate = getText(4);
            courses.stream().filter(c->c instanceof AcademicCourse
                    && getText(0).equals(c.getCourseID())
            ).map(c->(AcademicCourse)c).forEach(c->c.register(
                        courseLeader, lecturerName, startingDate, completionDate
                    ));
        }

        public void registerNonAcademicCourse(){
            String courseLeader = getText(15);
            String courseName = getText(11);
            String startingDate = getText(16);
            String completionDate = getText(18);
            String examDate = getText(17);
            courses.stream().filter(c->c instanceof NonAcademicCourse
                    && getText(0).equals(c.getCourseID())
            ).map(c->(NonAcademicCourse)c).forEach(c->c.register(
                        courseLeader, courseName, startingDate, completionDate, examDate
                    ));
        }
    }
}

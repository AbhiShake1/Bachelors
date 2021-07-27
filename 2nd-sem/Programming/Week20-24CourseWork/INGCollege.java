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
    private static final List<Course> courses = new ArrayList();

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
        setTextField(p,180, 85, 170, 25); //course id
        setTextField(p,180, 135, 170, 25); //course name
        setTextField(p,535, 85, 160, 25); //level
        setTextField(p,535, 135, 160, 25); //duration
        setTextField(p,180, 190, 170, 25); //prerequisite
        setTextField(p,180, 240, 170, 25); //course leader
        setTextField(p,535, 185, 160, 25); //start date
        setTextField(p,535, 285, 160, 25); //exam date
        setTextField(p,535, 235, 160, 25); //completion date

        //buttons
        setButton(p,"Remove", 290, 330, 130, 30);
        setButton(p,"Add Non Academic Course", 5, 380, 250, 30);
        setButton(p,"Display Non Academic Courses", 5, 330, 250, 30);
        setButton(p,"Clear", 465, 330, 260, 30);
        setButton(p,"Register Non Academic Course", 465, 380, 260, 30);
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
        setTextField(p,180, 85, 170, 25); //course id
        setTextField(p,535, 85, 160, 25); //course name
        setTextField(p,180, 135, 170, 25); //duration
        setTextField(p,535, 190, 160, 25); //level
        setTextField(p,535, 285, 160, 25); //completion date
        setTextField(p,535, 235, 160, 25); //start date
        setTextField(p,180, 235, 170, 25); //credit
        setTextField(p,535, 135, 160, 25); //number of assessments
        setTextField(p,180, 190, 170, 25); //lecturer name
        setTextField(p,180, 285, 170, 25); //course leader

        //buttons
        setButton(p,"Add Academic Course", 5, 380, 250, 30);
        setButton(p,"Display Academic Courses", 5, 330, 250, 30);
        setButton(p,"Clear", 465, 330, 260, 30);
        setButton(p,"Register Academic Course", 465, 380, 260, 30);
    }

<<<<<<< HEAD
    private static JButton academicButton, nonAcademicButton;
=======
    private static JButton academicButton;
    private static JButton nonAcademicButton;
>>>>>>> 49d01c22244ea4f1d81139c731fdf567655bf151

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
        label.setFont(new Font(null, 0, fontSize));
        String txt = label.getText();
        if(txt.contains("Academic"))label.setForeground(Color.BLUE);
        else if(txt.contains("Which"))label.setForeground(Color.MAGENTA);
        panel.add(label);
    }

    private static void setButton(JPanel panel, String text, int x, int y, int width, int height){
        JButton button = new JButton(text);
        button.setBounds(x, y, width, height);
        button.addActionListener(eventHandler);
        panel.add(button);
    }

    private static void setTextField(JPanel panel, int x, int y, int width, int height){
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        textField.addActionListener(eventHandler);
        textFields.add(textField);
        panel.add(textField);
    }

    private static List<JTextField> textFields = new ArrayList();

    public static JFrame getFrame(){
        return frame;
    }

    private static class EventHandler implements ActionListener{
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
                    courses.stream().filter(a->a instanceof AcademicCourse).map(c->(AcademicCourse)c).forEach(c->c.display());
                    break;
                case "Display Non Academic Courses":
                    courses.stream().filter(n->n instanceof NonAcademicCourse).map(c->(NonAcademicCourse)c).forEach(c->c.display());
                    break;
                case "Remove":
                    courses.removeIf(n->n instanceof NonAcademicCourse
                            && n.getCourseID().equals(textFields.get(10).getText()));
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
            String courseID = textFields.get(0).getText();
            String courseName = textFields.get(1).getText();
            int duration = parseInt(textFields.get(2).getText());
            String level = textFields.get(3).getText();
            int credit = parseInt(textFields.get(6).getText());
            int noOfAssessments = parseInt(textFields.get(7).getText());
            Course course = new AcademicCourse(courseID, courseName, duration, level, credit, noOfAssessments);
            courses.add(course);
        }

        public void addNonAcademicCourse(){
            errorNumber = 0;
            String courseID = textFields.get(10).getText();
            String courseName = textFields.get(11).getText();
            int duration = parseInt(textFields.get(13).getText());
            String level = textFields.get(12).getText();
            String prerequisite = textFields.get(14).getText();
            Course course = new NonAcademicCourse(courseID, courseName, duration, level, prerequisite);
            courses.add(course);
        }

        public void registerAcademicCourse(){
            String courseLeader = textFields.get(9).getText();
            String lecturerName = textFields.get(8).getText();
            String startingDate = textFields.get(5).getText();
            String completionDate = textFields.get(4).getText();
            courses.stream().filter(c->c instanceof AcademicCourse
            && textFields.get(0).getText() == c.getCourseID()
            ).map(c->(AcademicCourse)c).forEach(c->c.register(
                courseLeader, lecturerName, startingDate, completionDate
            ));
        }
        
        public void registerNonAcademicCourse(){
            String courseLeader = textFields.get(16).getText();
            String courseName = textFields.get(11).getText();
            String startingDate = textFields.get(16).getText();
            String completionDate = textFields.get(18).getText();
            String examDate = textFields.get(17).getText();
            courses.stream().filter(c->c instanceof AcademicCourse
            && textFields.get(0).getText() == c.getCourseID()
            ).map(c->(NonAcademicCourse)c).forEach(c->c.register(
                courseLeader, courseName, startingDate, completionDate, examDate
            ));
        }
    }
}

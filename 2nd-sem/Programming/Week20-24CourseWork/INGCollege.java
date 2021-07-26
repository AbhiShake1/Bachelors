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
        frame.add(nonAcademicPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void setUpNonAcademicPanel(JPanel p){
        addSwitcher(p);
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

        //text fields
        setTextField(p,180, 85, 170, 25); //course id
        setTextField(p,535, 85, 160, 25); //course name
        setTextField(p,180, 135, 170, 25); //duration
        setTextField(p,535, 190, 160, 25); //level
        setTextField(p,535, 285, 160, 25); //prerequisite
        setTextField(p,535, 235, 160, 25); //course leader
        setTextField(p,180, 235, 170, 25); //credit
        setTextField(p,535, 135, 160, 25); //number of assessments
        setTextField(p,180, 190, 170, 25); //lecturer name

        //buttons
        //setButton("Add", 535, 170, 160, 30);
        setButton(p,"Register", 535, 320, 160, 30);
        setButton(p,"Add Academic Course", 5, 380, 190, 30);
        setButton(p,"Display", 205, 380, 130, 30);
        setButton(p,"Clear", 350, 380, 120, 30);
        setButton(p,"Add Non Academic Course", 485, 380, 230, 30);
    }

    private static JButton academicButton;
    private static JButton nonAcademicButton;
    private static ButtonGroup optionsGroup;

    private static void addSwitcher(JPanel panel){
        //optionsGroup = new ButtonGroup();
        academicButton = new JButton("Academic");//enabled by default
        nonAcademicButton = new JButton("Non Academic");
        //optionsGroup.add(academicButton);
        //optionsGroup.add(nonAcademicButton);
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
        if(label.getText().contains("Academic"))label.setForeground(Color.BLUE);
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

    private static class EventHandler implements ActionListener{
        private static int errorNumber;

        @Override
        public void actionPerformed(ActionEvent e){
            String action = e.getActionCommand();
            if(action=="Clear")clearAll(academicPanel.getParent());
            if(action=="Add Academic Course")addAcademicCourse();
            if(action=="Add Non Academic Course")addNonAcademicCourse();
            if(action=="Display")courses.forEach(System.out::println);

            if(action=="Academic"){
                frame.remove(nonAcademicPanel);
                frame.add(academicPanel);
                frame.repaint();
            }else if(action=="Non Academic"){
                nonAcademicButton.setBackground(Color.RED);
                academicButton.setBackground(Color.GRAY);
                frame.remove(academicPanel);
                frame.add(nonAcademicPanel);
                frame.repaint();
            }
        }

        private static int parseInt(String s){
            int value = 0;
            try{
                value = Integer.parseInt(s);
            }catch(NumberFormatException nfe){
                if(errorNumber == 0)
                    JOptionPane.showMessageDialog(null, "Please input valid integer", "Error", JOptionPane.ERROR_MESSAGE);
                errorNumber++;
            }
            return value;
        }

        private void clearAll(Container container){
            textFields.forEach(l->l.setText(""));
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
            String courseID = textFields.get(0).getText();
            String courseName = textFields.get(1).getText();
            int duration = parseInt(textFields.get(2).getText());
            String level = textFields.get(3).getText();
            String prerequisite = textFields.get(4).getText();
        }
    }
}
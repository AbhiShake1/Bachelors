import javax.swing.*;
import java.awt.*;
import javafx.scene.control.DatePicker;

public class Form{
    private static JPanel panel;
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Form1"); //arg to constructor->title
        panel = new JPanel(null); //arg to constructor->layout manager
        panel.setBackground(new Color(190, 190, 190, 1));
        
        //labels
        setLabel("Student's Registration Form",30,200,-15,500,90);
        setLabel("Student ID:",15,36,85,85,15);
        setLabel("School Year:",15,566,85,95,15);
        setLabel("First Name:",15,36,115,90,15);
        setLabel("Middle Name:",15,566,115,100,15);
        setLabel("Last Name:",15,312,115,90,15);
        setLabel("Address:",15,36,145,85,15);
        setLabel("Date of Birth:",15,300,145,100,15);
        setLabel("Place of Birth:",15,526,145,110,15);
        setLabel("Age:",15,36,195,85,15);
        setLabel("Gender:",15,338,195,90,15);
        setLabel("Status:",15,574,195,110,15);
        setLabel("Year:",15,36,225,85,15);
        setLabel("Guardian:",15,326,225,90,15);
        setLabel("Relation:",15,564,225,110,15);
        setLabel("Contact#:",15,453,255,90,15);
        setLabel("Address:",15,36,255,85,15);
        setLabel("0  OF  0",15,415,332,85,15);
        
        //text fields
        setTextField(130,82,112,18);
        setTextField(130,112,152,18);
        setTextField(405,112,152,18); //last name
        setTextField(405,222,152,18); //guardian
        setTextField(675,112,152,18); //middle name
        setTextField(130,192,152,18);
        setTextField(130,222,152,18);
        setTextField(635,222,192,18); //relation
        setTextField(535,252,292,18); //contact
        
        //text areas
        setTextArea(130,138,152,48); //1st address
        setTextArea(130,252,282,48); //2nd address
        setTextArea(635,142,192,48); //place of birth
        
        //buttons
        setButton("|<",15,322,80,30);
        setButton("<<",115,322,80,30);
        setButton(">>",215,322,80,30);
        setButton(">|",315,322,80,30);
        setButton("New",565,322,80,30);
        setButton("Save",665,322,160,30);
        
        //combo boxes
        setComboBox(new String[]{"2004-2005","2006-2007","2007-2008","2008-2009","2009-2010","2010-2011","2011-2012"
            ,"2012-2013","2013-2014","2014-2015"},675,80,110,25);
        setComboBox(new String[]{"Single","Married"},637,195,110,25);
        
        //radio buttons
        ButtonGroup genderGroup = new ButtonGroup(); //only 1 radio button in a group can be active at a time
        setRadioButton(genderGroup,"Male",408,195,60,15);
        setRadioButton(genderGroup,"Female",468,195,80,15);
                
        frame.add(panel);
        panel.setSize(850,400);
        frame.setSize(850,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private static void setDatePicker(int...bounds){
        //#todo: implement date picker
    }
    
    private static void setComboBox(String[] elements, int...bounds){
        JComboBox dropdown = new JComboBox(elements);
        dropdown.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        panel.add(dropdown);
    }
    
    private static void setRadioButton(ButtonGroup radioGroup, String text, int...bounds){
        JRadioButton radioButton = new JRadioButton(text);
        radioGroup.add(radioButton);
        radioButton.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        panel.add(radioButton);
    }
    
    private static void setLabel(String name, int...sizes){
        JLabel label = new JLabel(name);
        label.setBounds(sizes[1],sizes[2],sizes[3],sizes[4]);
        label.setFont(new Font(null,0,sizes[0]));
        panel.add(label);
    }
    
    private static void setTextField(int...bounds){
        JTextField textField = new JTextField();
        textField.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        panel.add(textField);
    }
    
    private static void setTextArea(int...bounds){
        JTextArea textArea = new JTextArea();
        textArea.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        panel.add(textArea);
    }
    
    private static void setButton(String text, int...bounds){
        JButton button = new JButton(text);
        button.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        panel.add(button);
    }
}
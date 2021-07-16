import javax.swing.*;
import java.awt.*;
import javafx.scene.control.DatePicker;
import java.util.stream.IntStream;
import java.util.function.BiFunction;

public class Form{
    private static JPanel panel;

    public static void main(String[] args){
        JFrame frame = new JFrame("Form1"); //arg to constructor->title
        panel = new JPanel(null); //arg to constructor->layout manager
        //panel.setBackground(new Color(190, 190, 190, 1));

        //labels
        setLabel("Student's Registration Form",30,200,-15,500,90);
        setLabel("Student ID:",14,36,85,85,15);
        setLabel("School Year:",14,566,85,95,15);
        setLabel("First Name:",14,36,115,90,15);
        setLabel("Middle Name:",13,566,115,100,15);
        setLabel("Last Name:",14,312,115,90,15);
        setLabel("Address:",14,36,145,85,15);
        setLabel("Date of Birth:",14,290,145,100,15);
        setLabel("Place of Birth:",14,571,145,105,15);
        setLabel("Age:",14,36,195,85,15);
        setLabel("Gender:",14,338,195,90,15);
        setLabel("Status:",14,589,195,110,15);
        setLabel("Year:",14,36,225,85,15);
        setLabel("Guardian:",14,326,225,90,15);
        setLabel("Relation:",14,584,225,110,15);
        setLabel("Contact#:",14,453,255,90,15);
        setLabel("Address:",14,36,255,85,15);
        setLabel("0  OF  0",14,415,332,85,15);

        //text fields
        setTextField(130,82,112,18);
        setTextField(130,112,152,18);
        setTextField(405,112,152,18); //last name
        setTextField(405,222,152,18); //guardian
        setTextField(675,112,152,18); //middle name
        setTextField(130,192,92,18);
        setTextField(655,222,172,18); //relation
        setTextField(535,252,292,18); //contact

        //text areas
        setTextArea(130,138,152,48); //1st address
        setTextArea(130,252,282,48); //2nd address
        setTextArea(675,142,152,48); //place of birth

        //buttons
        setButton("|<",15,322,80,30);
        setButton("<<",115,322,80,30);
        setButton(">>",215,322,80,30);
        setButton(">|",315,322,80,30);
        setButton("New",565,322,80,30);
        setButton("Save",665,322,160,30);

        //combo boxes
        setComboBox(new String[]{"2014-2015","2015-2016","2016-2017",
                "2018-2019","2019-2020","2020-2021"},675,80,110,25);
        setComboBox(new String[]{"Single","Married"},657,195,110,22);
        setComboBox(new String[]{"1st","2nd","3rd","4th"},130,222,102,18);
        //generate int array of l to u (inclusive) and convert/map 
        //elements to string using declarative approach
        //(jdk8 feature) or streams
        BiFunction<Integer, Integer, String[]> generateArray =
            (l,u)->IntStream.range(l,u+1)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        String[] year = generateArray.apply(1995,2018);
        setComboBox(year,391,142,59,21);
        setComboBox(new String[]{"January","February","March",
                "April","May","June","July","August","September",
                "October","November","December"},451,142,79,21);

        String[] day = generateArray.apply(1,31);
        setComboBox(day,531,142,34,21);

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
        label.setFont(new Font("Noto Serif CJK JP Black",0,sizes[0]));
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
        button.setFont(new Font("Noto Serif CJK JP Black",Font.BOLD,15));
        button.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        panel.add(button);
    }
}
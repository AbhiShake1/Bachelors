import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.text.*;
import java.util.stream.IntStream;
import java.util.function.BiFunction;

public class Form{
    private static JPanel panel;

    private static ButtonGroup genderGroup;

    private static JTextField firstNameField;
    
    private static ActionListener actionListener = new FormEventListener();

    public static void main(String[] args){
        JFrame frame = new JFrame("Form1"); //arg to constructor->title
        panel = new JPanel(null); //arg to constructor->layout manager
        //panel.setBackground(new Color(190, 190, 190, 1));

        //menu bar
        addMenuBar();

        //labels
        setLabel("Student's Registration Form",30,200,5,500,90);
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
        firstNameField = setTextField(130,112,152,18);
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
        genderGroup = new ButtonGroup(); //only 1 radio button in a group can be active at a time
        setRadioButton(genderGroup,"Male",408,195,60,15);
        setRadioButton(genderGroup,"Female",468,195,80,15);

        frame.add(panel);
        panel.setSize(850,400);
        frame.setSize(850,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private static void setComboBox(String[] elements, int x, int y, int width, int height){
        JComboBox dropdown = new JComboBox(elements);
        dropdown.setBounds(x,y,width,height);
        panel.add(dropdown);
    }

    private static void setRadioButton(ButtonGroup radioGroup, String text, int x, int y, int width, int height){
        JRadioButton radioButton = new JRadioButton(text);
        radioGroup.add(radioButton);
        radioButton.setBounds(x,y,width,height);
        panel.add(radioButton);
    }

    private static void setLabel(String name, int textSize, int x, int y, int width, int height){
        JLabel label = new JLabel(name);
        label.setBounds(x, y, width, height);
        label.setFont(new Font(null,0,textSize));
        panel.add(label);
    }

    private static JTextField setTextField(int x, int y, int width, int height){
        JTextField textField = new JTextField();
        textField.setBounds(x, y, width, height);
        panel.add(textField);
        return textField;
    }

    private static void setTextArea(int x, int y, int width, int height){
        JTextArea textArea = new JTextArea();
        textArea.setBounds(x, y, width, height);
        panel.add(textArea);
    }

    private static void setButton(String text, int x, int y, int width, int height){
        JButton button = new JButton(text);
        button.setFont(new Font(null,Font.BOLD,15));
        button.addActionListener(actionListener);
        button.setBounds(x, y, width, height);
        panel.add(button);
    }

    private static void reset(Container container){
        for(Component c : container.getComponents()){
            if(c instanceof JTextArea||c instanceof JTextField){
                ((JTextComponent)c).setText("");
            }else if(c instanceof JRadioButton){
                ((JRadioButton)c).setSelected(false);
            }else if(c instanceof JComboBox){
                JComboBox box = (JComboBox)c;
                box.setSelectedItem(box.getItemAt(0));
            }else if(c instanceof Container){
                reset((Container)c);
            }
        }
    }

    private static void save(){
        JOptionPane.showMessageDialog(null, "Hello! "+
            firstNameField.getText()+" \nYour record is being saved"
        );
    }

    private static void addMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.setSize(1000,30); //entire width of panel

        JMenu file = new JMenu("File");
        file.add(new JMenuItem("Open"));
        JMenuItem itemNew = new JMenuItem("New");
        itemNew.addActionListener(actionListener);
        file.add(itemNew);
        JMenuItem itemSave = new JMenuItem("Save");
        itemSave.addActionListener(actionListener);
        file.add(itemSave);
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(actionListener);//terminate program
        file.add(exit);
        menuBar.add(file);

        JMenu options = new JMenu("About");
        menuBar.add(options);

        JMenu view = new JMenu("Help");
        menuBar.add(view);

        panel.add(menuBar);
    }

    private static class FormEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            String cmd = e.getActionCommand();
            if(cmd=="New") reset(panel.getParent());
            else if(cmd=="Save") save();
            else if(cmd=="Exit") System.exit(0); //safely terminate prograam
        }
    }
}
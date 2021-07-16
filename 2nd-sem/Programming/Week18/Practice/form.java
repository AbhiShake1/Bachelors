import javax.swing.*;
import java.awt.*;

public class form{
    private static JPanel panel;
    
    public static void main(String[] args){
        JFrame frame = new JFrame("Registration form");
        panel = new JPanel(null);
        
        addMenuBar();

        //labels
        setLabel("Registration Form",30, 260, 0, 500, 100);
        setLabel("Name",20, 20, 50, 100, 100);
        setLabel("Mobile",20, 20, 100, 100, 100);
        setLabel("Gender",20, 20, 150, 100, 100);
        setLabel("DOB",20, 20, 200, 100, 100);
        setLabel("Address",20, 20, 250, 100, 100);
        
        //text fields
        setTextField(120,90,200,20); //name
        setTextField(120,140,150,20);
        
        //text areas
        setTextArea(120,290,200,80); //address
        setTextArea(420,85,300,340);
        
        //check boxes
        JCheckBox acceptTos = new JCheckBox("Accept terms and conditions");
        acceptTos.setBounds(80, 370, 250, 20);
        panel.add(acceptTos);
        
        //radio buttons
        ButtonGroup genderGroup = new ButtonGroup();
        JRadioButton maleButton = new JRadioButton("Male");
        JRadioButton femaleButton = new JRadioButton("Female");
        maleButton.setBounds(120, 170, 60, 60);
        femaleButton.setBounds(200, 170, 80, 60);
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);
        panel.add(maleButton);
        panel.add(femaleButton);
        
        //buttons
        setButton("Submit",13, 80, 400, 80, 20);
        setButton("Reset",13, 180, 400, 80, 20);
        
        panel.setSize(800,500);
        frame.add(panel);
        frame.setSize(800,500);
        frame.setVisible(true);
    }
    
    private static void addMenuBar(){
        JMenuBar menuBar = new JMenuBar();
        menuBar.setSize(1000,30); //entire width of panel
        
        JMenu file = new JMenu("File");
        file.add(new JMenuItem("New File"));
        file.add(new JMenuItem("Open File"));
        file.add(new JMenuItem("Save as"));
        menuBar.add(file);
        
        JMenu options = new JMenu("Options");
        options.add(new JMenuItem("Settings"));
        options.add(new JMenuItem("Exit"));
        options.add(new JMenuItem("Account"));
        menuBar.add(options);
        
        JMenu view = new JMenu("View");
        view.add(new JMenuItem("Read mode"));
        view.add(new JMenuItem("Zoom"));
        view.add(new JMenuItem("Print"));
        menuBar.add(view);
        
        panel.add(menuBar);
    }
    
    private static void setButton(String text, int fontSize, 
    int x, int y, int width, int height){
        JButton button = new JButton(text);
        button.setBounds(x,y,width,height);
        button.setFont(new Font(null,0,fontSize));
        panel.add(button);
    }
    
    private static void setTextField(int x, int y, int width, 
    int height){
        JTextField textField = new JTextField();
        textField.setBounds(x,y,width,height);
        panel.add(textField);
    }
    
    private static void setTextArea(int x,
    int y, int width, int height){
        JTextArea textArea = new JTextArea();
        textArea.setBounds(x,y,width,height);
        panel.add(textArea);
    }

    private static void setLabel(String text, int fontSize, 
    int x, int y, int width, int height){
        JLabel label = new JLabel(text);
        label.setBounds(x,y,width,height);
        label.setFont(new Font(null,0,fontSize));
        panel.add(label);
    }
}
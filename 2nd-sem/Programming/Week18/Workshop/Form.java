import javax.swing.*;
import java.awt.Font;

public class Form{
    private static JFrame frame;
    public static void main(String[] args){
        frame = new JFrame();
        //labels
        setLabel("Register User",20,220,0,500,100);
        setLabel("First name",15,10,50,100,100);
        setLabel("Last name",15,10,120,100,100);
        setLabel("Last name",15,10,190,100,100);
        setLabel("Username",15,300,50,100,100);
        setLabel("Password",15,300,120,100,100);
        setLabel("Mobile number",15,300,190,200,100);
        //text fields        
        setTextField(100,90,130,20);
        setTextField(100,160,130,20);
        setTextField(100,230,130,20);
        setTextField(420,90,130,20);
        setTextField(420,160,130,20);
        setTextField(420,230,130,20);
        //buttons
        JButton registerBtn = new JButton("Register");
        registerBtn.setBounds(230,280,120,40);
        frame.add(registerBtn);
        
        //600 width 400 height
        frame.setSize(600,400);
        //to set absoulte position for components
        frame.getContentPane().setLayout(null); 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
    private static void setLabel(String name, int fontSize, int...bounds){
        JLabel label = new JLabel(name);
        label.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        label.setFont(new Font("Sans", Font.PLAIN, fontSize));
        frame.add(label);
    }
    
    private static void setTextField(int...bounds){
        JTextField textField = new JTextField();
        textField.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        frame.add(textField);
    }
}
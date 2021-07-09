import javax.swing.*; //import all classes from swing package
//class that sets font family, style, size and other property
//as per our needs
import java.awt.Font;
//class that defines width and height. setPreferredSize function
//takes this class as an argument
import java.awt.Dimension;
//class to deal with colors
import java.awt.Color;

/*
 * package private(default access modifier) class
 * sets up UI for form
 */
class Form{
    //stores panel object
    //global variable so that it can be accessed from all methods
    //in this class
    private static JPanel panel;

    public static void main(String[] args){
        //create main/root frame
        //title of frame(String) can optionally be passed as
        //argument in the constructor
        JFrame frame = new JFrame();        
        //create a panel to store components
        panel = new JPanel();
        //set background color for panel
        panel.setBackground(new Color(169,169,169)); //grey rgb
        //null layout manager to make position absolute 
        //instead of relative
        panel.setLayout(null);
        //add labels. see method description for more details
        setLabel("Register User",30,220,0,500,100);
        setLabel("First name",15,10,50,100,100);
        setLabel("Last name",15,10,120,100,100);
        setLabel("Email",15,10,190,100,100);
        setLabel("Username",15,300,50,100,100);
        setLabel("Password",15,300,120,100,100);
        setLabel("Mobile number",15,300,190,200,100);
        //add text fields. see method description for more details
        setTextField(100,90,130,20);
        setTextField(100,160,130,20);
        setTextField(100,230,130,20);
        setTextField(420,90,130,20);
        setTextField(420,160,130,20);
        setTextField(420,230,130,20);
        //buttons
        JButton registerBtn = new JButton("Register");
        //x, y coordinates, width, height
        registerBtn.setBounds(230,280,120,40);
        //add button with its set properties
        panel.add(registerBtn);
        //add panel with all its properties and components added 
        //inside it to the main frame
        frame.add(panel);
        //600 width 350 height
        //setPreferredSize was used instead of setSize
        //because parent layout manager(of frame) exists and
        //setSize would not allow to use frame.pack() normally
        panel.setSize(600,400);
        //set size of frame as per preferred size of components inside
        frame.setSize(600,400);
        //terminate the program when app is closed
        //only hides the app by default
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //show frame. hidden by default
        frame.setVisible(true);
    }

    /*
     * @params: name of label, font size, x coordinate, y coordinate
     * width, height
     * adds a label as per arguments
     * @returns void
     */
    private static void setLabel(String name, int fontSize, int...bounds){
        JLabel label = new JLabel(name);//create a label
        //set coordinates and sizes as per first 4 arguments to bounds
        label.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        //default font faimly and style, font size as per argument
        label.setFont(new Font(null, 0, fontSize));
        //add the created label to global panel component
        panel.add(label);
    }

    /*
     * @params: x coordinate, y coordinate, width, height
     * adds a text field as per arguments
     * @returns void
     */
    private static void setTextField(int...bounds){
        //create text field where user can write/fill data inside
        JTextField textField = new JTextField();
        //set coordinates and sizes as per first 4 arguments
        textField.setBounds(bounds[0],bounds[1],bounds[2],bounds[3]);
        //add the created text field component to global panel component
        panel.add(textField);
    }
}
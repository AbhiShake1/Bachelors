import java.util.Scanner;

public class Index
{
    private final Scanner sc = new Scanner(System.in);  //takes input from user through console
    
    private boolean error; //declaring a boolean variable 'error'. If it was initialized here, a method
                           //constructor <clinit> is created during java assembly
                                   
    //This is the method where the entire prpgram starts from
    public static void main(String args[]){ 
        new Index().setOptions(); //calling a simple user-defined function that takes input to expose methods of the related question
                                  //We needed to create an instance of class because the method is an instance method and we are calling
                                  //it inside a static method.
    }
    
    void setOptions() {  //Implementation of the user defined method described in the above comment.
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Please read the questions and write which number's question you want to see the result of: ");
        
        String str = sc.nextLine();
        
        error = false;
        
        //This is a switch statement, known as sswitch or sparse-switch in assembly
        switch (str) { //Multiple cases of the variable 'str'
            case "1": //When user enters '1'
                new Perimeter(sc); //An example of passing parameters to methods. Here, sc is called argument and Scanner in method
                break;            //inside method paranthesis are called parameters and identifiers for that parameter
                
            case "2": //When user enters '2'
                new Average(sc);
                break;
                
            case "3": //When user enters '3'
                new Area(sc);
                break;
                
            case "4": //When user enters '4'
                new Distance(sc);
                break;
            
            case "5": //When user enters '5'
                new CircleArea(sc);
                break;
                
            case "6": //When user enters '6'
                new LargestNumber(sc);
                break;
        
            default:  //When the given input is anything other than numbers between 1 to 5
                error = true;
                System.out.println(setErrorMessage()); 
        }
        askFurther();
    }
    
    private String setErrorMessage(){
        String errorMessage="";
        int fun = (int) (Math.random()*10)%3; //Generating a random number that can not be greater than 2.
        switch (fun) {
            case 0:
                errorMessage="Are you into drugs?";
                break;
            case 1:
                errorMessage="Stop acting like an idiot.";
                break;
            case 2:
                errorMessage="You should stop using computers.";
                break;
            default:
        }
        errorMessage+=" There were only 6 questions. Which questions are you looking at ?\nPlease read the questions and try again. Select a number between 1 and 6";
        return errorMessage;
    }
    
    public void askFurther(){
        
        if(error==true){ //used to bypass asking the question again when default case is met
            setOptions(); //here we didn't need to create an instance because we are calling it in a virtual method inside the same class
        }else{            
            /*
             * println and print are instance methods
             * there is a non premitive type variable in System class 'public static PrintStream out;'
             * and some value is assigned to it. It makes a reference of the println instance method
             * println or print is the actual method which is stored in PrintStream class and it prints something to the console
             */
            System.out.println("Do you have any further questions? (Y/N)");
        
            String str = sc.nextLine(); //assigns the received value of new String 'str'
        
            //checks if user entered Y or y
            if(str.equalsIgnoreCase("y")){ //when user enters Y or y
                setOptions();  
            }else{ //when user doesn't enter Y or y
                System.out.println("Thank you. Good bye!");
                return; //terminates the method. A method is terminated when the desired datatype is returned
            }
        }
    }
}

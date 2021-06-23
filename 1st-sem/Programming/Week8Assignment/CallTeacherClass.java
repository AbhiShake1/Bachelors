import static java.lang.System.out;

public class CallTeacherClass extends Teacher{
    private String mainSubject="Programming";
    public static void main(String[] args){
        CallTeacherClass callTeacherClass = new CallTeacherClass();
        out.println(callTeacherClass.getDesignation());
        out.println(callTeacherClass.getCollegeName());
        out.println(callTeacherClass.mainSubject);
        callTeacherClass.does();
    }
}
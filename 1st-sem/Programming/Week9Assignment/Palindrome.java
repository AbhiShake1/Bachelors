public class Palindrome{
    public static void main(String[] args){
        String givenString = "mam";
        char[] chars = givenString.toCharArray();
        char backup;
        for(int i=0;i<chars.length-1;i++){
            for(int j=1;j<chars.length;j++){
                backup=chars[i];
                chars[i]=chars[j];
                chars[j]=backup;
            }
        }
        String reversedString = new String(chars);
        String msg = givenString.equals(reversedString) ? "palindrome" : "not palindrome";
        System.out.println("The given word is "+msg);
    }
}
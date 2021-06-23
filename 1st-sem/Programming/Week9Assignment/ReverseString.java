public class ReverseString{
    public static void main(String[] args){
        String givenString = "abc";
        //first method
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
        System.out.printf("The reverse of %s is %s\n",givenString,reversedString);
        //second method
        System.out.printf("The reverse of %s by second method is %s\n",givenString,new StringBuilder(givenString).reverse());
    }
}
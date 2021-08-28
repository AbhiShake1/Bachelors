import java.util.*;

class a{
    public static void main(String[] args){
        Map<String, Object> map = new HashMap<>();
        map.put("2", 5);
        map.put("3", 5);
        System.out.println(map);
        map.put("2", 6);
        System.out.println(map);
    }
}
import java.util.HashSet;

public class HashSet_Demo {

    public static void main(String[] args) {
        HashSet<String> hs = new HashSet<>();
        hs.add("String1");
        hs.add(null);
        hs.add("String2");
        System.out.println(hs);
    }

}

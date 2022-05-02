import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;

public class LinkedHashSet_Demo {
    public static void main(String[] args) {
        LinkedHashSet<String> lhs = new LinkedHashSet<>();
        lhs.add("1");
        lhs.add("2");
        lhs.add("3");
        lhs.add("4");

        lhs.add("3");

        System.out.println(lhs);



    }
}

import java.util.TreeMap;
import java.util.TreeSet;

public class TreeSet_Demo {

    public static void main(String[] args) {
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(1);
        ts.add(2);
        ts.add(4);
        ts.add(0);
//        ts.add(null); not allow null
//        ts.add(4); not allow duplicate
        System.out.println(ts);


    }
}

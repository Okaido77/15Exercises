import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class Set_Demo {


    public static void main(String[] args) {

        Set<Integer> setInstance = new HashSet<>();
        Set<Integer> setInstance2 = new LinkedHashSet<>();
        setInstance.add(new Integer(1));
        setInstance.add(new Integer(2));
        setInstance.add(new Integer(3));

        setInstance2.addAll(setInstance);

//        setInstance2.add(new Integer(4));
        System.out.println(setInstance.equals(setInstance2));
        System.out.println(setInstance.hashCode()==setInstance2.hashCode());
    }
}



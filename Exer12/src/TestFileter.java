import model.PhuongTien;

import java.util.LinkedList;
import java.util.List;

public class TestFileter {
    public static void main(String[] args) {
        List<PhuongTien> l = new LinkedList<>();
        l.stream().filter(i -> i.getID().equals("1")).findFirst();


    }
}

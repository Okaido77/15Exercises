package Service;

public class ViewService {
    public static void viewAllLines(String... lines) {
        for (String line : lines) {
            System.out.println(line);
        }
    }
}

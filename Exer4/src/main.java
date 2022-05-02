import model.City;
import model.Family;
import model.Person;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        City city = new City(new HashSet<>());
        try {
            System.out.println("Enter number of families: ");
            int n;
            try {
                n = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException ex) {
                throw new Exception("Invalid Number Format");
            }
            for (int i = 0; i < n; i++) {
                System.out.println("Family " + (i + 1) + ":");
                System.out.println("Enter apartmentNumber:");
                String apartmentNumber = sc.nextLine().trim();
                if (apartmentNumber.isEmpty()) {
                    throw new Exception("apartmentNumber is empty");
                }
                System.out.println("Enter Number Of Members:");
                int numberOfMembers;
                try {
                    numberOfMembers = Integer.parseInt(sc.nextLine());
                } catch (NumberFormatException ex) {
                    throw new Exception("Invalid Number of member Format");
                }
                Family f = new Family(numberOfMembers, new LinkedList<>(), apartmentNumber);
                for (int j = 0; j < numberOfMembers; j++) {
                    System.out.println("Enter Name:");
                    String name = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        throw new Exception("name is empty");
                    }
                    System.out.println("Enter Job:");
                    String job = sc.nextLine().trim();
                    if (name.isEmpty()) {
                        throw new Exception("job is empty");
                    }
                    System.out.println("Enter Age:");
                    int age;
                    try {
                        age = Integer.parseInt(sc.nextLine());
                    } catch (NumberFormatException ex) {
                        throw new Exception("Invalid Age Format");
                    }
                    f.getMemberList().add(new Person(name, job, age));
                }

                city.getFamilies().add(f);
            }
            city.getFamilies().stream().forEach(
                    f -> {
                        System.out.println(f);
                        System.out.println("List of members: ");
                        f.getMemberList().forEach(
                                p -> System.out.println(p)
                        );
                    }
            );
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}


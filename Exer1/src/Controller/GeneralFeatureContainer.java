package Controller;

import model.Officer;
import relatedException.candidateException.InvalidAgeException;
import relatedException.candidateException.InvalidGenderException;
import relatedException.candidateException.InvalidNameException;

import java.util.Arrays;
import java.util.Scanner;

public class GeneralFeatureContainer {
    public static Officer getOfficerInfo() throws RuntimeException{

        Scanner sc = new Scanner(System.in);
        Officer officer = null;

        String name = null;
        System.out.println("Enter Name:");
        name = sc.nextLine().trim();
        if (name.isEmpty()) {
            throw new InvalidNameException("Error: Name is Empty");
        }

        int age;
        System.out.println("Enter age:");
        age = Integer.parseInt(sc.nextLine().trim());
        if (age < 18) throw new InvalidAgeException("Error: age must not be less than 18");

        System.out.println("Enter Gender(Male = 1 ; Female = 0): ");
        String gender = sc.nextLine().trim();
        if (!gender.equals("1") && !gender.equals("0")) {
            throw new InvalidGenderException("Error: Invalid choice of gender");
        }
        System.out.println("Enter Address:");
        String address = sc.nextLine().trim();
        if (address.isEmpty()) {
            throw new InvalidGenderException("Error: Gender is Empty");
        }

        officer = new Officer(name, age, "1".equals(gender), address);
        return officer;


    }

    public static void printAllLines(String... params) {
        Arrays.stream(params).forEach(
                p -> System.out.println(p)
        );
    }
}

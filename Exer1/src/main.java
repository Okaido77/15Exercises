import Controller.GeneralFeatureContainer;
import Controller.OfficerManager;
import model.Engineer;
import model.Officer;
import model.Staff;
import model.Worker;
import relatedException.InvalidChoiceException;
import relatedException.engineerException.InvalidMajorException;
import relatedException.staffException.InvalidLevelException;
import relatedException.workerException.InvalidJobException;

import java.util.*;

public class main {


    public static void main(String[] args) {
        OfficerManager manager = new OfficerManager(new HashSet<>());
        Scanner sc = new Scanner(System.in);

        while (true) {
            GeneralFeatureContainer.printAllLines("Officer management system:",
                    "1.Add new officer",
                    "2.Search by name",
                    "3.List all officer",
                    "4.Exit",
                    "Enter your choice:");

            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1":
                        GeneralFeatureContainer.printAllLines("Select a Type of officer:",
                                "1.Engineer",
                                "2.Worker",
                                "3.Staff");
                        Officer newOfficer = null;
                        String type = sc.nextLine().trim();
                        switch (type) {
                            case "1":
                                newOfficer = GeneralFeatureContainer.getOfficerInfo();
                                if (newOfficer != null) {
                                    System.out.println("enter major:");
                                    String major = sc.nextLine().trim();
                                    if (major.isEmpty()) {
                                        throw new InvalidMajorException("Error: Major is empty!");
                                    }
                                    newOfficer = new Engineer(newOfficer.getName(), newOfficer.getAge(), newOfficer.getGender()
                                            , newOfficer.getAddress(), major);
                                }
                                break;
                            case "2":
                                newOfficer = GeneralFeatureContainer.getOfficerInfo();
                                if (newOfficer != null) {
                                    System.out.println("enter job:");
                                    String job = sc.nextLine().trim();
                                    if (job.isEmpty()) {
                                        throw new InvalidJobException("Error: Job is empty!");
                                    }
                                    newOfficer = new Worker(newOfficer.getName(), newOfficer.getAge(), newOfficer.getGender()
                                            , newOfficer.getAddress(), job);
                                }
                                break;
                            case "3":
                                newOfficer = GeneralFeatureContainer.getOfficerInfo();
                                if (newOfficer != null) {
                                    int level = 0;

                                    System.out.println("enter level:");
                                    level = Integer.parseInt(sc.nextLine().trim());
                                    if (level < 0) throw new InvalidLevelException("Error: level must not less than 0");

                                    newOfficer = new Staff(newOfficer.getName(), newOfficer.getAge(), newOfficer.getGender()
                                            , newOfficer.getAddress(), level);
                                }
                                break;
                            default:
                                throw new InvalidChoiceException("Error: this choice doesnt exist");
                        }
                        boolean success = manager.addNewOfficer(newOfficer);
                        if (success == false) System.out.println("this officer already exists");
                        else System.out.println("this officer is added successfully!");
                        break;

                    case "2":
                        System.out.println("Enter Name:");
                        System.out.println("Result: ");
                        Set<Officer> s = manager.searchByName(sc.nextLine());
                        if (s.size() != 0)
                            s.forEach(
                                    o -> System.out.println(o)
                            );
                        else System.out.println("No records found");
                        break;
                    case "3":
                        manager.ListAll();
                        break;

                    case "4":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        throw new InvalidChoiceException("Error: this choice doesnt exist");
                }
            } catch (RuntimeException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}

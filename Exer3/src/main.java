import controller.CandidateManager;
import controller.FeatureManager;
import model.AStudent;
import model.BStudent;
import model.CStudent;
import model.Candidate;
import relatedException.InvalidNameException;

import java.util.HashSet;
import java.util.Scanner;

public class main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CandidateManager cm = new CandidateManager(new HashSet());
        FeatureManager fm = new FeatureManager();
        while (true) {
            fm.viewByLine("Candidate Management System",
                    "1.Add A Candidate",
                    "2.Search by id",
                    "3.List All Candidate",
                    "4.Exit"
            );
            String choice = sc.nextLine().trim();
            try {

                switch (choice) {
                    case "1":
                        fm.viewByLine("Enter type of document:",
                                "1.AStudent",
                                "2.BStudent",
                                "3.CStudent"
                        );
                        System.out.println("Enter Type Of Candidate: ");

                        String option = sc.nextLine();
                        try {
                            switch (option) {
                                case "1":
                                    AStudent aStudent = fm.getAAStudentInfor();
                                    if(aStudent!=null)
                                    cm.AddNewCandidate(aStudent);
                                    break;
                                case "2":
                                    BStudent bStudent = fm.getABStudentInfor();
                                    if(bStudent!=null)
                                    cm.AddNewCandidate(bStudent);
                                    break;
                                case "3":
                                    CStudent cStudent = fm.getACStudentInfor();
                                    if(cStudent!=null)
                                    cm.AddNewCandidate(cStudent);
                                    break;
                                default:
                                    throw new InvalidNameException("No Type Found");
                            }
                        } catch (InvalidNameException ex) {
                            System.out.println(ex.getMessage());
                        }

                        break;
                    case "2":
                        System.out.println("Enter Candidate Id");
                        String Id = sc.nextLine().trim();
                        Candidate c = cm.findByID(Id);
                        if(c==null) System.out.println("Candidate not found");
                        else System.out.println(c);
                        break;
                    case "3":
                        System.out.println("candidate list :");
                        cm.listAll();
                        break;
                    case "4":
                        System.out.println("Goodbye!");
                        return;
                    default:
                        throw new InvalidNameException("Invalid choice");
                }
            } catch (RuntimeException ex) {
                System.out.println("Error:");
                System.out.println(ex.getMessage());
            }

        }
    }
}

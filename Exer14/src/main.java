import Service.CandidateManager;
import Service.FeatureContainer;
import model.GoodStudent;
import model.NormalStudent;
import model.Student;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        CandidateManager cm = new CandidateManager(new LinkedList<>());
        FeatureContainer gfc = new FeatureContainer();
        Scanner sc = new Scanner(System.in);
        List<Student> candidateList = new LinkedList<>();
        String input;
        //input
        while (true) {
            try {
                gfc.printByLine("Enter your choice: ","1.Enter A Student",
                        "2.Display Student List",
                        "3.Choose Candidate",
                        "4.Display Candidate List"
                );
                String choice = sc.nextLine().trim();
                switch (choice) {
                    case "1":
                        gfc.printByLine("select type of student:",
                                "1.Good Student",
                                "2.Normal Student");
                        String type = sc.nextLine().trim();
                        switch (type) {
                            case "1":
                                GoodStudent gs = gfc.getAGoodStudent();
                                cm.addAStudent(gs);
                                break;
                            case "2":
                                NormalStudent ns = gfc.getANormalStudent();
                                cm.addAStudent(ns);
                                break;
                            default:
                                throw new Exception("Wrong type");
                        }
                        break;
                    case "2":
                        cm.listAllStudent();
                        break;
                    case "3":
                        System.out.println("Enter Number Of Candidates:");
                        input = sc.nextLine().trim();
                        if (input.isEmpty()) throw new Exception("input is empty");
                        int numberOfCandidate = Integer.parseInt(input);
                        candidateList = cm.filterCandidate(numberOfCandidate);
                        break;
                    case "4":
                        System.out.println("Candidate list :");
                        if (candidateList.size() == 0)
                            System.out.println("No Data");
                        else
                            candidateList.forEach(
                                    c -> c.ShowMyInfor()
                            );
                }
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
//                System.out.println("Input files have unknow errors !!!");
            }
        }
        //
    }
}

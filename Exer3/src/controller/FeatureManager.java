package controller;

import model.AStudent;
import model.BStudent;
import model.CStudent;
import model.Candidate;
import relatedException.InvalidAddressException;
import relatedException.InvalidNameException;
import relatedException.InvalidGradeException;
import relatedException.InvalidPriorityException;

import java.util.Arrays;
import java.util.Scanner;

public class FeatureManager {
    public void viewByLine(String... params) {
        Arrays.stream(params).forEach(
                s -> System.out.println(s)
        );
    }
    static float getPoint(String typeOfPoint){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter "+typeOfPoint+": ");

        float point;
        try{
            point = Float.parseFloat(sc.nextLine());
            return point;
        }catch (NumberFormatException ex){
            System.out.println("Invalid "+ typeOfPoint);
            return -1;
        }

    }
    private static Candidate getCandidateInfo(){
        Scanner sc = new Scanner(System.in);
        Candidate newCandidate;
        String id;
        String name;
        String address;
        int priority;
        try{
            System.out.println("Enter Id:");
            id = sc.nextLine().trim();
            if(id.isEmpty()) throw new InvalidNameException();
            System.out.println("Enter Name: ");
            name = sc.nextLine().trim();
            if(name.isEmpty()) throw new InvalidNameException();
            System.out.println("Enter address:");
            address = sc.nextLine().trim();
            if(address.isEmpty()) throw new InvalidAddressException();
            System.out.println("Enter priority(a number): ");
            try {
                priority = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException ex){
                throw new InvalidPriorityException("Invalid Priority format",ex);
            }
            return new Candidate(id,name,address,priority);
        }catch (RuntimeException ex){
            System.out.println(ex.getMessage());
        }
        return null;
    }
    public AStudent getAAStudentInfor(){
        Candidate newCan;
        float mathGrade;
        float physicsGrade;
        float chemistryGrade;
        newCan = getCandidateInfo();
        if (newCan == null) return null;

        try {

            mathGrade = getPoint("Math Grade");
            if(mathGrade == -1 ) throw new InvalidGradeException("Invalid Math Grade");
            physicsGrade = getPoint("physics Grade");
            if(physicsGrade == -1 ) throw new InvalidGradeException("Invalid physics Grade");
            chemistryGrade = getPoint("chemistry Grade");
            if(chemistryGrade == -1 ) throw new InvalidGradeException("Invalid chemistry Grade");

        } catch (InvalidGradeException ex) {
            ex.getMessage();
            return null;
        }
        newCan = new AStudent(newCan.getId(), newCan.getName(), newCan.getAddress()
                , newCan.getPriority(), mathGrade,
                physicsGrade,chemistryGrade
        );
        return (AStudent) newCan;
    }

    public BStudent getABStudentInfor(){
        Candidate newCan;
        newCan = getCandidateInfo();
        if (newCan == null) return null;
        float mathGrade;
        float chemistryGrade;
        float biologyGrade;

        try {
            mathGrade = getPoint("Math Grade");
            if(mathGrade == -1 ) throw new InvalidGradeException("Invalid Math Grade");
            biologyGrade = getPoint("biology Grade");
            if(biologyGrade == -1 ) throw new InvalidGradeException("Invalid biology Grade");
            chemistryGrade = getPoint("chemistry Grade");
            if(chemistryGrade == -1 ) throw new InvalidGradeException("Invalid chemistry Grade");

        } catch (InvalidGradeException ex) {
            ex.getMessage();
            return null;
        }
        newCan = new BStudent(newCan.getId(), newCan.getName(), newCan.getAddress()
                , newCan.getPriority(), mathGrade,
                biologyGrade,chemistryGrade
        );
        return (BStudent)newCan;
    }
    public CStudent getACStudentInfor(){
        Candidate newCan;
        newCan = getCandidateInfo();
        if (newCan == null) return null;

        float literatureGrade;
        float historyGrade;
        float geographyGrade;
        try {
            literatureGrade = getPoint("literature Grade");
            if(literatureGrade == -1 ) throw new InvalidGradeException("Invalid literature Grade");
            historyGrade = getPoint("historyGrade");
            if(historyGrade == -1 ) throw new InvalidGradeException("Invalid historyGrade");
            geographyGrade = getPoint("geography Grade");
            if(geographyGrade == -1 ) throw new InvalidGradeException("Invalid geography Grade");

        } catch (InvalidGradeException ex) {
            ex.getMessage();
            return null;
        }
        newCan = new CStudent(newCan.getId(), newCan.getName(), newCan.getAddress()
                , newCan.getPriority(), literatureGrade,
                historyGrade,geographyGrade
        );
        return (CStudent) newCan;
    }


}

package model;

import java.time.LocalDate;

public class GoodStudent extends Student{
    private double gpa;
    private String bestRewardName;

    public GoodStudent(String fullName, LocalDate dob, boolean sex, String universityName, String gradeLevel, String phoneNumber, double gpa, String bestRewardName) {
        super(fullName, dob, sex, universityName, gradeLevel, phoneNumber);
        this.gpa = gpa;
        this.bestRewardName = bestRewardName;
    }

    public GoodStudent() {

    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public String getBestRewardName() {
        return bestRewardName;
    }

    public void setBestRewardName(String bestRewardName) {
        this.bestRewardName = bestRewardName;
    }

    @Override
    public void ShowMyInfor() {
        System.out.println("Type Of Student: Good\n" +
                "Full Name: " + super.getFullName() + "\n" +
                "University Name: " + super.getUniversityName() + "\n" +
                "Phone Number: " + super.getPhoneNumber() + "\n" +
                "Grade Level: " + super.getGradeLevel() + "\n" +
                "Date Of Birth: "+super.formatter.format(super.getDob())+"\n"+
                "Gender: "+(super.getSex()==true?"Male":"Female")+"\n"+
                "gpa: "+gpa+"\n"+
                "best Reward Name: "+bestRewardName
        );
    }
}

package model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class NormalStudent extends Student {
    private int englishScore;
    private int entryTestScore;

    public NormalStudent(String fullName, Date dob, boolean sex, String universityName, String gradeLevel, String phoneNumber, int englishScore, int entryTestScore) {
        super(fullName, dob, sex, universityName, gradeLevel, phoneNumber);
        this.englishScore = englishScore;
        this.entryTestScore = entryTestScore;
    }

    public NormalStudent() {
    }

    public int getEnglishScore() {
        return englishScore;
    }

    public void setEnglishScore(int englishScore) {
        this.englishScore = englishScore;
    }

    public int getEntryTestScore() {
        return entryTestScore;
    }

    public void setEntryTestScore(int entryTestScore) {
        this.entryTestScore = entryTestScore;
    }

    @Override
    public String toString() {
        return "NormalStudent{" +
                "englishScore=" + englishScore +
                ", entryTestScore=" + entryTestScore +
                '}';
    }

    @Override
    public void ShowMyInfor() {
        System.out.println("Type Of Student: Normal\n" +
                "Full Name: " + super.getFullName() + "\n" +
                "University Name: " + super.getUniversityName() + "\n" +
                "Phone Number: " + super.getPhoneNumber() + "\n" +
                "Grade Level: " + super.getGradeLevel() + "\n" +
                "Date Of Birth: "+new SimpleDateFormat("dd/MM/yyyy").format(super.getDob())+"\n"+
                "Gender: "+(super.getSex()==true?"Male":"Female")+"\n"+
                "English score: "+englishScore+"\n"+
                "Entry Test Point: "+entryTestScore
        );
    }
}

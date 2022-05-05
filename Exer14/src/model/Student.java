package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public abstract class Student {
    private String fullName;
    private Date dob;
    private boolean sex;
    private String universityName;
    private String gradeLevel;//
    private String phoneNumber;
    public Student(String fullName, Date dob, boolean sex, String universityName, String gradeLevel,String phoneNumber) {
        this.fullName = fullName;
        this.dob = dob;
        this.sex = sex;
        this.universityName = universityName;
        this.gradeLevel = gradeLevel;
        this.phoneNumber = phoneNumber;

    }
    public static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    public Student() {
    }

    public abstract void ShowMyInfor();

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public boolean getSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

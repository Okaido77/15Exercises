package model;

public class Course {
    private double averageGrade;
    private int credit;
    private String name;


    public double getAverageGrade() {
        return averageGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course(double averageGrade, int credit, String name) {
        this.averageGrade = averageGrade;
        this.credit = credit;
        this.name = name;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }

}

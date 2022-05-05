package model;

import java.util.LinkedList;
import java.util.List;

public class Semester {
    private String name;
    //courseName + grade
    private List<Course> courseList;
    private double averageScore;
    private int startYear;

    public Semester(String name, int startYear) {
        this.name = name;
        this.startYear = startYear;
    }



    public Semester(String name) {
        this.name = name;
    }


    public Semester(Semester semester) {
        this.name = semester.getName();
        this.courseList = new LinkedList<>();
        this.startYear = semester.getStartYear();

    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    //6
    public void calculateAverageScore() throws Exception {
        double totalMix = 0;
        int totalOfCredit = 0;

        if(courseList == null ) throw new Exception("course list is empty");
        int size = courseList.size();
        if (size == 0) {
            averageScore = 0;
            return;
        }
        for (Course g : courseList) {
            totalMix += g.getAverageGrade()*g.getCredit();
            totalOfCredit += g.getCredit();
        }
        averageScore = totalMix / totalOfCredit;
    }
    //

    public double getAverageScore() throws Exception {
//        calculateAverageScore();
        return averageScore;
    }

    public void setAverageScore(double averageScore) {
        this.averageScore = averageScore;
    }

}

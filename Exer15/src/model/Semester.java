package model;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Semester {
    private String name;
    //courseName + grade
    private List<Course> courseList;
    private double averageScore;

    public Semester(String name, List<Course> courseList) {
        this.name = name;
        this.courseList = courseList;
    }

    public Semester(String name, double averageScore) {
        this.name = name;
        this.averageScore = averageScore;
    }

    public Semester() {
    }

    public Semester(Semester semester) {
        this.name = semester.getName();
        this.courseList = new LinkedList<>(courseList);
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

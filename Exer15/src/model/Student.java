package model;

import java.util.*;

public abstract class Student {
    private String id;
    private String name;
    private Date dateOfBirth;
    private int startYear;
    // điểm đầu vào
    private double entryPoint;
    private String faculty;
    private List<Semester> semesters;
    private double avgAllSemester;




    public Student(String id, String name, Date dateOfBirth, int startYear, double entryPoint, List<Semester> semesters, String faculty) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.startYear = startYear;
        this.entryPoint = entryPoint;
        this.semesters = semesters;
        this.faculty = faculty;
    }

    public Student() {
    }
    //copy constuctor
    public Student(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.dateOfBirth = new Date(student.getDateOfBirth().getTime()) ;
        this.startYear = student.getStartYear();
        this.entryPoint = new Double(student.getEntryPoint());
        this.semesters = new LinkedList<>(student.semesters) ;
        this.faculty = student.getFaculty();
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String facultyName) {
        this.faculty = facultyName;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public double getEntryPoint() {
        return entryPoint;
    }

    public void setEntryPoint(double entryPoint) {
        this.entryPoint = entryPoint;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> avgScoreOfSemesters) {
        this.semesters = avgScoreOfSemesters;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", startYear=" + startYear +
                ", entryPoint=" + entryPoint +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return Objects.equals(getId(), student.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    public abstract void ShowInfo();




}

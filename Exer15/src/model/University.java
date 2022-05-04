package model;

import java.util.List;

public class University {
    private String name;
    private List<Student> students;
    private List<Faculty> faculties;
    private List<Semester> semesters;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }


    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public List<Semester> getSemesters() {
        return semesters;
    }

    public void setSemesters(List<Semester> semesters) {
        this.semesters = semesters;
    }



    public University(String name, List<Faculty> faculties, List<Semester> semesters) {
        this.name = name;
        this.faculties = faculties;
        this.semesters = semesters;
    }

    public University(String name, List<Student> students, List<Faculty> faculties, List<Semester> semesters) {
        this.name = name;
        this.students = students;
        this.faculties = faculties;
        this.semesters = semesters;
    }

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        this.faculties = faculties;
    }

    public University() {
    }
}

package model;

import java.util.LinkedList;
import java.util.List;

public class University {
    private String name;
    private List<StudentStandardModel> students ;
    private List<Faculty> faculties = new LinkedList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StudentStandardModel> getStudents() {
        return students;
    }

    public void setStudents(List<StudentStandardModel> students) {
        this.students = students;
    }

    public List<Faculty> getFaculties() {
        return faculties;
    }

    public void setFaculties(List<Faculty> faculties) {
        this.faculties = faculties;
    }

    public University(String name, List<StudentStandardModel> students, List<Faculty> faculties) {
        this.name = name;
        this.students = students;
        this.faculties = faculties;
    }

    public University(String name, List<Faculty> faculties) {
        this.name = name;
        this.students = students;
        this.faculties = faculties;
    }

    public University() {
    }
}

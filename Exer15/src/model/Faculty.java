package model;

import java.util.List;

public class Faculty {
    private String facultyName;
    private List<Student> studentList;

    public Faculty(String facultyName, List<Student> studentList) {
        this.facultyName = facultyName;
        this.studentList = studentList;
    }

    public Faculty() {
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setSubjectList(List<Student> studentList) {
        this.studentList = studentList;
    }
}

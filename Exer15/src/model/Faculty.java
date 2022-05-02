package model;

import java.util.List;

public class Faculty {
    private String facultyName;
    private List<StudentStandardModel> studentList;

    public Faculty(String facultyName, List<StudentStandardModel> studentList) {
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

    public List<StudentStandardModel> getSubjectList() {
        return studentList;
    }

    public void setSubjectList(List<StudentStandardModel> studentList) {
        this.studentList = studentList;
    }
}

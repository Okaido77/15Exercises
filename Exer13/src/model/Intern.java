package model;

import java.util.Date;
import java.util.List;

public class Intern extends Employee {
    private String Majors;
    private String Semester;
    private String University_name;

    public Intern(String ID, String fullName, Date birthDay, String phone, String email, String employee_type, List<Certificate> certificates) {
        super(ID, fullName, birthDay, phone, email, employee_type, certificates);
    }

    public String getMajors() {
        return Majors;
    }

    public void setMajors(String majors) {
        Majors = majors;
    }

    public String getSemester() {
        return Semester;
    }

    public void setSemester(String semester) {
        Semester = semester;
    }

    public String getUniversity_name() {
        return University_name;
    }

    public void setUniversity_name(String university_name) {
        University_name = university_name;
    }

    @Override
    public void showInformation() {

    }
}

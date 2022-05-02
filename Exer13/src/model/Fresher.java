package model;

import java.util.Date;
import java.util.List;

public class Fresher extends Employee {

    private Date Graduation_date;
    private String Graduation_rank;
    private String Education;// name of school

    public Fresher(String ID, String fullName, Date birthDay, String phone, String email, String employee_type, List<Certificate> certificates) {
        super(ID, fullName, birthDay, phone, email, employee_type, certificates);
    }


    @Override
    public void showMe() {

    }

    public Date getGraduation_date() {
        return Graduation_date;
    }

    public void setGraduation_date(Date graduation_date) {
        Graduation_date = graduation_date;
    }

    public String getGraduation_rank() {
        return Graduation_rank;
    }

    public void setGraduation_rank(String graduation_rank) {
        Graduation_rank = graduation_rank;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }
}

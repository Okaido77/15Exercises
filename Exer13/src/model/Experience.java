package model;

import java.util.Date;
import java.util.List;

public class Experience extends Employee {
    private int ExpInYear;
    private String ProSkill;

    public Experience(String ID, String fullName, Date birthDay, String phone, String email, String employee_type, List<Certificate> certificates) {
        super(ID, fullName, birthDay, phone, email, employee_type, certificates);
    }

    public int getExpInYear() {
        return ExpInYear;
    }

    public void setExpInYear(int expInYear) {
        ExpInYear = expInYear;
    }

    public String getProSkill() {
        return ProSkill;
    }

    public void setProSkill(String proSkill) {
        ProSkill = proSkill;
    }

    @Override
    public void showInformation() {
        System.out.println("Type Of Employee:" + super.getEmployee_type() + "\n" +
                "ID='" + super.getID() + '\'' +
                ", FullName='" + super.getFullName() + '\'' +
                ", BirthDay=" + super.getBirthDay() +
                ", Phone='" + super.getPhone() + '\'' +
                ", Email='" + super.getEmail() + '\'' +
                ", ExpInYear='" + ExpInYear + '\'' +
                ", ProSkill='" + ProSkill + '\''
        );
    }
}

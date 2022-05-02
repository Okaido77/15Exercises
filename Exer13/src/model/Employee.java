package model;

import java.util.Date;
import java.util.List;

public abstract class Employee {

    private String ID;
    private String FullName;
    private Date BirthDay;
    private String Phone;
    private String Email;
    private String Employee_type;
    private static int Employee_count = 0;
    private List<Certificate> certificates;

    public Employee(String ID, String fullName, Date birthDay, String phone, String email, String employee_type, List<Certificate> certificates) {
        this.ID = ID;
        FullName = fullName;
        BirthDay = birthDay;
        Phone = phone;
        Email = email;
        Employee_type = employee_type;
        this.certificates = certificates;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public Date getBirthDay() {
        return BirthDay;
    }

    public void setBirthDay(Date birthDay) {
        BirthDay = birthDay;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getEmployee_type() {
        return Employee_type;
    }

    public void setEmployee_type(String employee_type) {
        Employee_type = employee_type;
    }

    public static int getEmployee_count() {
        return Employee_count;
    }

    public static void setEmployee_count(int employee_count) {
        Employee_count = employee_count;
    }

    public List<Certificate> getCertificates() {
        return certificates;
    }

    public void setCertificates(List<Certificate> certificates) {
        this.certificates = certificates;
    }

    public abstract void showMe();
}

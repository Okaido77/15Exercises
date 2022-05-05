package model;

import java.util.Date;
import java.util.List;

public class RegularStudent extends Student {
    public RegularStudent(String id, String name, Date dateOfBirth, int startYear, double entryPoint, List<Semester> semesters, String faculty) {
        super(id, name, dateOfBirth, startYear, entryPoint, semesters, faculty);
    }

    public RegularStudent() {
    }

    @Override
    public void ShowInfo() {
        System.out.println(
                "Type Of Student: " + this.getClass().getSimpleName() + "\n" +
                        "id='" + super.getId() + '\'' +
                        ", name='" + super.getName() + '\'' +
                        ", dateOfBirth=" + super.getDateOfBirth() +
                        ", startYear=" + super.getStartYear() +
                        ", entryPoint=" + super.getEntryPoint());
            if(super.getSemesters()!=null&&super.getSemesters().size()!=0) {
                System.out.println("List of semester: ");
                super.getSemesters().forEach(
                        s -> {
                            try {
                                System.out.println("Name:" + s.getName() + "avg:" + s.getAverageScore());
                            } catch (Exception e) {
                                System.out.println("Warning:");
                                System.out.println(e.getMessage());
                            }
                        }
                );
            }else{
                System.out.println("Sinh viên này chưa nhập thông tin các học kì");
            }



    }


}

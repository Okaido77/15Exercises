package model;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class RegularStudent extends StudentStandardModel {
    public RegularStudent(String id, String name, Date dateOfBirth, Date startYear, double entryPoint, List<Semester> semesters, String faculty) {
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



    }


}

package model;

import java.util.Date;
import java.util.List;

public class In_serviceStudent extends Student {
    private String trainingCoopPlace;

    public String getTrainingCoopPlace() {
        return trainingCoopPlace;
    }

    public void setTrainingCoopPlace(String trainingCoopPlace) {
        this.trainingCoopPlace = trainingCoopPlace;
    }

    public In_serviceStudent(String id, String name, Date dateOfBirth, int startYear, double entryPoint, List<Semester> avgScoreOfSemesters, String department, String trainingCoopPlace) {
        super(id, name, dateOfBirth, startYear, entryPoint, avgScoreOfSemesters, department);
        this.trainingCoopPlace = trainingCoopPlace;
    }

    public In_serviceStudent() {

    }

    public In_serviceStudent(In_serviceStudent in_serviceStudent) {
        super(in_serviceStudent);
        this.trainingCoopPlace = in_serviceStudent.getTrainingCoopPlace();
    }

    @Override
    public String toString() {
        return "In_serviceStudent{" +
                "trainingPlace='" + trainingCoopPlace + '\'' +
                '}';
    }

    @Override
    public void ShowInfo() {
        System.out.println(
                "Type Of Student: " + this.getClass().getSimpleName() + "\n" +
                        "id='" + super.getId() + '\'' +
                        ", name='" + super.getName() + '\'' +
                        ", dateOfBirth=" + super.getDateOfBirth() +
                        ", startYear=" + super.getStartYear() +
                        ", entryPoint=" + super.getEntryPoint() +
                        ", trainingPlace='" + trainingCoopPlace + '\'');
        if (super.getSemesters() != null&&super.getSemesters().size()!=0) {
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
        } else {
            System.out.println("Sinh viên này chưa nhập thông tin các học kì");
        }
    }


}

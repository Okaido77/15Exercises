package Service;

import model.*;
import relatedException.studentModelException.InvalidDateOfBirthException;
import relatedException.studentModelException.InvalidNameException;
import relatedException.studentModelException.InvalidStartYearException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class StudentService {
    Scanner sc = new Scanner(System.in);


    public RegularStudent takeRegularStudent(University university) throws Exception {
        StudentStandardModel ssm = takeGeneralStudentInfo(university);
        RegularStudent rs = new RegularStudent(ssm.getId(), ssm.getName(), ssm.getDateOfBirth(), ssm.getStartYear(), ssm.getEntryPoint(),
                ssm.getSemesters(), ssm.getFaculty());
        return rs;
    }

    public In_serviceStudent takeIn_serviceStudent(University university) throws Exception {
        StudentStandardModel ssm = takeGeneralStudentInfo(university);
        System.out.println("Enter training cooperation place:");
        String trainingCoopPlace = sc.nextLine().trim();
        if (trainingCoopPlace.isEmpty())
            throw new Exception("training cooperation place is empty");
        In_serviceStudent iss = new In_serviceStudent(ssm.getId(), ssm.getName(), ssm.getDateOfBirth(), ssm.getStartYear(), ssm.getEntryPoint(),
                ssm.getSemesters(), ssm.getFaculty(), trainingCoopPlace);
        return iss;
    }


    public StudentStandardModel takeGeneralStudentInfo(University university) throws Exception {
        String id;
        String name;
        Date dateOfBirth;
        Date startYear;
        // điểm đầu vào
        double entryPoint;
        String faculty;
        List<Semester> semesters;
        double avgAllSemester;
        String input;
        //add id
        System.out.println("Enter Id: ");
        id = sc.nextLine().trim();
        if (id.isEmpty()) throw new Exception("Id is empty!");

        //add name
        System.out.println("Enter Name");
        name = sc.nextLine().trim();
        if (name.isEmpty()) throw new InvalidNameException("Name is empty");

        //add dob
        System.out.println("enter date Of Birth(yyyy-mm-dd)");
        input = sc.nextLine().trim();
        if (input.isEmpty()) throw new InvalidDateOfBirthException("Date Of Birth is empty");
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        try {
            dateOfBirth = df.parse(input);
        } catch (Exception ex) {
            throw new InvalidDateOfBirthException("Incorrect Date of birth format", ex);
        }

        //add first year
        System.out.println("Enter First Year:");
        input = sc.nextLine().trim();

        if (input.isEmpty()) throw new InvalidStartYearException("start year is empty");
        df = new SimpleDateFormat("yyyy");
        try {
            startYear = df.parse(input);
        } catch (Exception ex) {
            throw new InvalidStartYearException("Incorrect start year format", ex);
        }

        // add entry point
        System.out.println("Enter entry point: ");
        input = sc.nextLine().trim();
        if (input.isEmpty()) throw new Exception("entry point is empty");
        try {
            entryPoint = Double.parseDouble(input);
        } catch (NumberFormatException ex) {
            throw new Exception("incorrect Entry point format ");
        }

        //add faculty
        System.out.println("Choose faculty:");
        List<Faculty> faculties = university.getFaculties();
        int sizeOfFaculties = faculties.size();
        if (sizeOfFaculties == 0) throw new Exception("no faculty data");
        // print choices
        for (int i = 0; i < sizeOfFaculties; i++) {
            System.out.println((i + 1) + "." + faculties.get(i).getFacultyName());
        }
        input = sc.nextLine().trim();
        if (input.isEmpty())
            throw new Exception("faculty choice is empty");
        try {
            int choice = Integer.parseInt(input);
            try {
                faculty = faculties.get(choice - 1).getFacultyName();
            } catch (NullPointerException ex) {
                throw new Exception("this choice is not present", ex);
            }
        } catch (NumberFormatException ex) {
            throw new Exception("Incorrect choice format", ex);
        }

        //add student without semester
        StudentStandardModel ssm = new StudentStandardModel(id, name, dateOfBirth, startYear, entryPoint, null, faculty) {
            @Override
            public void ShowInfo() {
            }
        };

        //add semester into student
        System.out.println("Add Some Semesters?:\n" +
                "1.Yes\n" +
                "2.No\n");
        String choice = sc.nextLine().trim();
        switch (choice) {
            case "1":
                ssm = addSemester(ssm);
                break;
            case "2":
                return ssm;
            default:
                throw new Exception("invalid choice");
        }

        return ssm;
    }

    private StudentStandardModel addSemester(StudentStandardModel ssm) throws Exception {
        String input;
        List<Semester> semesterList = new LinkedList<>();
        String semesterName;
        String courseName;
        double grade;
        do {
            Semester s = new Semester();
            System.out.println("Enter semester name : ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) throw new Exception("semester name is empty");
            semesterName = input;

            System.out.println("Add some Courses?(y/n)");
            input = sc.nextLine().trim();
            switch (input) {
                case "y":
                    s = addCourse(s);
                    System.out.println("Auto calculate average score successfully!");
                    s.calculateAverageScore();
                    break;
                case "n":
                    System.out.println("enter avg grade of semester");
                    input = sc.nextLine().trim();
                    if (input.isEmpty()) throw new Exception("grade is empty");
                    try {
                        grade = Double.parseDouble(input);
                    } catch (Exception ex) {
                        throw new Exception("incorrect grade format");
                    }
                    if (grade < 0) throw new Exception("grade must not be less than 0");

                    //add semester into semester list

                    s.setAverageScore(grade);
                    break;
                default:
                    throw new Exception("Invalid choice");

            }
            s.setName(semesterName);
            ssm.getSemesters().add(s);

//            System.out.println("enter course name:");
//            courseName = sc.nextLine().trim();
//            if(courseName.isEmpty()) throw new Exception("course name is empty");


            System.out.println("continue adding semester?(y/n)");
            input = sc.nextLine().trim();
            if (!input.equals("y") && !input.equals("n"))
                throw new Exception("incorrect choice !");

        } while (input.equals("y"));
        return ssm;
    }

    public Semester addCourse(Semester semester) throws Exception {
        String courseName;
        double grade;
        String input;
        int numberOfCredit;
        do {
            System.out.println("Enter name of course");
            courseName = sc.nextLine().trim();
            if (courseName.isEmpty()) throw new Exception("course name is empty ");
            final String courseNameFinal = courseName;
            boolean isDuplicated = semester.getCourseList().stream().filter(c -> courseNameFinal.equals(c.getName())).findFirst().isPresent();
            if (isDuplicated) throw new Exception("this course already exists");

            System.out.println("Enter number of credit: ");
            input = sc.nextLine().trim();
            if (input.isEmpty())
                throw new Exception("number of credit is empty");
            try {
                numberOfCredit = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                throw new Exception("incorrect number of credit format", e);
            }
            System.out.println("Enter grade of " + courseName + ":");
            input = sc.nextLine().trim();
            if (input.isEmpty()) throw new Exception("grade is empty");
            try {
                grade = Double.parseDouble(input);
            } catch (NumberFormatException ex) {
                throw new Exception("grade is invalid", ex);
            }
            semester.getCourseList().add(new Course(grade, numberOfCredit, courseName));

            System.out.println("continue adding course?(y/n)");
            input = sc.nextLine().trim();
            if (!input.equals("y") && !input.equals("n"))
                throw new Exception("incorrect choice !");
        } while (input.equals("y"));

        return semester;
    }


}

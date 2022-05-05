package Service;

import model.*;
import relatedException.studentModelException.InvalidDateOfBirthException;
import relatedException.studentModelException.InvalidNameException;
import relatedException.studentModelException.InvalidStartYearException;
import validation.StudentValidation;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class FeatureContainer {
    Scanner sc = new Scanner(System.in);
    UniversityManager um;
    List<Faculty> fl;

    public FeatureContainer(University uni) {
        um = new UniversityManager(uni);
        fl = um.getUni().getFaculties();
    }

    public void addAStudent() throws Exception {
        String input;
        ViewService.viewAllLines("choose type of student",
                "1.Regular Student",
                "2.In-service Student");
        input = sc.nextLine().trim();
        boolean isSuccess = false;
        switch (input) {
            case "1":
                RegularStudent rs = takeRegularStudent();
                isSuccess = um.addStudent(rs);
                break;
            case "2":
                In_serviceStudent is = takeIn_serviceStudent();
                isSuccess = um.addStudent(is);
                break;
            default:
                throw new Exception("Invalid Choice");
        }
        if (isSuccess) System.out.println("Add student successfully");
        else
            System.out.println("Fail to add because this id is duplicated");
    }

    private RegularStudent takeRegularStudent() throws Exception {
        Student ssm = takeGeneralStudentInfo();
        RegularStudent rs = new RegularStudent(ssm.getId(), ssm.getName(), ssm.getDateOfBirth(), ssm.getStartYear(), ssm.getEntryPoint(),
                ssm.getSemesters(), ssm.getFaculty());
        return rs;
    }

    private In_serviceStudent takeIn_serviceStudent() throws Exception {
        Student ssm = takeGeneralStudentInfo();
        System.out.println("Enter training cooperation place:");
        String trainingCoopPlace = sc.nextLine().trim();
        if (trainingCoopPlace.isEmpty())
            throw new Exception("training cooperation place is empty");
        In_serviceStudent iss = new In_serviceStudent(ssm.getId(), ssm.getName(), ssm.getDateOfBirth(), ssm.getStartYear(), ssm.getEntryPoint(),
                ssm.getSemesters(), ssm.getFaculty(), trainingCoopPlace);
        return iss;
    }


    private Student takeGeneralStudentInfo() throws Exception {
        String id;
        String name;
        Date dateOfBirth;
        int startYear;
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
        name = StudentValidation.toName(name);

        //add dob
        System.out.println("enter date Of Birth(yyyy-mm-dd)");
        input = sc.nextLine().trim();
        dateOfBirth = StudentValidation.toDateOfBirth(input);

        //add first year
        System.out.println("Enter start Year:");
        input = sc.nextLine().trim();
        startYear = StudentValidation.toStartYear(input);


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
        List<Faculty> faculties = um.getUni().getFaculties();
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
        // kiểm tra trong đối tượng có danh sách các kì chưa

        List<Semester> bsl = um.getUni().getSemesters();
        List<Semester> semesterList = new LinkedList<>();
        for (Semester s : bsl) {
            int gap = s.getStartYear() - startYear;
            if (gap <= 7 && gap >= 0)// chỉ add các kì học trong vòng 7 năm từ khi vào trường
                semesterList.add(new Semester(s));
        }
        // student without semester
        Student ssm = new Student(id, name, dateOfBirth, startYear, entryPoint, semesterList, faculty) {
            @Override
            public void ShowInfo() {
            }
        };

        //add semester into student
        System.out.println("Add Some Semesters?(y/n)");
        String choice = sc.nextLine().trim();
        switch (choice) {
            case "y":
                ssm = addSemester(ssm);
                break;
            case "n":
                return ssm;
            default:
                throw new Exception("invalid choice");
        }

        return ssm;
    }

    private Student addSemester(Student ssm) throws Exception {
        String input;
        List<Semester> semesterList;
        semesterList = ssm.getSemesters();
        if (semesterList.size() == 0) {
            System.out.println("Sinh viên không có học kì do năm nhập học chênh với các kì khả dụng hơn 7 năm\n" +
                    "hoặc kì học tiếp theo chưa có");
            return ssm;
        }
        double grade;
        for (Semester s : semesterList) {
            System.out.println("semester :" + s.getName());
            System.out.println("Add some Courses?(y/n)");
            input = sc.nextLine().trim();
            switch (input) {
                case "y":
                    s = addCourse(s);
                    s.calculateAverageScore();
                    System.out.println("Auto calculate average score successfully!");
                    break;
                case "n":
                    System.out.println("enter avg grade of semester");
                    input = sc.nextLine().trim();
                    grade = StudentValidation.toGrade(input);
                    //add semester into semester list
                    s.setAverageScore(grade);
                    break;
                default:
                    throw new Exception("Invalid choice");
            }

        }
        ssm.setSemesters(semesterList);
        System.out.println("Add Semester infomation successfully");
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
            List<Course> cl = semester.getCourseList();
            if (cl == null) {
                cl = new LinkedList<>();
                semester.setCourseList(cl);
            }
            boolean isDuplicated = cl.stream().filter(c -> courseNameFinal.equals(c.getName())).findFirst().isPresent();
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
            cl.add(new Course(grade, numberOfCredit, courseName));

            System.out.println("continue adding course?(y/n)");
            input = sc.nextLine().trim();
            if (!input.equals("y") && !input.equals("n"))
                throw new Exception("incorrect choice !");
        } while (input.equals("y"));

        return semester;
    }

    void printFaculty(List<Faculty> fs) {
        System.out.println("Choose faculty:");
        for (int i = 0; i < fs.size(); i++) {
            System.out.println((i + 1) + "." + fs.get(i).getFacultyName());
        }
        System.out.println("a.All Faculty");
    }

    public void total2TypeStudent() throws Exception {
        printFaculty(fl);
        String choice = sc.nextLine().trim();
        if (!choice.equals("a"))
            try {
                Faculty fa = fl.get(Integer.parseInt(choice) - 1);
                System.out.println("Faculty:" + fa.getFacultyName());

                long numberOfISS = um.countStudentByType("In_serviceStudent", fa.getFacultyName());
                System.out.println("Number Of In-Service Student: " + numberOfISS);
                long numberOfRS = um.countStudentByType("RegularStudent", fa.getFacultyName());
                System.out.println("Number Of Regular Student: " + numberOfRS);

            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        else {
            for (Faculty fa : fl) {
                System.out.println("Faculty:" + fa.getFacultyName());
                long numberOfISS = um.countStudentByType("In_serviceStudent", fa.getFacultyName());
                System.out.println("Number Of In-Service Student: " + numberOfISS);
                long numberOfRS = um.countStudentByType("RegularStudent", fa.getFacultyName());
                System.out.println("Number Of Regular Student: " + numberOfRS);
            }
        }
    }

    public void highestEntryStudents() {
        for (Faculty fa : fl) {
            System.out.println("Faculty(Khoa) " + fa.getFacultyName() + ":");
            List<Student> s = um.HighestEntryPointStudent(fa.getFacultyName());
            if (s == null || s.size() == 0) System.out.println("No Data");
            for (Student ssm : s) {
                ssm.ShowInfo();
            }
        }
    }

    public void listInServiceStudentAt() throws Exception {
        System.out.println("Enter TrainingCoopPlace:");
        String trainingCoopPlace = sc.nextLine().trim();
        printFaculty(fl);

        String choice = sc.nextLine().trim();
        List<In_serviceStudent> isl;
        if (!choice.equals("a"))
            try {
                Faculty fa = fl.get(Integer.parseInt(choice) - 1);
                System.out.println("Faculty:" + fa.getFacultyName());
                isl = um.getIn_serviceStudentAt(fa, trainingCoopPlace);
                isl.forEach(
                        i -> i.ShowInfo()
                );
                if (isl == null || isl.size() == 0) System.out.println("No Data");
            } catch (Exception e) {
                throw new Exception(e.getMessage());
            }
        else {
            for (Faculty fa : fl) {
                System.out.println("Faculty:" + fa.getFacultyName());
                isl = um.getIn_serviceStudentAt(fa, trainingCoopPlace);
                isl.forEach(
                        i -> i.ShowInfo()
                );
                if (isl == null || isl.size() == 0) System.out.println("No Data");
            }
        }

    }

    //danh sách sinh viên có điểm trung bình ở học kỳ gần nhất từ 8.0 trở lên
    public void request_4() throws Exception {
        printFaculty(fl);
        String faIndex = sc.nextLine().trim();
        List<Student> l;
        Semester lastSemester = um.getUni().getSemesters().get(um.getUni().getSemesters().size() - 1);
        if (!faIndex.equals("a")) {
            Faculty fa = fl.get(Integer.parseInt(faIndex) - 1);
            System.out.println("Faculty:" + fa.getFacultyName());
            l = um.findStudentsHigherThan(fa, lastSemester, 8);
            for (Student s : l) {
                s.ShowInfo();
            }
            if (l == null || l.size() == 0) System.out.println("No Data");

        } else {
            for (Faculty fa : fl) {
                System.out.println("Faculty:" + fa.getFacultyName());
                l = um.findStudentsHigherThan(fa, lastSemester, 8);
                for (Student s : l) {
                    s.ShowInfo();
                }
                if (l == null || l.size() == 0) System.out.println("No Data");
            }
        }
    }

    //sinh viên có điểm trung bình học kỳ cao nhất (ở bất kỳ học kỳ nào) theo khoa
    public void request_5() throws Exception {
        printFaculty(fl);
        String faIndex = sc.nextLine().trim();// faculty index
        Semester semester = chooseSemester();
        List<Student> l;
        if (!faIndex.equals("a")) {
            Faculty fa = fl.get(Integer.parseInt(faIndex) - 1);
            System.out.println("Faculty:" + fa.getFacultyName());
            l = um.getHighestAvgGradeStudent(fa, semester);
            if (l == null || l.size() == 0) System.out.println("No Data");
            else
                for (Student s : l) {
                    s.ShowInfo();
                }
        } else {
            for (Faculty fa : fl) {
                System.out.println("Faculty:" + fa.getFacultyName());
                l = um.getHighestAvgGradeStudent(fa, semester);
                if (l == null || l.size() == 0) System.out.println("No Data");
                else
                    for (Student s : l) {
                        s.ShowInfo();
                    }
            }
        }
    }

    // return index
    private Semester chooseSemester() throws Exception {
        System.out.println("choose semester: ");
        List<Semester> sl = um.getUni().getSemesters();
        for (int i = 0; i < sl.size(); i++) {
            System.out.println((i + 1) + "." + sl.get(i).getName());
        }
        int index;
        try {
            index = Integer.parseInt(sc.nextLine().trim()) - 1;
        } catch (Exception ex) {
            throw new Exception("invalid Choice");
        }
        return sl.get(index);
    }

    public void request_6() throws Exception {
        printFaculty(fl);
        String faIndex = sc.nextLine().trim();// faculty index
        if (!faIndex.equals("a")) {
            Faculty fa = fl.get(Integer.parseInt(faIndex) - 1);
            System.out.println("Faculty:" + fa.getFacultyName());
            List<Student> l = um.sortByTypeAndYear(fa);
            if (l == null || l.size() == 0) System.out.println("No data");
            else
                for (Student s : l) {
                    s.ShowInfo();
                }
        } else {
            for (Faculty fa : fl) {
                System.out.println("Faculty:" + fa.getFacultyName());
                List<Student> l = um.sortByTypeAndYear(fa);
                if (l == null || l.size() == 0) System.out.println("No data");
                else
                    for (Student s : l) {
                        s.ShowInfo();
                    }
            }
        }
    }

    public void request_7() throws Exception {
        printFaculty(fl);
        String faIndex = sc.nextLine().trim();// faculty index
        if (!faIndex.equals("a")) {
            Faculty fa = fl.get(Integer.parseInt(faIndex) - 1);
            System.out.println("Faculty:" + fa.getFacultyName());
            Map<Integer, List<Student>> m = um.countStudentByYear(fa);
            if (m == null || m.size() == 0) System.out.println("No data");
            else
                for (Map.Entry e : m.entrySet()) {
                    System.out.println("năm:" + e.getKey() + "có: " + ((List<Student>) e.getValue()).size() + " học sinh vào khoa");
                }
        } else {
            for (Faculty fa : fl) {
                System.out.println("Faculty:" + fa.getFacultyName());
                Map<Integer, List<Student>> m = um.countStudentByYear(fa);
                if (m == null || m.size() == 0) System.out.println("No data");
                else
                    for (Map.Entry e : m.entrySet()) {
                        System.out.println("năm:" + e.getKey() + "có: " + ((List<Student>) e.getValue()).size() + " học sinh vào khoa");
                    }
            }
        }

    }

}

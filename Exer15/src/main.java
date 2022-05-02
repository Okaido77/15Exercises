import Service.ViewService;
import Service.StudentService;
import Service.UniversityManager;
import model.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class main {
    static void printFaculty(List<Faculty> fs) {
        System.out.println("Choose faculty:");
        for (int i = 0; i < fs.size(); i++) {
            System.out.println((i + 1) + "." + fs.get(i).getFacultyName());
        }
        System.out.println("a.All Faculty");
    }

    public static void main(String[] args) {
        List<Faculty> fs = new LinkedList<>();
        fs.add(new Faculty("Software Engineering", new LinkedList<>()));
        fs.add(new Faculty("International Bussiness", new LinkedList<>()));

        University uni = new University("fpt", fs);
        UniversityManager um = new UniversityManager(uni);

        Scanner sc = new Scanner(System.in);
        StudentService ss = new StudentService();
        String input;
        String facultyName;
        String choice, choice2, choice3;

        while (true) {
            ViewService.viewAllLines("University Manager System: ",
                    "Enter your choice:",
                    "1.Add New Student",
                    "2.Statistics",
                    "3.Exit"
            );
            choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1":
                        ViewService.viewAllLines("choose type of student",
                                "1.Regular Student",
                                "2.In-service Student");
                        input = sc.nextLine().trim();
                        switch (input) {
                            case "1":
                                RegularStudent rs = ss.takeRegularStudent(uni);
                                um.addStudent(rs);
                                break;
                            case "2":
                                In_serviceStudent is = ss.takeIn_serviceStudent(uni);
                                um.addStudent(is);
                                break;
                            default:
                                throw new Exception("Invalid Choice");
                        }
                        break;


                    case "2":

                        ViewService.viewAllLines("Statics:",
                                "1.Xác định tổng số 2 loại sinh viên của các khoa",//7
                                "2.Tìm ra sinh viên có điểm đầu vào cao nhất ở mỗi khoa",//8
                                "3.lấy ra danh sách các sinh viên tại chức tại nơi liên kết đào tạo cho trước theo khoa",//9
                                "4.lấy ra danh sách sinh viên có điểm trung bình ở học kỳ gần nhất từ 8.0 trở lên theo khoa",//10
                                "5.tìm ra sinh viên có điểm trung bình học kỳ cao nhất (ở bất kỳ học kỳ nào) theo khoa",//11
                                "6.sắp xếp danh sách sinh viên tăng dần theo loại và giảm dần theo năm vào học theo khoa",
                                "7.thống kê số lượng sinh viên theo năm vào học theo khoa",
                                "8.back"
                        );
                        choice2 = sc.nextLine().trim();
                        switch (choice2) {
                            case "1":
                                printFaculty(fs);
                                choice3 = sc.nextLine().trim();
                                if (!choice3.equals("a"))
                                    try {
                                        Faculty fa = fs.get(Integer.parseInt(choice3) - 1);
                                        System.out.println("Faculty:" + fa.getFacultyName());
                                        long numberOfISS = um.countStudentByType("In_serviceStudent", fa.getFacultyName());
                                        System.out.println("Number Of In-Service Student: " + numberOfISS);
                                        long numberOfRS = um.countStudentByType("Regular Student", fa.getFacultyName());
                                        System.out.println("Number Of Regular Student: " + numberOfRS);
                                    } catch (Exception e) {
                                        throw new Exception("incorrect choice", e);
                                    }
                                else {
                                    for (Faculty fa : fs) {
                                        System.out.println("Faculty:" + fa.getFacultyName());
                                        long numberOfISS = um.countStudentByType("In_serviceStudent", fa.getFacultyName());
                                        System.out.println("Number Of In-Service Student: " + numberOfISS);
                                        long numberOfRS = um.countStudentByType("Regular Student", fa.getFacultyName());
                                        System.out.println("Number Of Regular Student: " + numberOfRS);
                                        System.out.println("");
                                    }
                                }
                                break;
                            case "2":
                                for(Faculty fa : fs){
                                    List<StudentStandardModel> s = um.HighestEntryPointStudent(fa.getFacultyName());
                                    for(StudentStandardModel ssm : s){
                                        ssm.ShowInfo();
                                    }
                                }
                            break;
                            case "3":

                                String trainingCoopPlace = sc.nextLine().trim();
                                printFaculty(fs);
                                choice3 = sc.nextLine().trim();
                                if (!choice3.equals("a"))
                                    try {
                                        Faculty fa = fs.get(Integer.parseInt(choice3) - 1);
                                        System.out.println("Faculty:" + fa.getFacultyName());
                                        List<In_serviceStudent> isl = um.getIn_serviceStudentAt(fa, trainingCoopPlace);
                                        isl.forEach(
                                                i -> i.ShowInfo()
                                        );
                                    } catch (Exception e) {
                                        throw new Exception("incorrect choice", e);
                                    }
                                else {
                                    for (Faculty fa : fs) {
                                        System.out.println("Faculty:" + fa.getFacultyName());
                                        List<In_serviceStudent> isl = um.getIn_serviceStudentAt(fa, trainingCoopPlace);
                                        isl.forEach(
                                                i -> i.ShowInfo()
                                        );
                                    }
                                }
                                break;
                            case "4":

                                printFaculty(fs);
                                break;
                            case "5":
                                printFaculty(fs);
                                break;
                            case "6":
                                printFaculty(fs);
                                break;
                            case "7":
                                break;
                            default:
                                throw new Exception("Invalid Choice");
                        }
                        break;
                    default:
                        throw new Exception("Invalid Choice");

                }
            } catch (Exception ex) {
                System.out.println("Error:");
                System.out.println(ex.getMessage());
            }

        }
    }
}

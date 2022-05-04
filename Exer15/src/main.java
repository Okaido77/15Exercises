import Service.ViewService;
import Service.FeatureContainer;
import Service.UniversityManager;
import model.*;

import java.util.Arrays;
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
        List<Semester> sl = Arrays.asList(new Semester("kì 1"),new Semester("Kì 2"));
        List<Student> stl = new LinkedList<>();
        University uni = new University("fpt",stl, fs,sl);
        Scanner sc = new Scanner(System.in);
        FeatureContainer fc = new FeatureContainer(uni);
        String choice, choice2;

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
                        fc.addAStudent();
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
                                System.out.println("tổng số 2 loại sinh viên của các khoa:");
                                fc.total2TypeStudent();
                                break;
                            case "2":
                                System.out.println("sinh viên có điểm đầu vào cao nhất ở mỗi khoa:");
                                fc.highestEntryStudents();
                                break;
                            case "3":
                                System.out.println("danh sách các sinh viên tại chức tại nơi liên kết đào tạo cho trước:");
                                fc.listInServiceStudentAt();
                                break;
                            case "4":
                                System.out.println("danh sách sinh viên có điểm trung bình ở học kỳ gần nhất từ 8.0 trở lên:");
                                fc.request_4();
                                break;
                            case "5":
                                System.out.println("sinh viên có điểm trung bình học kỳ cao nhất (ở bất kỳ học kỳ nào) theo khoa");
                                fc.request_5();
                                break;
                            case "6":
                                System.out.println("sắp xếp danh sách sinh viên tăng dần theo loại và giảm dần theo năm vào học:");
                                fc.request_6();
                                break;
                            case "7":
                                System.out.println("thống kê số lượng sinh viên theo năm vào học theo khoa:");
                                fc.request_7();
                                break;
                            case "8":
                                break;
                            default:
                                throw new Exception("Invalid Choice");
                        }

                        break;
                    case"3":
                        System.out.println("good bye");
                        return;
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

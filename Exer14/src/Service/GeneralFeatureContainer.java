package Service;

import model.GoodStudent;
import model.NormalStudent;
import model.Student;
import relatedException.studentException.InvalidDOBException;
import relatedException.studentException.InvalidFullNameException;
import relatedException.studentException.InvalidPhoneNumberException;
import relatedException.studentException.InvalidSexException;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class GeneralFeatureContainer {
    Scanner sc = new Scanner(System.in);
    public List<Student> loadData(String filePath) throws IOException {
        File f = new File("Student_List.txt");
        InputStream is = new FileInputStream(f);
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String line;
        while(true){
            line = br.readLine();

        }
    }
    public Student getGeneralStudent() throws Exception{
        String input;
        String fullName;
        LocalDate dob;
        boolean sex;
        String universityName;
        String gradeLevel;//
        String phoneNumber;
        System.out.println("enter fullName");
        fullName = sc.nextLine().trim();
        if(fullName.isEmpty()) throw new InvalidFullNameException();
        System.out.println("enter dob(dd/MM/yyyy)");
        try {

            dob = LocalDate.parse(sc.nextLine().trim(), Student.formatter);
        }catch(Exception ex){
            throw new InvalidDOBException();
        }
        System.out.println("enter sex(1 = male, 2 = female)");
        input = sc.nextLine().trim();
        if(input.equals("1")||input.equals("2"))
            sex = "1".equals(input);
        else throw new InvalidSexException("Invalid input(just 1 or 2 allowed)");
        System.out.println("Enter university name: ");
        universityName = sc.nextLine().trim();
        if(universityName.isEmpty()) throw new Exception("university name is empty");
        System.out.println("Grade Level:");
        gradeLevel = sc.nextLine().trim();
        if(gradeLevel.isEmpty()) throw new Exception("Grade Level  is empty");
        System.out.println("Phone Number:");
        phoneNumber = sc.nextLine().trim().replaceAll("\\s+","");
        if(phoneNumber.length()!=10) throw new InvalidPhoneNumberException("length of phone must equal 10");
        if(!" 090 098 091 031 035 038".contains(phoneNumber.substring(0,2)))
            throw new InvalidPhoneNumberException("phải bắt đầu bằng một trong các chuỗi số: 090, 098, 091, 031, 035 hoặc 038");

        return new Student(fullName,dob,sex,universityName,gradeLevel,phoneNumber) {
            @Override
            public void ShowMyInfor() {
            }
        };
    }
    public GoodStudent getAGoodStudent() throws Exception {
        Student s = getGeneralStudent();
        double gpa;
        String bestRewardName;
        String input ;
        System.out.println("Enter GPA:");
        input = sc.nextLine().trim();
        gpa = Double.parseDouble(input);
        if(gpa<3) throw new Exception("GPA of a Good Student must not less than 3");
        System.out.println("Enter best reward name:");
        bestRewardName = sc.nextLine().trim();
        if(bestRewardName.isEmpty()) throw new Exception("best reward name is empty!");
        return new GoodStudent(s.getFullName(),s.getDob(),s.getSex(),s.getUniversityName(),s.getGradeLevel(),s.getPhoneNumber(),
                gpa,bestRewardName);
    }

    public NormalStudent getANormalStudent() throws Exception {
        Student s = getGeneralStudent();
        int englishScore;
        int entryTestScore;
        String input ;
        System.out.println("Enter englishScore:");
        input = sc.nextLine().trim();
        englishScore = Integer.parseInt(input);
        if(englishScore<0) throw new Exception("english Score of a normal Student must not less than 0");
        System.out.println("Enter entry test Score:");
        entryTestScore = Integer.parseInt(sc.nextLine().trim());
        if(entryTestScore<0) throw new Exception("entry test Score of a normal Student must not less than 0!");
        return new NormalStudent(s.getFullName(),s.getDob(),s.getSex(),s.getUniversityName(),s.getGradeLevel(),s.getPhoneNumber(),
                englishScore,entryTestScore);
    }

    public void printByLine(String... lines){
        for (String line : lines) {
            System.out.println(line);
        }
    }
}

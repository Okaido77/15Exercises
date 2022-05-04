package validation;

import relatedException.studentModelException.InvalidDateOfBirthException;
import relatedException.studentModelException.InvalidGradeException;
import relatedException.studentModelException.InvalidNameException;
import relatedException.studentModelException.InvalidStartYearException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StudentValidation {
    public static Date toDateOfBirth(String birthday) throws InvalidDateOfBirthException {
        if (birthday.isEmpty()) throw new InvalidDateOfBirthException("birthday is empty");
        Date birthDay = null;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");

        try {
            birthDay = df.parse(birthday);
        } catch (Exception ex) {
            throw new InvalidDateOfBirthException("incorrect birthday format", ex);
        }
        return birthDay;
    }
    public static int toStartYear(String startYear) throws InvalidStartYearException {
        if (startYear.isEmpty()) throw new InvalidStartYearException("startYear is empty");
        int year ;
        Date date ;
        DateFormat df = new SimpleDateFormat("yyyy");
        LocalDate now = LocalDate.now();
        try {
            date = df.parse(startYear);
            LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            year = localDate.getYear();
        } catch (Exception ex) {
            throw new InvalidStartYearException("incorrect startYear format", ex);
        }
        if(year>now.getYear()) throw new InvalidStartYearException("startYear cant higher than current year");
        return year;
    }


    public static String toName(String name) throws InvalidNameException {
        if (name.isEmpty()) throw new InvalidNameException("name is empty");
        // chuẩn hóa tên
        String[] parts = name.trim().split("\\s+");
        StringBuffer nameS = new StringBuffer();

        nameS.append(parts[0].toUpperCase().charAt(0) + parts[0].substring(1).toLowerCase());

        for (int i = 1; i < parts.length; i++) {
            nameS.append(" ");
            nameS.append(parts[i].toUpperCase().charAt(0) + parts[i].substring(1).toLowerCase());
        }
        return nameS.toString();
    }
    public static double toGrade(String grade) throws InvalidGradeException {
        if (grade.isEmpty()) throw new InvalidGradeException("grade is empty");
        double gradeD;
        try {
            gradeD = Double.parseDouble(grade);
        } catch (Exception ex) {
            throw new InvalidGradeException("incorrect grade format");
        }
        if (gradeD < 0) throw new InvalidGradeException("grade must not be less than 0");
        return gradeD;
    }



    // test pattern
    public static void main(String[] args) throws InvalidStartYearException {
        System.out.println(StudentValidation.toStartYear("2021-12-30"));
    }
}

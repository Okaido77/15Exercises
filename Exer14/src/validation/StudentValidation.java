package validation;

import relatedException.studentException.InvalidDOBException;
import relatedException.studentException.InvalidFullNameException;
import relatedException.studentException.InvalidPhoneNumberException;
import relatedException.studentException.InvalidSexException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class StudentValidation {
    public static Date toBirthDay(String birthday) throws InvalidDOBException {
        if (birthday.isEmpty()) throw new InvalidDOBException("birthday is empty");
        Date birthDay = null;
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

        try {
            birthDay = df.parse(birthday);
        } catch (Exception ex) {
            throw new InvalidDOBException("incorrect birthday format", ex);
        }
        return birthDay;
    }
    public static String toPhone(String phoneNumber) throws InvalidPhoneNumberException {
        if (phoneNumber.isEmpty()) throw new InvalidPhoneNumberException("startYear is empty");
        phoneNumber = phoneNumber.replaceAll("\\s+","");
        if(phoneNumber.length()!=10) throw new InvalidPhoneNumberException("length of phone must equal 10");
        if(!" 090 098 091 031 035 038".contains(phoneNumber.substring(0,2)))
            throw new InvalidPhoneNumberException("phải bắt đầu bằng một trong các chuỗi số: 090, 098, 091, 031, 035 hoặc 038");

        return phoneNumber;
    }

    public static boolean toGender(String gender) throws InvalidSexException {
        boolean sex ;
        if(gender.equals("1")||gender.equals("2"))
            sex = "1".equals(gender);
        else throw new InvalidSexException("Invalid input(just 1 or 2 allowed)");
        return sex;
    }
    public static String toName(String name) throws InvalidFullNameException {
        if (name.isEmpty()) throw new InvalidFullNameException("name is empty");
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
}

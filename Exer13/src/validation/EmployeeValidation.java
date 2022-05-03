package validation;

import relatedException.BirthDayException;
import relatedException.EmailException;
import relatedException.FullNameException;
import relatedException.PhoneException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class EmployeeValidation {
    public static Date toBirthDay(String birthday) {
        if (birthday.isEmpty()) throw new BirthDayException("birthday is empty");
        Date birthDay = null;
        DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
        try {
            birthDay = df.parse(birthday);
        } catch (Exception ex) {
            throw new BirthDayException("incorrect birthday format", ex);
        }
        return birthDay;
    }

    public static String toEmail(String email) {
        if (email.isEmpty()) throw new EmailException("email is empty");
        String emailPattern = "^[a-zA-Z_]+@[a-zA-Z]+\\.[a-zA-Z]+((\\.[a-zA-Z]+)?)$";//(name@something.somthing or name@something.somthing.something)
        if (email.matches(emailPattern)) return email;
        throw new EmailException("incorrect email format");
    }

    public static String toName(String name) {
        if (name.isEmpty()) throw new FullNameException("name is empty");
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

    public static String toPhone(String phone) {
        if (phone.isEmpty()) throw new PhoneException("phone is empty");
        if (phone.length() != 10) throw new PhoneException("phone number must have 10 numbers");
        for(int i = 0 ;i<phone.length();i++){
            if(!Character.isDigit(phone.charAt(i))) throw new PhoneException("some character is not a digit");
        }
        return phone;
    }

    // test pattern
    public static void main(String[] args) {

        String mailts_1 = "dung@gmail.com.vn";
        System.out.println(EmployeeValidation.toEmail(mailts_1));
        ;
        String name = " tRan     dUNG";
        System.out.println(EmployeeValidation.toName(name));
    }
}

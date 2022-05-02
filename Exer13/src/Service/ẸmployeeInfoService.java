package Service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.DataFormatException;

public class ẸmployeeInfoService {
    //8
    public boolean isEmail(String email){
        return false;
    }
    public boolean isDate(String date){
        String format = "yyyy-MM-dd";
        DateFormat formatter = new SimpleDateFormat(format);
        try {
            Date d = formatter.parse(date);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
    public boolean isName(String name){
        if(name.isEmpty()) return false;

        return true;

    }
    public boolean isPhone(String phone){
        if(phone.length()!=0) return false;
        return true;
    }

}

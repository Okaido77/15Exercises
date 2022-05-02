package service;

import java.text.ParseException;
import java.util.Date;

public class KiemDinhThongSo {
    private String ID;
    private String hangSX;
    private Date namSX;
    private long giaBan;
    private String color;

    public static boolean isID(String id){
        if(id.isEmpty())
        return false;
        return true;
    }
    public static boolean isHangSX(String hangSX){
        if(hangSX.isEmpty())
            return false;
        return true;
    }
    public static boolean isGiaBan(String giaBan){
        if(giaBan.isEmpty()) return false;
        long g;
        try{
            g = Long.parseLong(giaBan);
        }catch (Exception ex){
            return false;
        }
        if(g<0) return false;
        return true;
    }

}

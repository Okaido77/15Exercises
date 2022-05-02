package model;

import java.util.Date;

public class XeMay extends PhuongTien{
    private int congSuat;

    public XeMay(String ID, String hangSX, Date namSX, long giaBan, String color, int congSuat) {
        super(ID, hangSX, namSX, giaBan, color);
        this.congSuat = congSuat;
    }

    @Override
    public void ShowInfo() {
        String print = "Xe máy" +
                "ID='" + super.getID() + '\'' +
                ", hangSX='" + super.getHangSX() + '\'' +
                ", namSX=" + super.getNamSX() +
                ", giaBan=" + super.getGiaBan() +
                ", color='" + super.getColor() + '\'' +
                ", congSuat='" + congSuat + '\''
                ;
        System.out.println(print);
    }
}

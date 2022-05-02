package model;

import java.util.Date;

public class XeTai extends PhuongTien{
    private int trongTai;

    public XeTai(String ID, String hangSX, Date namSX, long giaBan, String color, int trongTai) {
        super(ID, hangSX, namSX, giaBan, color);
        this.trongTai = trongTai;
    }

    @Override
    public void ShowInfo() {
        String print = "Xe tải" +
                "ID='" + super.getID() + '\'' +
                ", hangSX='" + super.getHangSX() + '\'' +
                ", namSX=" + super.getNamSX() +
                ", giaBan=" + super.getGiaBan() +
                ", color='" + super.getColor() + '\'' +
                ", trongTai='" + trongTai + '\''
                ;
        System.out.println(print);

    }
}

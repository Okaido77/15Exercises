package model;

import java.util.Date;

public class Oto extends PhuongTien{
    private int soChoNgoi;
    private String dongCo;

    public Oto(String ID, String hangSX, Date namSX, long giaBan, String color, int soChoNgoi, String dongCo) {
        super(ID, hangSX, namSX, giaBan, color);
        this.soChoNgoi = soChoNgoi;
        this.dongCo = dongCo;
    }

    @Override
    public void ShowInfo() {
        String print = "Xe Ô tô" +
                "ID='" + super.getID() + '\'' +
                ", hangSX='" + super.getHangSX() + '\'' +
                ", namSX=" + super.getNamSX() +
                ", giaBan=" + super.getGiaBan() +
                ", color='" + super.getColor() + '\'' +
                ", soChoNgoi='" + soChoNgoi + '\''+
                ", dongCo='" + dongCo + '\''
                ;
        System.out.println(print);

    }
}

package model;

import java.util.Date;
import java.util.Objects;

public abstract class PhuongTien {
    private String ID;
    private String hangSX;
    private Date namSX;
    private long giaBan;
    private String color;

    public PhuongTien(String ID, String hangSX, Date namSX, long giaBan, String color) {
        this.ID = ID;
        this.hangSX = hangSX;
        this.namSX = namSX;
        this.giaBan = giaBan;
        this.color = color;
    }


    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public Date getNamSX() {
        return namSX;
    }

    public void setNamSX(Date namSX) {
        this.namSX = namSX;
    }

    public long getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(long giaBan) {
        this.giaBan = giaBan;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PhuongTien)) return false;
        PhuongTien that = (PhuongTien) o;
        return getGiaBan() == that.getGiaBan() && getID().equals(that.getID()) && getHangSX().equals(that.getHangSX()) && getNamSX().equals(that.getNamSX()) && getColor().equals(that.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getHangSX(), getNamSX(), getGiaBan(), getColor());
    }
    public abstract void ShowInfo();
}

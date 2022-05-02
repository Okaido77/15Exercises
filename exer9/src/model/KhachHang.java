package model;

public class KhachHang {
    private String hoTenChuHo;
    private String soNha;
    private String maCongToDien;

    public KhachHang(String hoTenChuHo, String soNha, String maCongToDien) {
        this.hoTenChuHo = hoTenChuHo;
        this.soNha = soNha;
        this.maCongToDien = maCongToDien;
    }

    public String getHoTenChuHo() {
        return hoTenChuHo;
    }
    public KhachHang(KhachHang hoGiaDinh) {
        this.hoTenChuHo = hoGiaDinh.getHoTenChuHo();
        this.soNha = hoGiaDinh.getSoNha();
        this.maCongToDien = hoGiaDinh.getMaCongToDien();
    }
    public void setHoTenChuHo(String hoTenChuHo) {
        this.hoTenChuHo = hoTenChuHo;
    }

    public String getSoNha() {
        return soNha;
    }

    public void setSoNha(String soNha) {
        this.soNha = soNha;
    }

    public String getMaCongToDien() {
        return maCongToDien;
    }

    public void setMaCongToDien(String maCongToDien) {
        this.maCongToDien = maCongToDien;
    }
}

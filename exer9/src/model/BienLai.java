package model;

public class BienLai {
    private KhachHang hoGiaDinh;
    private int chiSoDienCu;
    private int chiSoDienMoi;
    private long soTienPhaiTra;

    public BienLai(KhachHang hoGiaDinh, int chiSoDienCu, int chiSoDienMoi, long soTienPhaiTra) {
        this.hoGiaDinh = hoGiaDinh;
        this.chiSoDienCu = chiSoDienCu;
        this.chiSoDienMoi = chiSoDienMoi;
        this.soTienPhaiTra = soTienPhaiTra;
    }

    public BienLai() {
    }

    public BienLai(BienLai bienlai) {
        this.hoGiaDinh = new KhachHang(bienlai.getHoGiaDinh());
        this.chiSoDienCu = bienlai.getChiSoDienCu();
        this.chiSoDienMoi = bienlai.getChiSoDienMoi();
        this.soTienPhaiTra = bienlai.getSoTienPhaiTra();
    }
    public KhachHang getHoGiaDinh() {
        return hoGiaDinh;
    }

    public void setHoGiaDinh(KhachHang hoGiaDinh) {
        this.hoGiaDinh = hoGiaDinh;
    }

    public int getChiSoDienCu() {
        return chiSoDienCu;
    }

    public void setChiSoDienCu(int chiSoDienCu) {
        this.chiSoDienCu = chiSoDienCu;
    }

    public int getChiSoDienMoi() {
        return chiSoDienMoi;
    }

    public void setChiSoDienMoi(int chiSoDienMoi) {
        this.chiSoDienMoi = chiSoDienMoi;
    }

    public long getSoTienPhaiTra() {
        return soTienPhaiTra;
    }

    public void setSoTienPhaiTra(long soTienPhaiTra) {
        this.soTienPhaiTra = soTienPhaiTra;
    }


}

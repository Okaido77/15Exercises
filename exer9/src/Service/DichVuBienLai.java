package Service;

import model.BienLai;
import model.KhachHang;

import java.util.List;
import java.util.Optional;

public class DichVuBienLai {
    List<BienLai> danhSachBienLai;

    public DichVuBienLai(List<BienLai> danhSachBienLai) {
        this.danhSachBienLai = danhSachBienLai;
    }

    public List<BienLai> getDanhSachBienLai() {
        return danhSachBienLai;
    }

    public void setDanhSachBienLai(List<BienLai> danhSachBienLai) {
        this.danhSachBienLai = danhSachBienLai;
    }

    public boolean themBienLai(BienLai bienLai) {
        Optional<BienLai> b = danhSachBienLai.stream().filter(bi -> bi.getHoGiaDinh().equals(bienLai.getHoGiaDinh())).findFirst();
        if (b.isPresent())
            return false;
        else
            danhSachBienLai.add(bienLai);
        return true;
    }

    public boolean xoaBienLai(BienLai bienLai) {
        return danhSachBienLai.remove(bienLai);
    }

    // không có biên lai cũ thì add mới vô
    public boolean suaBienLai(BienLai bienLai) {
        Optional<BienLai> b = danhSachBienLai.stream().filter(bi -> bi.getHoGiaDinh().equals(bienLai.getHoGiaDinh())).findFirst();
        BienLai bienLaiCu;
        if (b.isPresent()) {
            bienLaiCu = b.get();
            bienLaiCu.setHoGiaDinh(new KhachHang(bienLai.getHoGiaDinh()));
            bienLaiCu.setChiSoDienCu(bienLai.getChiSoDienCu());
            bienLaiCu.setChiSoDienMoi(bienLai.getChiSoDienMoi());
            bienLaiCu.setSoTienPhaiTra(bienLai.getSoTienPhaiTra());
        } else {
            danhSachBienLai.add(bienLai);
        }
        return false;
    }

    public void tinhTienPhaiTra(BienLai bienlai) {
        bienlai.setSoTienPhaiTra((bienlai.getChiSoDienMoi() - bienlai.getChiSoDienCu()) * 5);
    }
}

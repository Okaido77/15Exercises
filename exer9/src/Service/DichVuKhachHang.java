package Service;

import model.KhachHang;

import java.util.List;
import java.util.Optional;

public class DichVuKhachHang {
    List<KhachHang> danhSachHoGiaDinh;

    public DichVuKhachHang(List<KhachHang> danhSachHoGiaDinh) {
        this.danhSachHoGiaDinh = danhSachHoGiaDinh;
    }

    public boolean themHoGiaDinh(KhachHang khachHang) {
        Optional<KhachHang> record = danhSachHoGiaDinh.stream().filter(k -> k.equals(khachHang)).findFirst();
        if (record.isPresent())
            return false;
        else {
            danhSachHoGiaDinh.add(record.get());
            return true;
        }

    }

    public boolean suaHoGiaDinh(KhachHang khachHang) {
        Optional<KhachHang> record = danhSachHoGiaDinh.stream().filter(k -> k.equals(khachHang)).findFirst();
        if (record.isPresent()) {
            danhSachHoGiaDinh.add(record.get());
            return true;
        } else {
            KhachHang k = record.get();
            k.setHoTenChuHo(khachHang.getHoTenChuHo());
            k.setSoNha(khachHang.getSoNha());
            k.setMaCongToDien(khachHang.getMaCongToDien());
            return true;
        }
    }

    public boolean xoaHoGiaDinh(KhachHang khachHang) {
        return danhSachHoGiaDinh.remove(khachHang);
    }
}

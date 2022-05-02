package service;

import model.PhuongTien;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class QLPTGT {
    List<PhuongTien> danhSachPhuongTien;

    public QLPTGT(List<PhuongTien> danhSachPhuongTien) {
        this.danhSachPhuongTien = danhSachPhuongTien;
    }

    public boolean themPhuongTien(PhuongTien pt) {
        Optional<PhuongTien> pr = danhSachPhuongTien.stream().filter(p -> p.equals(pt)).findFirst();
        if (pr.isPresent())
            return false;
        return danhSachPhuongTien.add(pt);
    }

    public boolean xoaPhuongTien(String id) {
        Optional<PhuongTien> pr = danhSachPhuongTien.stream().filter(p -> p.getID().equals(id)).findFirst();
        if (pr.isPresent())
            return danhSachPhuongTien.remove(pr.get());
        return false;
    }
    public List<PhuongTien> timPhuongTien(String hangSX,String color){
        List<PhuongTien> ptl = danhSachPhuongTien.stream().filter(p -> p.getHangSX().equals(hangSX)
                &&p.getColor().equals(color)).collect(Collectors.toList());
        return ptl;
    }

}

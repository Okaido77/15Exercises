package service;

import model.Oto;
import model.PhuongTien;
import model.XeMay;
import model.XeTai;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class FeatureService {
    Scanner sc = new Scanner(System.in);

    public FeatureService(List<PhuongTien> ptl) {
        qlpt = new QLPTGT(ptl);
    }

    QLPTGT qlpt;

    private PhuongTien layThongTinChung() throws Exception {
        String ID;
        String hangSX;
        Date namSX;
        long giaBan;
        String color;
        String input;
        System.out.println("Nhập ID:");
        ID = sc.nextLine();
        System.out.println("Nhập hãng sản xuất:");
        hangSX = sc.nextLine().trim();
        System.out.println("Nhập năm sản xuất(yyyy-mm-dd):");
        input = sc.nextLine().trim();
        try {
            DateFormat d = new SimpleDateFormat("yyyy-mm-dd");
            namSX = d.parse(input);
        } catch (Exception e) {
            throw new Exception("Ngày tháng nhập vào không hợp lệ");
        }
        System.out.println("Nhập giá bán:");
        input = sc.nextLine().trim();
        try {

            giaBan = Long.parseLong(input);
        } catch (Exception e) {
            throw new Exception("Giá bán nhập vào không hợp lê");
        }
        System.out.println("Nhập màu :");
        color = sc.nextLine().trim();
        return new PhuongTien(ID, hangSX, namSX, giaBan, color) {
            @Override
            public void ShowInfo() {

            }
        };

    }

    public void layThongTinXeMay() throws Exception {
        int congSuat;
        String input;
        PhuongTien pt = layThongTinChung();
        System.out.println("Nhập công suất:");
        input = sc.nextLine().trim();
        try {
            congSuat = Integer.parseInt(input);
        } catch (Exception e) {
            throw new Exception("công suất nhập vào không chính xác");
        }
        System.out.println("Thêm Thông tin của xe máy" + pt.getID() + "vào thành công");
        qlpt.themPhuongTien(new XeMay(pt.getID(), pt.getHangSX(), pt.getNamSX(), pt.getGiaBan(), pt.getColor(), congSuat));

    }

    public void layThongTinXeTai() throws Exception {
        int trongTai;
        String input;
        PhuongTien pt = layThongTinChung();
        System.out.println("nhập trọng tải của xe");
        input = sc.nextLine().trim();
        try {
            trongTai = Integer.parseInt(input);
        } catch (Exception e) {
            throw new Exception("Thông tin trọng tải nhập vào không chính xác");
        }
        System.out.println("Thêm Thông tin của xe tải" + pt.getID() + "vào thành công");
        qlpt.themPhuongTien(new XeTai(pt.getID(), pt.getHangSX(), pt.getNamSX(), pt.getGiaBan(), pt.getColor(), trongTai));


    }

    public void layThongTinOto() throws Exception {
        int soChoNgoi;
        String dongCo;
        String input;
        PhuongTien pt = layThongTinChung();
        System.out.println("nhập số chỗ ngồi của ô tô");
        input = sc.nextLine().trim();
        try {
            soChoNgoi = Integer.parseInt(input);
        } catch (Exception e) {
            throw new Exception("Thông tin số chỗ ngồi nhập vào không chính xác");
        }
        System.out.println("Nhập động cơ của xe ô tô:");
        dongCo = sc.nextLine().trim();
        System.out.println("Thêm Thông tin của xe tải" + pt.getID() + "vào thành công");
        qlpt.themPhuongTien(new Oto(pt.getID(), pt.getHangSX(), pt.getNamSX(), pt.getGiaBan(), pt.getColor(), soChoNgoi, dongCo));
    }

    public void timKiemThongTin() throws Exception {
        System.out.println("Nhập Tên Hãng Sản Xuất:");
        String hangSx = sc.nextLine().trim();
//        if(!KiemDinhThongSo.isHangSX(hangSx)) throw new Exception();
        System.out.println("Nhập Tên Màu:");
        String color = sc.nextLine().trim();
        List<PhuongTien> ptl = qlpt.timPhuongTien(hangSx, color);
        if (ptl.size() > 0) {
            System.out.println("Danh sách các phương tiện phù hợp:");
            ptl.forEach(
                    p -> p.ShowInfo()
            );
        } else {
            System.out.println("Không có phương tiện phù hợp");
        }
    }

    public void XoaThongTin() {
        System.out.println("Id của phương tiện:");
        String id = sc.nextLine();
        boolean b = qlpt.xoaPhuongTien(id);
        if (b) System.out.println("đã xóa phương tiện thành công");
        else System.out.println("Phương tiện không tồn tại hoặc có lỗi xảy ra khi xóa");
    }


}

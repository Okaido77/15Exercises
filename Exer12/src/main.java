import service.FeatureService;

import java.util.LinkedList;
import java.util.Scanner;

public class main {
    static void viewAllLines(String... lines) {
        for (String line : lines)
            System.out.println(line);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FeatureService featureService = new FeatureService(new LinkedList<>());
        while (true) {
            viewAllLines("Enter your choice: ",
                    "1.Them phuong tien",
                    "2.Xoa phuong tien",
                    "3.Tim phuong tien",
                    "4.Thoat chuong trinh"
            );
            try {
                String choice = sc.nextLine().trim();
                String choice2;
                switch (choice) {
                    case "1":
                        viewAllLines("Chọn loại xe :",
                                "1.Xe máy",
                                "2.Xe tải",
                                "3.Ô tô");
                        choice2 = sc.nextLine().trim();
                        switch (choice2) {
                            case "1":
                                featureService.layThongTinXeMay();
                                break;
                            case "2":
                                featureService.layThongTinXeTai();
                                break;
                            case "3":
                                featureService.layThongTinOto();
                                break;
                            default:
                                throw new Exception("không có lựa chọn này");
                        }
                        break;
                    case "2":
                        featureService.XoaThongTin();
                        break;
                    case "3":
                        featureService.timKiemThongTin();
                        break;
                    case "4":
                        System.out.println("Tạm biệt");
                        return;
                    default:
                        throw new Exception("không có lựa chọn này");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}

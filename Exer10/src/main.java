import model.VanBan;

public class main {
    public static void main(String[] args) {
        VanBan v = new VanBan(" đây #là 1# Văn bản$ bình# thường VqVqVVqVVV");
        //
        //phương thức đếm số từ của văn bản.
        System.out.println("số từ của văn bản:");
        System.out.println(v.soTuCuaVanBan());
//        đếm số lượng ký tự
        System.out.println("Đếm số lượng kí tự:");
        System.out.println("số lượng ký tự v:");
        System.out.println(v.soLuongKiTuIgnoreCase('v'));
        System.out.println("số lượng ký tự Q:");
        System.out.println(v.soLuongKiTuIgnoreCase('Q'));
        System.out.println("số lượng ký tự #:");
        System.out.println(v.soLuongKiTuIgnoreCase('#'));
        // chuan hoa van ban
        System.out.println("chuẩn hóa văn bản");
        System.out.println("trước khi chuẩn hóa:");
        VanBan v2 = new VanBan(" a    c  d  đ c               e ");
        System.out.println("sau khi chuẩn hóa:");
        System.out.println(v2.chuanHoa());

    }
}

import model.QuanLySoPhuc;
import model.SoPhuc;

public class main {
    public static void main(String[] args) {
        QuanLySoPhuc qlsp = new QuanLySoPhuc();
        // tao so phuc
        SoPhuc sp;
        try {
            sp = qlsp.themSoPhuc();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
            return;
        }
        // hien thi so phuc
        System.out.println("hien thi so phuc:");
        sp.hienThiSoPhuc();

        //cong 2 so phuc
        System.out.println("cong 2 so phuc:");
        sp = qlsp.cong2SoPhuc(sp,sp);
        sp.hienThiSoPhuc();
        //nhan 2 so phuc
        System.out.println("nhan 2 so phuc:");
        sp = qlsp.nhan2SoPhuc(sp,sp);
        sp.hienThiSoPhuc();

    }
}

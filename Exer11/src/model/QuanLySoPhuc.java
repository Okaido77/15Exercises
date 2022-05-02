package model;

import java.util.Scanner;

public class QuanLySoPhuc {
    Scanner sc = new Scanner(System.in);
    // tao so phuc
    public SoPhuc themSoPhuc() throws Exception {
        double phanThuc;
        double phanAo;
        System.out.println("Phan thuc:");
        String input = sc.nextLine().trim();
        if(input.isEmpty()) throw new Exception("phan thuc bi thiếu");
        try{
            phanThuc = Double.parseDouble(input);
        }catch (NumberFormatException ex){
            throw new Exception("phan thuc bi sai format ");

        }

        System.out.println("Phan Ao:");
        input = sc.nextLine().trim();
        if(input.isEmpty()) throw new Exception("phan ao bi thiếu");
        try{
            phanAo = Double.parseDouble(input);
        }catch (NumberFormatException ex){
            throw new Exception("phan ao bi sai format ");

        }
        return new SoPhuc(phanThuc,phanAo);
    }
    // hien thi so phuc

    // cong 2 so phuc
    public SoPhuc cong2SoPhuc(SoPhuc s1, SoPhuc s2){
        return new SoPhuc((s1.getPhanThuc()+s2.getPhanThuc()),(s1.getPhanAo()+s2.getPhanAo()));
    }
    // nhan 2 so phuc
    public SoPhuc nhan2SoPhuc(SoPhuc s1, SoPhuc s2){
        return new SoPhuc(s1.getPhanThuc()*s2.getPhanThuc()-s1.getPhanAo()*s2.getPhanAo(),
                s1.getPhanThuc()*s2.getPhanThuc()+s1.getPhanAo()*s2.getPhanAo());
    }
}

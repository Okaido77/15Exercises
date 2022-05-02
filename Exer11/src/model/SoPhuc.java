package model;

public class SoPhuc {
    private double phanThuc;
    private double phanAo;

    public double getPhanThuc() {
        return phanThuc;
    }

    public void setPhanThuc(double phanThuc) {
        this.phanThuc = phanThuc;
    }

    public double getPhanAo() {
        return phanAo;
    }

    public void setPhanAo(double phanAo) {
        this.phanAo = phanAo;
    }

    public SoPhuc(double phanThuc, double phanAo) {
        this.phanThuc = phanThuc;
        this.phanAo = phanAo;
    }

    public void hienThiSoPhuc() {
        String output = "";
        System.out.println("So phuc la:");
        if (phanThuc != 0)
            output+=phanThuc;
        if (phanThuc != 0&&phanAo!=0)
            output+=" + ";
        if (phanAo != 0)
           output+=phanAo+"i";
        System.out.println(output);
    }
}

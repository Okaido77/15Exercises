package model;

import java.util.Locale;

public class VanBan {
    String st;

    public VanBan(String st) {
        this.st = st;
    }

    public VanBan() {
    }

    public int soTuCuaVanBan() {
        String[] s = st.split("\\s+");
        return s.length;
    }

    public int soLuongKiTuIgnoreCase(char c) {
        int count = 0;
        String temp;
        boolean isChar = Character.isAlphabetic(c);
        if (isChar) {
            if (c > 90)
                temp = st.toLowerCase();
            else temp = st.toUpperCase();
        }else{
            temp = st;
        }
        for (int i = 0; i < temp.length(); i++) {
            if (temp.charAt(i) == c)
                count++;
        }
        return count;
    }
    public String chuanHoa(){
        st = st.trim().replaceAll("\\s+"," ");
        return st;
    }
}

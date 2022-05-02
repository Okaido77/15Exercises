package model;

public class Engineer extends Officer {
    private String major;

    public Engineer(String name, int age, boolean gender, String address,String major) {
        super(name, age, gender, address);
        this.major = major;
    }

    public Engineer() {
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", major='" + major + '\'';

    }
}

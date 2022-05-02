package model;

public class Staff extends Officer{

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Staff(String name, int age, boolean gender, String address, int level) {
        super(name, age, gender, address);
        this.level = level;
    }

    public Staff() {
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", level='" + level+ '\'';

    }
}

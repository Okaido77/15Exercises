package model;

public class Teacher extends Person{
    private long basicSalary;
    private long bonusSalary;
    private long penaltySalary;

    public Teacher(String id, String name, String homeTown) {
        super(id, name, homeTown);
    }

    public Teacher(String id, String name, String homeTown, long basicSalary, long bonusSalary, long penaltySalary) {
        super(id, name, homeTown);
        this.basicSalary = basicSalary;
        this.bonusSalary = bonusSalary;
        this.penaltySalary = penaltySalary;
    }

    public long getBasicSalary() {
        return basicSalary;
    }

    public void setBasicSalary(long basicSalary) {
        this.basicSalary = basicSalary;
    }

    public long getBonusSalary() {
        return bonusSalary;
    }

    public void setBonusSalary(long bonusSalary) {
        this.bonusSalary = bonusSalary;
    }

    public long getPenaltySalary() {
        return penaltySalary;
    }

    public void setPenaltySalary(long penaltySalary) {
        this.penaltySalary = penaltySalary;
    }
}

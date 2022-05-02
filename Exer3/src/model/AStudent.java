package model;

public class AStudent extends Candidate{
    private float mathGrade;
    private float physicsGrade;
    private float chemistryGrade;

    public AStudent(String id, String name, String address, int priority, float mathGrade, float physicsGrade, float chemistryGrade) {
        super(id, name, address, priority);
        this.mathGrade = mathGrade;
        this.physicsGrade = physicsGrade;
        this.chemistryGrade = chemistryGrade;
    }

    public AStudent() {
    }

    @Override
    public String toString() {
        return super.toString() +
                ", mathGrade=" + mathGrade +
                ", physicsGrade=" + physicsGrade +
                ", chemistryGrade=" + chemistryGrade
                ;
    }
}

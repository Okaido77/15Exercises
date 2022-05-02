package model;

public class BStudent extends Candidate{
    private float mathGrade;
    private float biologyGrade;
    private float chemistryGrade;

    public float getMathGrade() {
        return mathGrade;
    }

    public void setMathGrade(float mathGrade) {
        this.mathGrade = mathGrade;
    }

    public float getBiologyGrade() {
        return biologyGrade;
    }

    public void setBiologyGrade(float biologyGrade) {
        this.biologyGrade = biologyGrade;
    }

    public float getChemistryGrade() {
        return chemistryGrade;
    }

    public void setChemistryGrade(float chemistryGrade) {
        this.chemistryGrade = chemistryGrade;
    }

    public BStudent(String id, String name, String address, int priority, float mathGrade, float biologyGrade, float chemistryGrade) {
        super(id, name, address, priority);
        this.mathGrade = mathGrade;
        this.biologyGrade = biologyGrade;
        this.chemistryGrade = chemistryGrade;
    }

    @Override
    public String toString() {
        return super.toString() +
                "mathGrade=" + mathGrade +
                ", biologyGrade=" + biologyGrade +
                ", chemistryGrade=" + chemistryGrade ;
    }
}

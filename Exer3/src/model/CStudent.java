package model;

public class CStudent extends Candidate{
    private float literatureGrade;
    private float historyGrade;
    private float geographyGrade;

    public CStudent(String id, String name, String address, int priority, float literatureGrade, float historyGrade, float geographyGrade) {
        super(id, name, address, priority);
        this.literatureGrade = literatureGrade;
        this.historyGrade = historyGrade;
        this.geographyGrade = geographyGrade;
    }

    public float getLiteratureGrade() {
        return literatureGrade;
    }

    public void setLiteratureGrade(float literatureGrade) {
        this.literatureGrade = literatureGrade;
    }

    public float getHistoryGrade() {
        return historyGrade;
    }

    public void setHistoryGrade(float historyGrade) {
        this.historyGrade = historyGrade;
    }

    public float getGeographyGrade() {
        return geographyGrade;
    }

    public void setGeographyGrade(float geographyGrade) {
        this.geographyGrade = geographyGrade;
    }

    @Override
    public String toString() {
        return super.toString() +
                "literatureGrade=" + literatureGrade +
                ", historyGrade=" + historyGrade +
                ", geographyGrade=" + geographyGrade
                ;
    }
}

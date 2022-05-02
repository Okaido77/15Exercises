package model;

public class Newspaper extends Document {
    private int releaseNumber;
    private int releaseMonth;

    public Newspaper(String id, String publisher, int numberOfRelease, int releaseNumber, int releaseMonth) {
        super(id, publisher, numberOfRelease);
        this.releaseNumber = releaseNumber;
        this.releaseMonth = releaseMonth;
    }

    public Newspaper() {
    }

    public int getReleaseNumber() {
        return releaseNumber;
    }

    public void setReleaseNumber(int releaseNumber) {
        this.releaseNumber = releaseNumber;
    }

    public int getReleaseMonth() {
        return releaseMonth;
    }

    public void setReleaseMonth(int releaseMonth) {
        this.releaseMonth = releaseMonth;
    }

    @Override
    public String toString() {
        return  super.toString()+
                ", releaseNumber=" + releaseNumber +
                ", releaseMonth=" + releaseMonth;
    }
}

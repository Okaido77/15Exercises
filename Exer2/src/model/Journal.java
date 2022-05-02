package model;

import java.time.LocalDate;

public class Journal extends Document {
    private LocalDate releaseDate;

    public Journal(String code, String publisher, int numberOfRelease, LocalDate releaseDate) {
        super(code, publisher, numberOfRelease);
        this.releaseDate = releaseDate;
    }
    public Journal(){

    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", releaseDate=" + releaseDate
                ;
    }
}

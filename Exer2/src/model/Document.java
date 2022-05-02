package model;

import java.util.Objects;

public class Document {
    private String Code;
    private String publisher;
    private int numberOfRelease;


    public Document(String Code, String publisher, int numberOfRelease) {
        this.Code = Code;
        this.publisher = publisher;
        this.numberOfRelease = numberOfRelease;

    }

    public Document() {
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getNumberOfRelease() {
        return numberOfRelease;
    }

    public void setNumberOfRelease(int numberOfRelease) {
        this.numberOfRelease = numberOfRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Document)) return false;
        Document document = (Document) o;
        return getCode() == document.getCode() && getNumberOfRelease() == document.getNumberOfRelease() && getPublisher().equals(document.getPublisher());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getPublisher(), getNumberOfRelease());
    }

    @Override
    public String toString() {
        return  "Type of document:" + this.getClass().getSimpleName()+"\n" +
                "Code='" + Code + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numberOfRelease=" + numberOfRelease
                ;
    }
}

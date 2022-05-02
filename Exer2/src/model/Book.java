package model;

public class Book extends Document{
    private String authorName;
    private int numberOfPage;

    public Book(String Code, String publisher, int numberOfRelease, String authorName, int numberOfPage) {
        super(Code, publisher, numberOfRelease);
        this.authorName = authorName;
        this.numberOfPage = numberOfPage;
    }

    public Book() {
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public int getNumberOfPage() {
        return numberOfPage;
    }

    public void setNumberOfPage(int numberOfPage) {
        this.numberOfPage = numberOfPage;
    }

    @Override
    public String toString() {
        return  super.toString() +
                ", authorName='" + authorName + '\'' +
                ", numberOfPage='" + numberOfPage + '\''
                ;
    }
}

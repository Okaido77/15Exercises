package model;

import java.util.Date;
import java.util.Objects;

public class Card {
    private String borrowCode;
    private Date borrowDate;
    private Date returnDate;
    private String bookNumber;
    private Student student;

    public Card(String borrowCode, Date borrowDate, Date returnDate, String bookNumber) {
        this.borrowCode = borrowCode;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.bookNumber = bookNumber;
    }

    public Card(String borrowCode, Date borrowDate, Date returnDate, String bookNumber, Student student) {
        this.borrowCode = borrowCode;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.bookNumber = bookNumber;
        this.student = student;
    }

    public String getBorrowCode() {
        return borrowCode;
    }

    public void setBorrowCode(String borrowCode) {
        this.borrowCode = borrowCode;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public String getBookNumber() {
        return bookNumber;
    }

    public void setBookNumber(String bookNumber) {
        this.bookNumber = bookNumber;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return Objects.equals(getBorrowDate(), card.getBorrowDate()) && Objects.equals(getReturnDate(), card.getReturnDate()) && Objects.equals(getBookNumber(), card.getBookNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBorrowDate(), getReturnDate(), getBookNumber());
    }

    @Override
    public String toString() {
        return "Card{" +
                "borrowCode='" + borrowCode + '\'' +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", bookNumber='" + bookNumber + '\'' +
                ", student=" + student +
                '}';
    }
}

package model;

import java.util.List;
import java.util.Objects;

public class Family {
    private int numberOfMember;
    private List<Person> MemberList;
    private String apartmentNumber;

    public Family(int numberOfMember, List<Person> memberList, String apartmentNumber) {
        this.numberOfMember = numberOfMember;
        MemberList = memberList;
        this.apartmentNumber = apartmentNumber;
    }

    public int getNumberOfMember() {
        return numberOfMember;
    }

    public void setNumberOfMember(int numberOfMember) {
        this.numberOfMember = numberOfMember;
    }

    public List<Person> getMemberList() {
        return MemberList;
    }

    public void setMemberList(List<Person> memberList) {
        MemberList = memberList;
    }

    public String getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(String apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    @Override
    public String toString() {
        return "Family{" +
                "numberOfMember=" + numberOfMember +
                ", MemberList=" + MemberList +
                ", apartmentNumber='" + apartmentNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Family)) return false;
        Family family = (Family) o;
        return getNumberOfMember() == family.getNumberOfMember() && getMemberList().equals(family.getMemberList()) && getApartmentNumber().equals(family.getApartmentNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumberOfMember(), getMemberList(), getApartmentNumber());
    }
}

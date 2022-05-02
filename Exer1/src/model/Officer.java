package model;

import java.util.Objects;

public class Officer {
    private String name;
    private int age;
    private boolean gender;
    private String address;

    public Officer() {
    }

    public Officer(String name, int age, boolean gender, String address) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean getGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Officer)) return false;
        Officer officer = (Officer) o;
        return getAge() == officer.getAge() && getGender() == officer.getGender() && getName().equals(officer.getName()) && getAddress().equals(officer.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getGender(), getAddress());
    }

    @Override
    public String toString() {
        return "Type of Officer: "+this.getClass().getSimpleName()+"\n"+
                "name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + (gender==true?"'Male'":"'Female'") +
                ", address='" + address + '\''
                ;
    }
}

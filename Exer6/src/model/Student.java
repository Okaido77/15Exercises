package model;

import java.util.Objects;

public class Student {
    private String name;
    private int age;
    private String homeTown;

    public void showInformation(){

    }

    public Student(String name, int age, String homeTown) {
        this.name = name;
        this.age = age;
        this.homeTown = homeTown;
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

    public String getHomeTown() {
        return homeTown;
    }

    public void setHomeTown(String homeTown) {
        this.homeTown = homeTown;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return getAge() == student.getAge() && getName().equals(student.getName()) && getHomeTown().equals(student.getHomeTown());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getHomeTown());
    }
}

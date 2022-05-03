package model;

import java.util.Objects;

public class Booker {
    private String name;
    private int age;
    private String cccd;
    private Room room;
    public Booker(String name, int age, String cccd) {
        this.name = name;
        this.age = age;
        this.cccd = cccd;
    }

    public Booker(String name, int age, String cccd, Room room) {
        this.name = name;
        this.age = age;
        this.cccd = cccd;
        this.room = room;
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

    public String getCccd() {
        return cccd;
    }

    public void setCccd(String cccd) {
        this.cccd = cccd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booker)) return false;
        Booker booker = (Booker) o;
        return getAge() == booker.getAge() && getName().equals(booker.getName()) && getCccd().equals(booker.getCccd());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAge(), getCccd());
    }
}

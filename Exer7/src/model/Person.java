package model;

import java.util.Objects;

public class Person {
    private String id;
    private String name;
    private String homeTown;

    public Person(String id, String name, String homeTown) {
        this.id = id;
        this.name = name;
        this.homeTown = homeTown;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return getId().equals(person.getId()) && getName().equals(person.getName()) && getHomeTown().equals(person.getHomeTown());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getHomeTown());
    }
}

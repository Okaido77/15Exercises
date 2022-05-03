package model;

public class Student {
    private String Name;
    private int age;
    private String className;

    @Override
    public String toString() {
        return "Student{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", className='" + className + '\'' +
                '}';
    }

    public Student(String name, int age, String className) {
        Name = name;
        this.age = age;
        this.className = className;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}

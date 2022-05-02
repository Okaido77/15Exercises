package model;

public class Worker extends Officer{
    private String job;

    public Worker() {
    }

    public Worker(String name, int age, boolean gender, String address, String job) {
        super(name, age, gender, address);
        this.job = job;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }
    @Override
    public String toString() {
        return  super.toString() +
                ", job='" + job+ '\'';

    }
}

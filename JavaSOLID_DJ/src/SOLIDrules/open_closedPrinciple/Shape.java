package SOLIDrules.open_closedPrinciple;

public abstract class Shape {
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Shape(String type) {
        this.type = type;
    }
    public abstract double getArea();
}


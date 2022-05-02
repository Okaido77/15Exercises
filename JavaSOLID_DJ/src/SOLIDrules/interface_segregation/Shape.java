package SOLIDrules.interface_segregation;

public abstract class Shape implements ShapeInterface{
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
}


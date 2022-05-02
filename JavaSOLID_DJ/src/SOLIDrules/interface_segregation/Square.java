package SOLIDrules.interface_segregation;

public class Square extends Shape {
    private float length;

    public Square(float length) {
        super("square");
        this.length = length;
    }

    public float getLength() {
        return length;
    }

    public void setLength(float length) {
        this.length = length;
    }

    @Override
    public double getArea() {
        return Math.pow(length, 2);
    }
}


package SOLIDrules.interface_segregation;

public class Circle extends Shape {
    private float radius;

    public Circle(float radius) {
        super("circle");
        this.radius = radius;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}

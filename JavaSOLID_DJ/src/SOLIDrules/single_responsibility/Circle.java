package SOLIDrules.single_responsibility;

public class Circle extends Shape{
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

}

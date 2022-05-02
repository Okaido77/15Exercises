package SOLIDrules.interface_segregation;


public class AreaCalculator {

    public static double calculate(Shape[] shape){
        double total = 0;
        for (Shape s : shape) {
            total+= s.getArea();
        }
        return total;
    }

    public static void main(String[] args) {

        Shape square = new Square(2);
        Shape circle = new Circle(2);

        Shape[] shape = {square,circle};
        System.out.println("total area is :" + AreaCalculator.calculate(shape));

    }
}

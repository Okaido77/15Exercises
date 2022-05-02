package SOLIDrules.single_responsibility;

public class AreaCalculator {

    public static double calculate(Shape[] shape){
        double total = 0;
        for (Shape s : shape) {
            if (s.getType().equals("square"))
                total+= Math.pow(((Square) s).getLength(), 2);

            if (s.getType().equals("circle"))
                total+= Math.PI * Math.pow(((Circle) s).getRadius(), 2);
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

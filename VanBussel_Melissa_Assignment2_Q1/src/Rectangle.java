public class Rectangle extends GeometricObject {
    // Fields
    private double side1;
    private double side2;

    // Constructors
    public Rectangle() {
        side1 = 1.0;
        side2 = 1.0;
    }

    public Rectangle(double side1, double side2) {
        this.side1 = side1;
        this.side2 = side2;
    }

    // Methods
    public double getArea() { return side1 * side2; }

    public double getPerimeter() { return 2 * side1 + 2 * side2; }
}

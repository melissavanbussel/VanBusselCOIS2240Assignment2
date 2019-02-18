import java.lang.Math;
public class Circle extends GeometricObject {
    // Fields
    private double x;
    private double y;
    private double radius;

    // Constructors
    public Circle() {
        this.x = 0;
        this.y = 0;
        this.radius = 1;
    }

    public Circle(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    // Getters for fields
    public double x() { return x; }

    public double y() { return y; }

    public double radius() { return radius; }

    // Methods
    public double getArea() { return Math.PI * radius * radius; }

    public double getPerimeter() { return 2 * Math.PI * radius; }
}

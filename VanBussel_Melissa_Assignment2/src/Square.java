public class Square extends Rectangle {
    // Fields
    private double side;

    // Constructors
    public Square(double side) {
        super(side, side);
        this.side = side;
    }

    // Methods
    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return 4 * side;
    }
}

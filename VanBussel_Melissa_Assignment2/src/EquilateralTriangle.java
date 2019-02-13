public class EquilateralTriangle extends Triangle {
    // Fields
    private double side;

    // Constructor
    public EquilateralTriangle(double side) {
        super(side, side, side);
        this.side = side;
    }
}

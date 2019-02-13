import java.lang.Class;
class Test {
    public static void main(String[] args) {
        GeometricObject gObjectArray[] = new GeometricObject[5];
        gObjectArray[0] = new Circle(5, 5, 5);
        gObjectArray[1] = new EquilateralTriangle(5);
        gObjectArray[2] = new Triangle(5, 5, 5);
        gObjectArray[3] = new Rectangle(5, 5);
        gObjectArray[4] = new Square(5);
        for (int i = 0; i < 5; i++) {
            printAreaAndPerimeter(gObjectArray[i]);
        }

    }
    private static void printAreaAndPerimeter(GeometricObject gObject) {
        System.out.println("The geometric object " + gObject
                + "\ntype of object: " + gObject.getClass()
                + "\narea: " + gObject.getArea()
                + "\nperimeter: " + gObject.getPerimeter() + "\n");
    }
}

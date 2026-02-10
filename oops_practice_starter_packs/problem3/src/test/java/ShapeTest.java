public class ShapeTest {
    public static void main(String[] args) {
        // Test case 1: Create Circle and verify area and perimeter calculations
        Circle circle = new Circle(5.0);
        double expectedCircleArea = Math.PI * 25; // π * r² = π * 25
        double expectedCirclePerimeter = 2 * Math.PI * 5; // 2 * π * r
        assert Math.abs(circle.calculateArea() - expectedCircleArea) < 0.001 : "Circle area calculation is incorrect";
        assert Math.abs(circle.calculatePerimeter() - expectedCirclePerimeter) < 0.001 : "Circle perimeter calculation is incorrect";
        System.out.println("Test 1 passed: Circle area and perimeter");

        // Test case 2: Create Rectangle and verify area and perimeter calculations
        Rectangle rectangle = new Rectangle(4.0, 6.0);
        assert rectangle.calculateArea() == 24.0 : "Rectangle area should be length * width";
        assert rectangle.calculatePerimeter() == 20.0 : "Rectangle perimeter should be 2 * (length + width)";
        System.out.println("Test 2 passed: Rectangle area and perimeter");

        // Test case 3: Create Triangle and verify area and perimeter calculations
        // Using a 3-4-5 right triangle: area should be (3*4)/2 = 6, perimeter should be 12
        Triangle triangle = new Triangle(3.0, 4.0, 5.0);
        assert Math.abs(triangle.calculateArea() - 6.0) < 0.001 : "Triangle area calculation is incorrect";
        assert triangle.calculatePerimeter() == 12.0 : "Triangle perimeter should be sum of all sides";
        System.out.println("Test 3 passed: Triangle area and perimeter");

        // Test case 4: Polymorphism - store shapes in Shape array and call methods
        Shape[] shapes = {new Circle(2.0), new Rectangle(3.0, 4.0), new Triangle(3.0, 4.0, 5.0)};
        for (Shape shape : shapes) {
            double area = shape.calculateArea();
            double perimeter = shape.calculatePerimeter();
            assert area >= 0 : "Area should be non-negative";
            assert perimeter >= 0 : "Perimeter should be non-negative";
        }
        System.out.println("Test 4 passed: Polymorphism verification");

        // Test case 5: Verify toString methods
        String circleStr = circle.toString();
        assert circleStr.contains("Circle") || circleStr.contains("5.0") : "Circle toString should contain relevant info";
        
        String rectStr = rectangle.toString();
        assert rectStr.contains("Rectangle") || (rectStr.contains("4.0") && rectStr.contains("6.0")) : "Rectangle toString should contain dimensions";
        
        String triStr = triangle.toString();
        assert triStr.contains("Triangle") || triStr.contains("3.0") : "Triangle toString should contain relevant info";
        System.out.println("Test 5 passed: toString methods");

        System.out.println("All tests passed!");
    }
}
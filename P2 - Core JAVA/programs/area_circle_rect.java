import java.util.Scanner;

public class area_circle_rect {
    public static final double PI = 3.14159;

    public static double calculateCircleArea(double radius) {
        return PI * radius * radius;
    }

    public static double calculateRectangleArea(double length, double width) {
        return length * width;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose a shape to calculate its area:");
        System.out.println("1. Circle");
        System.out.println("2. Rectangle");

        int choice = scanner.nextInt();

        if (choice == 1) {
            System.out.println("Enter the radius of the circle:");
            double radius = scanner.nextDouble();
            double circleArea = calculateCircleArea(radius);
            System.out.println("Area of the circle: " + circleArea);
        } else if (choice == 2) {
            System.out.println("Enter the length of the rectangle:");
            double length = scanner.nextDouble();
            System.out.println("Enter the width of the rectangle:");
            double width = scanner.nextDouble();
            double rectangleArea = calculateRectangleArea(length, width);
            System.out.println("Area of the rectangle: " + rectangleArea);
        } else {
            System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}

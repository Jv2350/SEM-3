public class Method_overloading_b{

    // Method with no parameters
    public void printMessage() {
        System.out.println("Hello, World!");
    }

    // Method with one integer parameter
    public void printMessage(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Hello!");
        }
    }

    // Method with two string parameters
    public void printMessage(String message1, String message2) {
        System.out.println(message1 + " " + message2);
    }

    // Method with double and int parameters
    public void printMessage(double number, int count) {
        for (int i = 0; i < count; i++) {
            System.out.println("Number: " + number);
        }
    }
}

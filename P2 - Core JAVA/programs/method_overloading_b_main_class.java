public class method_overloading_b_main_class{
    public static void main(String[] args) {
        Method_overloading_b example = new Method_overloading_b();

        // Calling methods with different signatures
        example.printMessage(); // Calls the method with no parameters
        example.printMessage(3); // Calls the method with one integer parameter
        example.printMessage("Hello", "Java"); // Calls the method with two string parameters
        example.printMessage(3.14, 2); // Calls the method with double and int parameters
    }
}

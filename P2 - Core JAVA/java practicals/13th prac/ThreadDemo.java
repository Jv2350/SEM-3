import java.util.Scanner;

// Create a class called 'Add' that extends the Thread class
class Add extends Thread {
    int n1, n2;

    // Constructor for the 'Add' class
    public Add(int x, int y) {
        n1 = x;
        n2 = y;
    }

    // Override the 'run' method to perform addition and print the result
    @Override
    public void run() {
        System.out.println("Addition is : " + (n1 + n2));
    }
}

// Create a class called 'Sub' that extends the Thread class
class Sub extends Thread {
    int n1, n2;

    // Constructor for the 'Sub' class
    public Sub(int x, int y) {
        n1 = x;
        n2 = y;
    }

    // Override the 'run' method to perform subtraction and print the result
    @Override
    public void run() {
        System.out.println("Subtraction is : " + (n1 - n2));
    }
}

// Create a class called 'Mul' that extends the Thread class
class Mul extends Thread {
    int n1, n2;

    // Constructor for the 'Mul' class
    public Mul(int x, int y) {
        n1 = x;
        n2 = y;
    }

    // Override the 'run' method to perform multiplication and print the result
    @Override
    public void run() {
        System.out.println("Multiplication is : " + (n1 * n2));
    }
}

// Create a class called 'Div' that extends the Thread class
class Div extends Thread {
    int n1, n2;

    // Constructor for the 'Div' class
    public Div(int x, int y) {
        n1 = x;
        n2 = y;
    }

    // Override the 'run' method to perform division and print the result or handle division by zero
    @Override
    public void run() {
        if (n2 != 0) {
            System.out.println("Division is : " + (n1 / n2));
        } else {
            System.out.println("Division by zero is not allowed.");
        }
    }
}

// Create a class called 'ThreadDemo' to demonstrate the usage of the above thread classes
class ThreadDemo {
    public static void main(String ar[]) {
        try {
            Scanner scanner = new Scanner(System.in);

            // Prompt the user to enter two numbers
            System.out.print("Enter 1st number: ");
            int a = scanner.nextInt();
            System.out.print("Enter 2nd number: ");
            int b = scanner.nextInt();

            // Create instances of the thread classes and start them
            new Add(a, b).start();
            new Sub(a, b).start();
            new Mul(a, b).start();
            new Div(a, b).start();
        } catch (Exception e) {
            // Handle exceptions that may occur during user input or thread execution
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}

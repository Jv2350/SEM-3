class MyException extends Exception {
    MyException(String message) {
        super(message);
    }
}

public class ExceptionDemo {
    public static void main(String args[]) throws Exception {
        ExceptionDemo exceptionDemo = new ExceptionDemo();
        exceptionDemo.displayNumbers();
    }

    public void displayNumbers() throws MyException {
        for (int i = 0; i < 10; i++) {
            System.out.println("i= " + i);
            if (i == 6) {
                throw new MyException("My Exception Occurred");
            }
        }
    }
}
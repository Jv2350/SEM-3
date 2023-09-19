// fibo series using recursion 

import java.util.Scanner;

public class fibo_recur {
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = input.nextInt();

        System.out.println("Fibonacci Series up to " + n + " terms:");
        
        // calling the function n(input) times 
        for (int i = 0; i < n; i++) {
            int fib = fibonacci(i);
            System.out.print(fib + " ");
        }

        input.close();
    }    
}

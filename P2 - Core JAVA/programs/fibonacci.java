import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int n = input.nextInt();

        int a = 0;
        int b = 1;
        
        System.out.println("Fibonacci Series up to " + n + " terms:");
        System.out.print(a + " ");

        for (int i = 1; i < n; i++) {
            System.out.print(b + " ");

            int c = a + b;
            a = b;
            b = c;
        }

        input.close();
    }
}

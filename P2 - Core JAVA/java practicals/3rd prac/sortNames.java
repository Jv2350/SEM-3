// Write a Java program to accept n strings and sort names in ascending order.

import java.util.Scanner;

public class sortNames {
    public static void main(String[] args) {
        try (Scanner input = new Scanner(System.in)) {
            int n;
            String temp;

            System.out.print("Enter number of names you want to enter: ");
            n = input.nextInt();
            
            String[] names = new String[n];
            System.out.println("Enter total " + n + " names.");
            input.nextLine(); 
            for (int i = 0; i < n; i++) {
                System.out.println("Enter " + (i+1) + " names: ");
                names[i] = input.nextLine();
            }
            
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (names[i].compareTo(names[j]) >= 0) {
                        temp = names[i];
                        names[i] = names[j];
                        names[j] = temp;
                    }
                }
            }
            
            System.out.println("\nNames in sorted order: ");
            for (int i = 0; i < n; i++) {
                System.out.println((i+1)+". "+names[i]);
            }
        }
    }
}

// Write a function which takes in 2 numbers and returns the greater of those two

import java.util.Scanner;

public class greater_number {
    public static double greater_of_two(double n1, double n2){
        if (n1 < n2){
            return n2;
        } else {
            return n1;
        }
    }
    public static void main(String[] args){
        try(Scanner input = new Scanner(System.in)){
        System.out.print("Enter 1st number: ");
        double num1 = input.nextInt();
        System.out.print("Enter 2nd number: ");
        double num2 = input.nextInt();

        double greater = greater_of_two(num1, num2);
        System.out.print("The greatest number is "+greater);
        }
    }
}
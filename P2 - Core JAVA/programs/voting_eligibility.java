// Write a function that takes in age as input and returns if that person is eligible to vote or not. A person of age > 18 is eligible to vote.

import java.util.Scanner;

public class voting_eligibility {
    public static boolean vote_eligibility(double n) {
        if (n >= 18){
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args){
        try(Scanner input = new Scanner(System.in)){
            System.out.print("Enter your age: ");
            int age = input.nextInt();

            boolean eligible = vote_eligibility(age);
            if (eligible){
                System.out.println("You are eligible to vote");
            } else {
                System.out.println("You are not eligible to vote");
            }
        }
    }
}

// Write a function to print the sum of all odd numbers from 1 to n.

import java.util.Scanner;

public class sum_of_odd_nums {
    public static void sfon(int n) {
        int sum = 0;
        for(int i = 0; i < n; i++){
            // here i+=2 can also be the logic if we start the count from 1!! 

            if(i%2!=0){
                sum += i;
            }
        }
        System.out.println("The sum of odd numbers from 0 to " + n + " is: " + sum);
    }

    public static void main(String[] args){
        try(Scanner input = new Scanner(System.in)){
            System.out.print("Enter the range of numbers: ");
            int range = input.nextInt();
            sfon(range);
        }   
    }
}

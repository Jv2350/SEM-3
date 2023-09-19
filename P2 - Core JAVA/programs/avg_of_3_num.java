// Enter 3 numbers from the user & make a function to print their average.

import java.util.Scanner;

// function for calculating the average of 3 numbers
public class avg_of_3_num{  
    public static double f_avg(double n1, double n2, double n3){ 
        double avg = (n1+n2+n3)/3.0;
        System.out.println("The average of ("+n1+", "+n2+", "+n3+") is: " + avg);
        return 0;     
    }

    public static void main(String[] args){
        try (Scanner inpt = new Scanner(System.in)) {
            double[] num = new double[3];
// getting input from the user using for loop and storing the input value in array 
            for(int i=0; i<3; i++){
                System.out.print("Enter "+(i+1)+" number: ");
                num[i] = inpt.nextDouble();
            }
// calling the f_avg function
            f_avg(num[0],num[1],num[2]);
        }
    }
}
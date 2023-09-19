// Write a function that takes in the radius as input and returns the circumference of a circle.
import java.util.Scanner;

public class circumference_of_circle{
    public static double coc(double r){
        return 2*Math.PI*r;
    }

    public static void main(String[] args){
        try(Scanner input = new Scanner(System.in)){
            System.out.print("Enter the radius of the circle for circumference: ");
            double radius = input.nextInt();
            
            double circum = coc(radius);
            System.out.println("The circumference of the circle with radius "+radius+" is "+ circum);
        }
    }
}

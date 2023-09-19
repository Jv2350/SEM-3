import java.util.Scanner;

public class shape{
    public double a_cirlc(double r){
        return Math.PI*r*r;
    }
    public double a_rect(double l, double b){
        return l*b;
    }

    static double get(){
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter length: ");
        int x = input.nextInt();
        System.out.print("Enter breadht: ");
        int y = input.nextInt();
        
        input.close();
        return x*y;
        
    }
}
import java.util.Scanner;

public class $Shape {
    public class Circle{
        public class Area{
            public double get(){
            Scanner input= new Scanner(System.in);
            System.out.print("Enter the radius of the circle: ");
            double r = input.nextDouble();
            input.close();

            return Math.PI*r*r;
            } 
            double display(){
                double result = get();
                System.out.print("The area of the circle is: ");
                return result;
            }
        }
    }
}

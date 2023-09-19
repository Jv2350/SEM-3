import java.util.Scanner;

import .Shape.Circle;

import .Shape.Circle;
public class area{

    static double  area_of_circles(double r){
        return Math.PI*r*r;
    }
    public static void main(String[] args){
        shape s = new shape();
        double area = s.get();
        System.out.print(area);

        Circle.Area s1 = new Circle.Area();
        double area2 = s1.$Shape.Circle.Area.display();

    //     Scanner input = new Scanner(System.in);

    //     System.out.print("Enter the radius of the circle: ");
    //     int r = input.nextInt();
    //     double area_of_c = s.a_cirlc(r);
    //     System.out.println("Area of circle " + area_of_c);


    //     System.out.print("Enter the length of the rectangle: ");
    //     int l = input.nextInt();
    //     System.out.print("Enter the breadth of the rectangle: ");
    //     int b = input.nextInt();

    //     // double area_of_c = s.a_cirlc(3);
    //     double area_of_r = s.a_rect(l,b);

    //     System.out.println("Area of rectangle " + area_of_r);
    //     input.close();
    }
}
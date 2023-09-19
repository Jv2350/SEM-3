public class Method_overloading {
    
    // creating the method with two parameters
    public int mul(int a, int b){
        return a*b;
    }
    
    // creating the method with three parameters(overloading 1 parameter extra)
    public int mul(int a, int b, int c){
        return a*b*c;
    }

    // creating the method with two parameters but changing the data type of variables
    public double mul(double a, double b){
        return a*b;
    }

    // main method
    public static void main(String[] args){
        Method_overloading method = new Method_overloading();

        System.out.println("Multiplication of 2 and 3 is " + method.mul(2,3));
        System.out.println("Multiplication of 2, 3 and 4 is " + method.mul(2,3,4));
        System.out.println("Multiplication of 2.2 and 3.3 is " + method.mul(2.2,3.3));        
    }
}

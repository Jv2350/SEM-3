// Program for aggregation 

class Operation{
    int square(int n){
        return n * n;
    }
}

class Circle{
    Operation op; //aggregatoin
    double pi = Math.PI;

    double area(int radius){
        op = new Operation();
        int rsq = op.square(radius); //code reusability (i.e delegates the method call)
        return pi * rsq;
    }

    public static void main(String[] args){
        Circle c= new Circle();
        double rslt = c.area(5);
        System.out.println("The area of circle is "+rslt);
    }
}


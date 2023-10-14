class overloaddemo{
    void test(){
        System.out.println("no parameter");
    }
    void test(int a){
        System.out.println("a="+a);
    }
    void test(int a, int b){
        System.out.println("a and b: "+a+" "+b);
    }
    double test(double a){
        System.out.println("double a: "+a);
        return a*a;
    }
}

class overload{
    public static void main(String[] args){
        overloaddemo ob = new overloaddemo();
        double result;

        ob.test();
        ob.test(10);
        ob.test(10,20);
        ob.test(2.1);
        result = ob.test(1.2);
        System.out.print(result);
    }
}
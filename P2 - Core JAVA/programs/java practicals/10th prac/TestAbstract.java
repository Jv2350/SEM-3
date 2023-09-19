// to show mutiple child class can extends a common parent class

abstract class Shape{
    abstract void draw();
}

class Rectangle extends Shape{
    void draw(){
        System.out.println("Drawing rectangle");
    }
}

class Circle extends Shape{
    void draw(){
        System.out.println("Drawing circle");
    }
}

class TestAbstract{
    public static void main(String[] args){
        // Shape s = new Shape();
        Shape s1 = new Rectangle();
        Shape s2 = new Circle();
        s1.draw();
        s2.draw();
    }
}
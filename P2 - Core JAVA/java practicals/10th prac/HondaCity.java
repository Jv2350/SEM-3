// program : Demonstrat use of abstract class

// abstract class
abstract class Car{
    abstract void run(); //abstract method can't have definition
}

class HondaCity extends Car{
    @Override
    void run(){ //run method is compalsary to be define in sub class coz the super class is abstract class
        System.out.println("Honda city is running safely");
    }

    public static void main(String[] args){
        Car c = new HondaCity();
        c.run();
    }
}
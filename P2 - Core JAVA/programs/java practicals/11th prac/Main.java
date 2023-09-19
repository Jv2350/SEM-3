// interface program

// All the mehtod s inside an interface are implicitly public and all fields/variables are implicitly public static final

interface Language{
    // String type = "Programming language"; //by ddefault public static final
    abstract void getName(String name); //by default public
}

// class implements interface
class ProgrammingLang implements Language{
    // implementation of abstract method
    public void getName(String name){
        System.out.println("Programming Language: "+name);
    }
}

class Main{
    public static void main(String[] args){
        ProgrammingLang lang = new ProgrammingLang();
        lang.getName("Java");
    }
}
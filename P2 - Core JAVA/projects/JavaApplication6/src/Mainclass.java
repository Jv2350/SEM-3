import java.util.Scanner;
public class Mainclass {
    public static void main(String[] args) {
        System.out.print("Enter your name: ");
        
        Scanner input = new Scanner(System.in);
        
        String name = input.nextLine();
        System.out.println("Entered name is "+name);
        
        input.close();
    }
}

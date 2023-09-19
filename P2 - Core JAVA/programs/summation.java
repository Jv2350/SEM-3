import java.util.Scanner;

public class summation{
    public static void main(String[] args){
        try{
            int n;
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            job j1 = new Job(n);
        }
        catch(exception e){
            System.out.println("Some process faild to complete");
            System.out.println("Plzzz contact system admine");
        }
    }
}
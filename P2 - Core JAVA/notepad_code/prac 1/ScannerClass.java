//java program using the Scanner class for getting input from the user
//to use it we have to import that calss

import java.util.Scanner;
public class ScannerClass{
    public static void main(String[] args){
	int num; //defining, to access the instance outside the try block 

	try(Scanner input = new Scanner(System.in)){
	    System.out.print("Enter the integer value: ");
	    num = input.nextInt();
	}
	System.out.println("Entered number is "+num);
    }
}
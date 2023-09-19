//write a program java program for reading data from keyboard using data input stream 
//to use class we have to import the class in the program

import java.io.DataInputStream;
public class Data_inpt_strm{
    public static void main(String[] args){

	DataInputStream input = new DataInputStream(System.in);
	int num = 0;
	float flt = 0.00f;

	try{
	    System.out.print("Enter the integer value: ");
	    num = Integer.parseInt(input.readLine());
	    System.out.print("Enter the floating-point value: ");
	    flt = Float.parseFloat(input.readLine());
	} catch(Exception e){}
	
	System.out.println("Integer number is: "+num);
	System.out.println("Floating number is : "+flt);
    }
}
// write a java program to accept and display two dimensional array

import java.util.Scanner;
// import java.io.IOException;

public class _2_b {
    public static void main(String[] args){
        try(Scanner input = new Scanner(System.in)){
            
            System.out.print("Enter number of rows for array: ");
            int row = input.nextInt();
            System.out.print("Enter number of colums for array: ");
            int col = input.nextInt();
        
            int arr[][] = new int[row][col];

            System.out.println("\nCreating the "+(row)+"x"+(col)+" array.");
            for(int i=0; i<row;i++){
                for(int j=0;j<col;j++){
                    System.out.print("Enter element for ["+i+"]["+j+"] index: ");
                    arr[i][j] = input.nextInt();
                }
            }
            System.out.println("Array elements are: ");
            for(int i =0;i<row;i++){
                for(int j=0;j<col;j++){
                    System.out.print(arr[i][j]+" ");
                }
                System.out.println();
            }
        }
    }
}
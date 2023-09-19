// write a java program to accept and display single dimensional array

public class _2_a {
    public static void main(String[] args){
        int array[];
        array = new int[5];

        System.out.print("Array elements are: ");
        for(int i=0;i<array.length;i++){
            array[i] = i+1;
            System.out.print(array[i]+" ");
        }
    }
}
import java.io.*;

public class ReaderWriter {
    public static void main(String args[]) throws IOException {
        System.out.println("With InputStreamReader");
        int a;
        String s;

        // Create an InputStreamReader to read input from the console
        InputStreamReader inr = new InputStreamReader(System.in);
        System.out.print("Enter a line: ");

        // Read characters until Enter (ASCII 13) is pressed
        while ((a = inr.read()) != 13) {
            System.out.print((char) a);
        }

        System.out.println(); // Print a newline
        System.out.println("\nWith BufferedReader and InputStreamReader");

        // Create a BufferedReader to read input from the console using InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a line: ");

        // Read a line of text from the console
        String inputLine = br.readLine();
        System.out.println("You entered: " + inputLine);

        System.out.println("\nOutput With PrintWriter and FileWriter");

        // Create a BufferedReader to read input from the console using InputStreamReader
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));

        // Create a PrintWriter to write output to a file named "demo.out"
        PrintWriter p = new PrintWriter(new FileWriter("Output.txt"));

        System.out.print("Enter lines (Ctrl+C to exit): ");

        // Read lines from the console and write them to the file with a prefix
        while ((s = br1.readLine()) != null) {
            p.println("Output: " + s);
        }

        // Close the PrintWriter to save the changes to the file
        p.close();
    }
}

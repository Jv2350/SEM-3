import java.io.*;

public class ReaderWriter {
    public static void main(String args[]) throws IOException {
        System.out.println("With InputStreamReader");
        int a;
        String s;
        InputStreamReader inr = new InputStreamReader(System.in);
        System.out.println("enter a line");
        while ((a = inr.read()) != 13)
            System.out.println((char) a);
        System.out.println();
        System.out.println("With BufferedReader and InputStreamReader");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter a line");
        System.out.println(br.readLine());
        System.out.println("Output With PrintWriter and FileWriter");
        BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter p = new PrintWriter(new FileWriter("demo.out"));
        while ((s = br1.readLine()) != null)
            p.println("output " + s);
        p.close();
    }
}

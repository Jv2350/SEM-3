import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        final String serverAddress = "localhost"; // Change to the server's IP if needed
        final int serverPort = 12345; // Specify the server's port

        try {
            Socket socket = new Socket(serverAddress, serverPort);
            System.out.println("Connected to server: " + serverAddress + ":" + serverPort);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            Scanner scanner = new Scanner(System.in);

            System.out.print("Enter names (separated by commas): ");
            String names = scanner.nextLine();

            // Send names to server
            writer.println(names);

            // Receive and display the server's confirmation message
            String confirmationMessage = reader.readLine();
            System.out.println("Server says: " + confirmationMessage);

            socket.close();
            reader.close();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

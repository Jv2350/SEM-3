import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        final int port = 12345; // Specify the port you want to use
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server is listening on port " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String clientInput = reader.readLine();
                try {
                    int number = Integer.parseInt(clientInput);
                    System.out.println("Received number from client: " + number);

                    if (number >= 0) {
                        int sumOfDigits = calculateSumOfDigits(number);
                        writer.println("Sum of digits: " + sumOfDigits);
                    } else {
                        writer.println("Error: Negative number not allowed");
                    }
                } catch (NumberFormatException e) {
                    writer.println("Error: Invalid input");
                }

                writer.close();
                reader.close();
                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int calculateSumOfDigits(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}

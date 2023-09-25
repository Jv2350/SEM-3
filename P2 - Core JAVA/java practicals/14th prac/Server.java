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

				String receivedNames = reader.readLine();
				System.out.println("Received names from client: " + receivedNames);

				// Send confirmation message to client
				writer.println("NAMES RECEIVED: " + receivedNames);

				writer.close();
				reader.close();
				clientSocket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

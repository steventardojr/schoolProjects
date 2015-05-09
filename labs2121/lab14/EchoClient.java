import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		String host = "localhost";
		Integer port = 4444;
		Scanner sc = new Scanner(System.in);
		String userInput = "";
		
		try (
			// Create a socket to connect to the server
			Socket echoSocket = new Socket(host, port);
			
			// Create the tools to read from the server
			InputStream clientInputStream = echoSocket.getInputStream();
			InputStreamReader clientInput = new InputStreamReader(clientInputStream);
			BufferedReader reader = new BufferedReader(clientInput);
			
			// Create the tools to write to the server
			OutputStream clientOutput = echoSocket.getOutputStream();
			PrintWriter writer = new PrintWriter(clientOutput);
			) {
				System.out.println("Enter something:");
				userInput = sc.next();
				writer.println(userInput);
				writer.flush();
				String line = "";
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
	}
}
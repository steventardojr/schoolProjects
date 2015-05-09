import java.net.Socket;
import java.net.ServerSocket;
import java.lang.Exception;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class EchoServer {
	public static void main(String[] args) throws Exception {
		// Create a server socket
		int portNumber = 4444;
		ServerSocket serverSocket = new ServerSocket(portNumber);
		
		// Listen on the socket
		while (true) {
			// Poll until a connection is received
			Socket clientSocket = serverSocket.accept();
			
			// Create the tools to read from the server
			InputStream clientInputStream = clientSocket.getInputStream();
			InputStreamReader clientInput = new InputStreamReader(clientInputStream);
			BufferedReader reader = new BufferedReader(clientInput);
			
			// Create the tools to write to the server
			OutputStream clientOutput = clientSocket.getOutputStream();
			PrintWriter writer = new PrintWriter(clientOutput);
			
			// For ever line read from the socket, write it back
			boolean finished = false;
			String line = "";
			while (!finished) {
				line = reader.readLine();
				writer.println(line);
				finished = true;
			}
			
			// Close everything
			writer.flush();
			writer.close();
			reader.close();
			clientSocket.close();
		}
	}
}
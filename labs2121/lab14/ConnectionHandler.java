import java.net.Socket;
import java.net.ServerSocket;
import java.lang.Exception;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.PrintWriter;

public class ConnectionHandler implements Runnable {
	private Socket clientSocket;
	
	public ConnectionHandler(Socket clientSocket) {
		this.clientSocket = clientSocket;
	}
	
	public void run() {
		try {
			// Create the tools to read from the server
			InputStream clientInputStream = clientSocket.getInputStream();
			InputStreamReader clientInput = new InputStreamReader(clientInputStream);
			BufferedReader reader = new BufferedReader(clientInput);
			
			// Create the tools to write to the server
			OutputStream clientOutput = clientSocket.getOutputStream();
			PrintWriter writer = new PrintWriter(clientOutput);
			
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
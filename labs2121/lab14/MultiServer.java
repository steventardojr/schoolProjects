import java.lang.Exception;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.ExecutorService;

public class MultiServer {
	public static void main(String[] args) throws Exception {
		int portNumber = 4444;
		ServerSocket serverSocket = new ServerSocket(portNumber);
		
		ExecutorService service = Executors.newCachedThreadPool();
		
		while (true) {
			Socket clientSocket = serverSocket.accept();
			ConnectionHandler handler = new ConnectionHandler(clientSocket);
			service.execute( handler );
		}
	}
}
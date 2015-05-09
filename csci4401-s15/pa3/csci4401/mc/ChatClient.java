package csci4401.mc;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

public class ChatClient implements MulticastClient, Serializable {
	private static final long serialVersionUID =
			8573341119855343424L;
	private String clientName;
	
	public ChatClient(String clientName) {
		this.clientName = clientName;
	}
	
	public String getName() {
		return this.clientName;
	}
	
	/**
   * This method is called by the server to deliver messages
   */
  public void receive(RemoteMessage message, String alias) throws RemoteException {
  	RemoteMessage newMessage = message;
  	BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
  	System.out.print( "\r" + alias + "-" + newMessage.getSource() + ":  " + newMessage.getContent() + "\n>> ");
  }
	
	
	public static void main(String[] args) throws Exception {
		if (args.length != 4) {
			System.out.println("Invalid number of arguments");
			System.exit(0);
		}
		String line;
		String hostname = args[0];
		int portNumber = Integer.parseInt(args[1]);
		String userName = args[2];
		String sessionName = args[3];
		MulticastClient client = new ChatClient(userName);
		UnicastRemoteObject.exportObject(client, 0);
		Registry registry;
		if (hostname.equals("localhost")) {
			registry = LocateRegistry.getRegistry(portNumber);
		}
		else {
			registry = LocateRegistry.getRegistry(hostname, portNumber);
		}
	  MulticastService stub = (MulticastService) registry.lookup("Server");
	  String uniqueID = stub.addMember(sessionName, client, userName);
	  BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));

	  System.out.println("Welcome to " + sessionName);
	  System.out.println("Type \"exit\" to exit");
    System.out.print(">> ");
    while(!((line = stdin.readLine()).equals("exit"))) {
    	
    	Message message = new Message(line, uniqueID);
    	stub.sendOthers(sessionName, message);
    	System.out.print(">> ");
    } 
	  stub.removeMember(sessionName, client, uniqueID);
	  UnicastRemoteObject.unexportObject(client, true);
	}
}

package csci4401.mc;

import java.rmi.RemoteException;
import java.io.Serializable;
import java.rmi.registry.*;
import java.rmi.server.*;
import java.util.*;

public class MulticastServer extends Thread implements MulticastService, Serializable {
	private static final long serialVersionUID =
			8573341119855343424L;
	private HashMap<String, Channel> channelList;
	private HashMap<String, MulticastClient> clientList;
	private Random random;
	private HashMap<String, String> clientNameList;
	public static final String SERVICE_NAME = "MulticastServer";
	
	public MulticastServer() {
		channelList = new HashMap<String, Channel>();
		clientList = new HashMap<String, MulticastClient>();
		clientNameList = new HashMap<String, String>();
		random = new Random();
	}
	
  /**
   * Adds a member to a channel. If the channel does not exist - it is created implicitly.
   * @param channelName the channel to which the client is to be added
   * @param client a (remote) reference to the client
   * @return a unique source identifier assigned by the server to the calling client; id must be included as the source in send requests.
   */
  public String addMember(String channelName, MulticastClient client, String alias) throws RemoteException {
  	if (channelList.containsKey(channelName)) {
  		Channel tempChannel = channelList.get(channelName);
  		String tempID = Integer.toString(random.nextInt(1000));
  		clientList.put(tempID, client);
  		clientNameList.put(tempID, alias);
  		HashMap<String, MulticastClient> tempClient = new HashMap<String, MulticastClient>();
  		tempClient.put(tempID, client);
  		tempChannel.addMember(tempID, tempClient);
  		return tempID;
  	}
  	else {
  		Channel tempChannel = new Channel(channelName);
  		channelList.put(channelName, tempChannel);
  		String tempID = Integer.toString(random.nextInt(1000));
  		clientList.put(tempID, client);
  		clientNameList.put(tempID, alias);
  		HashMap<String, MulticastClient> tempClient = new HashMap<String, MulticastClient>();
  		tempClient.put(tempID, client);
  		tempChannel.addMember(tempID, tempClient);
  		return tempID;
  	}
  }

  /**
   * Removes a member from a channel. If this is the last member of the channel - the channel
   * itself is also deleted.
   * @param channelName the channel from which the client is to be removed
   * @param client a (remote) reference to the client
   * @param preferred client identifier; if already present, server issues a different one
   * @return number of clients in this channel <i>after</i> the execution of the call
   */
  public int removeMember(String channelName, MulticastClient client, String ID) throws RemoteException {
  	Channel tempChannel = channelList.get(channelName);
  	clientList.remove(ID);
  	clientNameList.remove(ID);
		int i = tempChannel.removeMember(ID);
		if (i == 0) {
			channelList.remove(channelName);
		}
		return i;
  }

  /**
   * Enumerates the membership of a channel
   * @param channelName the channel from which the client is to be removed
   * @return the client IDs as assigned by the server
   */
  public String[] getMembers(String channelName) throws RemoteException {
  	Channel tempChannel = channelList.get(channelName);
  	HashMap<String, HashMap<String, MulticastClient>> membersList = tempChannel.getMembers();
  	ArrayList<String> listOfMembers = new ArrayList<String>();
  	List<HashMap<String, MulticastClient>> members = new ArrayList<HashMap<String, MulticastClient>>(membersList.values());
  	for (int i = 0; i < members.size(); i++) {
  		HashMap<String, MulticastClient> tempMap = members.get(i);
  		Set<String> keys = tempMap.keySet();
  		String[] keyList = keys.toArray(new String[keys.size()]);
  		listOfMembers.add(keyList[0]);
  	}
  	return listOfMembers.toArray(new String[listOfMembers.size()]);
  }

  /**
   * <p>Deposits an message in the queues of every member of the channel.
   * <p><i>Note:</i>Whether/when the message is actually is delivered depends on the
   * installed filters.
   * @param channelName the channel to which the message is to be multicast
   * @param message the message to be propagated
   */
  public synchronized void sendAll(String channelName, RemoteMessage message) throws RemoteException {
  	final String newChannelName = channelName;
  	final RemoteMessage newMessage = message;
  	Channel tempChannel = channelList.get(newChannelName);
  	HashMap<String, HashMap<String, MulticastClient>> membersList = tempChannel.getMembers();
  	List<HashMap<String, MulticastClient>> members = new ArrayList<HashMap<String, MulticastClient>>(membersList.values());
  	for (int i = 0; i < members.size(); i++) {
  		HashMap<String, MulticastClient> tempMap = members.get(i);
  		Set<String> keys = tempMap.keySet();
  		String[] keyList = keys.toArray(new String[keys.size()]);
  		final MulticastClient tempClient = (MulticastClient)clientList.get(keyList[0]);
  		Thread newThread = new Thread() {
  			public void run() {
  				try {
  					tempClient.receive(newMessage, (String)clientNameList.get(newMessage.getSource()));
  				}
  				catch (Exception e) {
  					System.out.println(e.getMessage());
  				}
  			}
  		};
  		newThread.setPriority(Thread.MAX_PRIORITY);
    	newThread.start();
    }
  }

  /**
   * <p>Deposits an message in the queues of every member of the channel with the exception of
   * the sender.
   * <p><i>Note:</i>Whether/when the message is actually is delivered depends on the
   * installed filters.
   * @param channelName the channel to which the message is to be multicast
   * @param message the message to be propagated
   */
  public synchronized void sendOthers(String channelName, RemoteMessage message) throws RemoteException {
  	final RemoteMessage newMessage = message;
  	Channel tempChannel = channelList.get(channelName);
  	HashMap<String, HashMap<String, MulticastClient>> membersList = tempChannel.getMembers();
  	List<HashMap<String, MulticastClient>> members = new ArrayList<HashMap<String, MulticastClient>>(membersList.values());
  	for (int i = 0; i < members.size(); i++) {
  		HashMap<String, MulticastClient> tempMap = members.get(i);
  		Set<String> keys = tempMap.keySet();
  		String[] keyList = keys.toArray(new String[keys.size()]);
  		final MulticastClient tempClient = (MulticastClient)clientList.get(keyList[0]);
  		if (!(keyList[0].equals(newMessage.getSource()))) {
  			Thread newThread = new Thread() {
  	  		public void run() {
  	  			try {
    					tempClient.receive(newMessage, (String)clientNameList.get(newMessage.getSource()));
    					}
    				catch (Exception e) {
    					System.out.println(e.getMessage());
    				}
  				}
  			};
  			newThread.setPriority(Thread.MAX_PRIORITY);
  	  	newThread.start();
  		}
  	}
  }
  
  public static void main(String[] args) {
  	if (args.length != 1) {
			System.out.println("Invalid number of arguments");
			System.exit(0);
		}
  	try {
  		MulticastServer server = new MulticastServer();
  		MulticastService stub = (MulticastService) UnicastRemoteObject.exportObject(server, 0);
  		
  		Registry registry = LocateRegistry.getRegistry(Integer.parseInt(args[0]));
  		registry.rebind("Server", stub);
  		System.err.println("Server started");
  	}
  	catch (Exception e) {
  		System.out.println(e.getMessage());
  	}
  }
}

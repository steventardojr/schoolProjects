package csci4401.mc;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MulticastClient extends Remote {
    /**
     * This method is called by the server to deliver messages
     */
    public void receive(RemoteMessage message, String alias) throws RemoteException;
}

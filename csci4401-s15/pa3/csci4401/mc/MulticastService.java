package csci4401.mc;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface MulticastService extends Remote {
    public static final String SERVICE_NAME = "MulticastServer";

    /**
     * Adds a member to a channel. If the channel does not exist - it is created implicitly.
     * @param channelName the channel to which the client is to be added
     * @param client a (remote) reference to the client
     * @return a unique source identifier assigned by the server to the calling client; id must be included as the source in send requests.
     */
    public String addMember(String channelName, MulticastClient client, String alias) throws RemoteException;

    /**
     * Removes a member from a channel. If this is the last member of the channel - the channel
     * itself is also deleted.
     * @param channelName the channel from which the client is to be removed
     * @param client a (remote) reference to the client
     * @param preferred client identifier; if already present, server issues a different one
     * @return number of clients in this channel <i>after</i> the execution of the call
     */
    public int removeMember(String channelName, MulticastClient client, String ID) throws RemoteException;

    /**
     * Enumerates the membership of a channel
     * @param channelName the channel from which the client is to be removed
     * @return the client IDs as assigned by the server
     */
    public String[] getMembers(String channelName) throws RemoteException;

    /**
     * <p>Deposits an message in the queues of every member of the channel.
     * <p><i>Note:</i>Whether/when the message is actually is delivered depends on the
     * installed filters.
     * @param channelName the channel to which the message is to be multicast
     * @param message the message to be propagated
     */
    public void sendAll(String channelName, RemoteMessage message) throws RemoteException;

    /**
     * <p>Deposits an message in the queues of every member of the channel with the exception of
     * the sender.
     * <p><i>Note:</i>Whether/when the message is actually is delivered depends on the
     * installed filters.
     * @param channelName the channel to which the message is to be multicast
     * @param message the message to be propagated
     */
    public void sendOthers(String channelName, RemoteMessage message) throws RemoteException;
}





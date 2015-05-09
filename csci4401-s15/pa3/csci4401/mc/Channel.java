package csci4401.mc;

import java.util.*;
import java.io.Serializable;

public class Channel implements Serializable {
	private static final long serialVersionUID =
			8573341119855343424L;
	private String name;
	private HashMap<String, HashMap<String, MulticastClient>> members;
	
	public Channel(String channelName) {
		this.name = channelName;
		this.members = new HashMap<String, HashMap<String, MulticastClient>>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public HashMap<String, HashMap<String, MulticastClient>> getMembers() {
		return this.members;
	}
	
	public void addMember(String ID, HashMap<String, MulticastClient> newMember) {
		members.put(ID, newMember);
	}
	
	public int removeMember(String oldMemberID) {
		members.remove(oldMemberID);
		return members.size();
	}
}

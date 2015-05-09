package csci4401.mc;

public class Message implements RemoteMessage {
	private static final long serialVersionUID =
			8573341119855343424L;
	private String line;
	private String ID;
	
	public Message(String line, String ID) {
		this.line = line;
		this.ID = ID;
	}
	
	/**
   * @return the unique string identifier of the source
   */
  public String getSource() {
  	return this.ID;
  }

  /**
   * @return content of the message
   */
  public String getContent() {
  	 return this.line;
  }
}

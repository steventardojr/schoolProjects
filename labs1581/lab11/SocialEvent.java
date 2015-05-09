/**
 * SocialEvent Class
 * Lab Eleven
 **/

public class SocialEvent extends GeneralEvent {
  private boolean byob;

  public SocialEvent(String name, String location, String date, boolean byob) {
    super(name, location, date);
    this.byob = byob;
  }

  public boolean returnBYOB() {
    return this.byob;
  }

  public String toString() {
    return "You have the event " + this.eventName + " in " + this.eventLocation + " on " + this.eventDate + ". BYOB: " + this.byob;
  }
}

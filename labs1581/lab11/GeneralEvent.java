/**
 * GeneralEvent Class
 * Lab Eleven
 **/

public class GeneralEvent implements Event {
  protected String eventName;
  protected String eventLocation;
  protected String eventDate;

  public GeneralEvent(String name, String location, String date) {
    this.eventName = name;
    this.eventLocation = location;
    this.eventDate = date;
  }

  public String getName() {
    return this.eventName;
  }

  public String getLocation() {
    return this.eventLocation;
  }

  public String getDate() {
    return this.eventDate;
  }

  public String toString() {
    return "You have the event " + this.eventName + " in " + this.eventLocation + " on " + this.eventDate;
  }
}

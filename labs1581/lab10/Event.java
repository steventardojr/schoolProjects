/**
 * Event Class
 * Lab Ten
 **/

public class Event {
  protected String eventName;
  protected String eventLocation;
  protected String eventDate;

  public Event(String name, String location, String date) {
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
}

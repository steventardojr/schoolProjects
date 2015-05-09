/**
 * SchoolEvent Class
 * Lab Eleven
 **/

public class SchoolEvent extends GeneralEvent {
  private String courseName;

  public SchoolEvent(String name, String location, String date, String courseName) {
    super(name, location, date);
    this.courseName = courseName;
  }

  public String getCourseName() {
    return this.courseName;
  }

  public String toString() {
    return "You have the event " + this.eventName + " in " + this.eventLocation + " on " + this.eventDate + " for the course " + this.courseName;
  }
}

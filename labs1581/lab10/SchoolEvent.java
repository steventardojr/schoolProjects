/**
 * SchoolEvent Class
 * Lab Ten
 **/

public class SchoolEvent extends Event {
  private String courseName;

  public SchoolEvent(String name, String location, String date, String courseName) {
    super(name, location, date);
    this.courseName = courseName;
  }

  public String getCourseName() {
    return this.courseName;
  }

  public String toString() {
    return "You have the event " + super.eventName + " in " + super.eventLocation + " on " + super.eventDate;
  }
}

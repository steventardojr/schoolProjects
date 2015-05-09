/**
 * Exercise One
 * Lab Eleven
 **/

import java.util.*;

public class ExerciseOne
{
  public static void main(String[] args)
  {
    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);
    Event[] fiveEvents = new Event[5]; 
    System.out.println("This program will create one general event, two school events and two social events");
    System.out.println("First create one general event");
    System.out.println("Enter the name of the general event:");
    String userEventName = sc1.nextLine();
    System.out.println("Enter the location of the event:");
    String userEventLocation = sc1.nextLine();
    System.out.println("Enter the date of the event:");
    String userEventDate = sc1.nextLine();
    GeneralEvent userEvent = new GeneralEvent(userEventName, userEventLocation, userEventDate);
    fiveEvents[0] = userEvent;
    System.out.println("Next, create three school events");
    for (int i = 1; i < 3; i++) {
      System.out.println("Enter the name of the course:");
      String courseName = sc1.nextLine();
      System.out.println("Enter the name of the school event:");
      String eventName = sc1.nextLine();
      System.out.println("Enter the location of the event:");
      String eventLocation = sc1.nextLine();
      System.out.println("Enter the date of the event:");
      String eventDate = sc1.nextLine();
      SchoolEvent userSchoolEvent = new SchoolEvent(eventName, eventLocation, eventDate, courseName);
      fiveEvents[i] = userSchoolEvent;
    }
    System.out.println("Finally, create two social events");
    for (int i = 3; i < 5; i++) {
      System.out.println("Enter the name of the party event:");
      String eventName = sc1.nextLine();
      System.out.println("Enter the location of the event:");
      String eventLocation = sc1.nextLine();
      System.out.println("Enter the date of the event:");
      String eventDate = sc1.nextLine();
      System.out.println("Enter true or false for BYOB:");
      boolean byob = sc2.nextBoolean();
      SocialEvent userSocialEvent = new SocialEvent(eventName, eventLocation, eventDate, byob);
      fiveEvents[i] = userSocialEvent;
    }
    String output = "";
    for (int i = 0; i < 5; i++) {
      output = fiveEvents[i].toString();
      System.out.println(output);
    }
  }
}

/**
 * Exercise One
 * Lab Ten
 **/

import java.util.*;

public class ExerciseOne
{
  public static void main(String[] args)
  {
    Scanner sc1 = new Scanner(System.in);
    System.out.println("This program will create a school event");
    System.out.println("Enter the name of the course:");
    String courseName = sc1.nextLine();
    System.out.println("Enter the name of the event:");
    String eventName = sc1.nextLine();
    System.out.println("Enter the location of the event:");
    String eventLocation = sc1.nextLine();
    System.out.println("Enter the date of the event:");
    String eventDate = sc1.nextLine();
    SchoolEvent userSchoolEvent = new SchoolEvent(eventName, eventLocation, eventDate, courseName);
    String output1 = userSchoolEvent.toString();
    String output2 = userSchoolEvent.getCourseName();
    System.out.println(output1 + " for the course " + output2);
  }
}

/**
 * Exercise Six
 * Lab Six
 **/

import java.util.Scanner;
import java.util.ArrayList;

public class ExerciseSix
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    ArrayList studentRoster = new ArrayList();
    int userChoice = 1;
    String studentName = "";
    while (userChoice > 0 && userChoice < 6) {
      userChoice = menuChoice();
      switch (userChoice) {
        case 1:
          System.out.println("Enter the student's name to add:");
          studentName = input.nextLine();
          studentRoster.add(studentName);
          break;
        case 2:
          System.out.println("Enter the student's name to remove:");
          studentName = input.nextLine();
          studentRoster.remove(studentName);
          break;
        case 3:
          System.out.println("Enter the student's name to check enrollment:");
          studentName = input.nextLine();
          if (studentRoster.contains(studentName) == true)
            System.out.println("The student is currently enrolled");
          else
            System.out.println("The student is not currently enrolled");
          break;
        case 4:
          if (studentRoster.size() > 0) {
            System.out.println("The students currently enrolled are");
            System.out.println(studentRoster);
          }
          else
            System.out.println("There are no students currently enrolled");
          break;
        case 5:
          System.out.println("The number of students enrolled is " + studentRoster.size());
          break;
        case 6:
          break;
        default:
          break;
      }
    }
  }

  public static int menuChoice()
  {
    Scanner input = new Scanner(System.in);
    System.out.println("Select from the following menu options");
    System.out.println("1) Add a student");
    System.out.println("2) Remove a student");
    System.out.println("3) Check enrollment of a student");
    System.out.println("4) Print the roster");
    System.out.println("5) Get the number of enrolled students");
    System.out.println("6) Quit");
    int choice = input.nextInt();
    return choice;
  }
}

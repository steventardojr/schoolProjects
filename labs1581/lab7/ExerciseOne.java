/**
 * Exercise One
 * Lab Seven
 **/

import java.util.Scanner;

public class ExerciseOne
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    String string1 = "";
    String string2 = "";
    String clear = "";
    int string1Length = 0;
    int string2Length = 0;
    int userChoice = 0;
    while (userChoice != -1)
    {
      System.out.println("Enter a string");
      string1 = input.nextLine();
      System.out.println("Enter another string");
      string2 = input.nextLine();
      if (string1.equals(string2))
        System.out.println("The strings are equal!");
      else
        System.out.println("The strings are not equal.");
      if (string1.compareTo(string2) < 0)
        System.out.println("The strings are in alphabetical order");
      else if (string1.compareTo(string2) == 0)
        System.out.println("The strings are the same alphabetically");
      else
        System.out.println("The strings are not in alphabetical order");
      string1Length = string1.length();
      string2Length = string2.length();
      System.out.println("String 1 is " + string1Length + " character(s) long.");
      System.out.println("String 2 is " + string2Length + " character(s) long.");
      if (string1Length > string2Length)
        System.out.println("String 1 is longer than String 2");
      else if (string1Length == string2Length)
        System.out.println("String 1 is the same length as String 2");
      else
        System.out.println("String 2 is longer than String 1");
      System.out.println("To try again, enter 0");
      System.out.println("To exit, enter -1");
      userChoice = input.nextInt();
      clear = input.nextLine();
    }
  }
}

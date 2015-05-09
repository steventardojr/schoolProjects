/**
 * Exercise One
 * Lab Three
 **/

import java.util.Scanner;

public class ExerciseOne
{
  public static void main( String[] argsv )
    {
      // Initialize a scanner object
      Scanner input = new Scanner( System.in );

      // Create strings to hold day
      String monday = "Monday";
      String userInput = "";

      // Get user input
      System.out.println( "Please enter a day of the week:" );
      userInput = input.next();

      // Compare user's input
      System.out.println( "Before the if statement" );
      if (userInput.equals( monday ))
        System.out.println( "Damn, the week is just beginning" );
      System.out.println( "After the if statement" );
    }
} 

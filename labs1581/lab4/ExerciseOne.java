/**
 * Exercise One
 * Lab Four
 **/

import java.util.Scanner;

public class ExerciseOne
{
  public static void main( String[] argsv )
    {
      // Initialize a scanner object
      Scanner input = new Scanner( System.in );

      // Create variable to hold input
      int userInput = 0;

      // Get user input
      System.out.println( "Enter the number of times you would like to count:" );
      userInput = input.nextInt();
      for (int i = 0; i <= userInput; i++) {
        System.out.println( i );
      }
    }
} 

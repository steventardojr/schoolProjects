/**
 * Exercise Two
 * Lab Four
 **/

import java.util.Scanner;

public class ExerciseTwo
{
  public static void main( String[] argsv )
    {
      // Initialize a scanner object
      Scanner input = new Scanner( System.in );

      // Create variable to hold input
      int month = 0;

      // Get user input
      do
      {
        System.out.println( "Please enter a month between 1 and 12:" );
        month = input.nextInt();
      } while ( month < 1 || month > 12 );
    }
} 

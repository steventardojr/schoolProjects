/**
 * Exercise Two
 * Lab Three
 **/

import java.util.Scanner;

public class ExerciseTwo
{
  public static void main( String[] argsv )
    {
      // Initialize a scanner object
      Scanner input = new Scanner( System.in );

      // Create integers to hold age
      int userInput = 0;
      int age = 0;

      // Get user input
      System.out.println( "Please enter your age:" );
      userInput = input.nextInt();

      // Compare user's input
      System.out.println( "Before the if...else statement" );
      if (userInput < 21)
        System.out.println( "Sorry kid, no cocktails for you" );
      else
        System.out.println( "Pick your poison, it's five o'clock somewhere" );
      System.out.println( "After the if...else statement" );
    }
} 

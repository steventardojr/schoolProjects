/**
 * Exercise Four
 * Lab Four
 **/

import java.util.Scanner;

public class ExerciseFour
{
  public static void main( String[] argsv )
    {
      // Initialize a scanner object
      Scanner input = new Scanner( System.in );

      // Decalre and initialize user input
      int userInput = 0;

      // Accept and check user input
      System.out.println( "Enter an integer between 0 and 10" );
      userInput = input.nextInt();
      if ( userInput > 0 || userInput < 10)
        System.out.println( "Valid number" );
      else
        System.out.println( "Invalid number" );
      System.out.println( "Enter an integer divisble by 2 or 3" );
      userInput = input.nextInt();
      if ( userInput % 2 == 0 || userInput % 3 == 0)
        System.out.println( "Valid number" );
      else
        System.out.println( "Invalid number" );
      System.out.println( "Enter an integer that is either negative and even or positive and odd" );
      userInput = input.nextInt();
      if ( ( userInput < 0 && userInput % 2 == 0 ) || ( userInput > 0 && userInput % 2 == 1 ) )
        System.out.println( "Valid number" );
      else
        System.out.println( "Invalid number" );
      System.out.println( "Enter an integer that is either divisble by 2 or 5 but not both" );
      userInput = input.nextInt();
      if ( ( userInput % 2 == 0 || userInput % 5 == 0 ) && userInput % 10 != 0 )
        System.out.println( "Valid number" );
      else
        System.out.println( "Invalid number" );
      System.out.println( "Enter an integer that is odd and positive" );
      userInput = input.nextInt();
      if ( userInput > 0 && userInput % 2 == 1  )
        System.out.println( "Valid number" );
      else
        System.out.println( "Invalid number" );
    }
} 

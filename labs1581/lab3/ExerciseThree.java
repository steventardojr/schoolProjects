/**
 * Exercise Three
 * Lab Three
 **/

import java.util.Scanner;

public class ExerciseThree
{
  public static void main( String[] argsv )
    {
      // Initialize a scanner object
      Scanner input = new Scanner( System.in );

      // Create integer to hold number
      int userInput = 0;

      // Get user input
      System.out.println( "Please enter a number to check if it's prime" );
      userInput = input.nextInt();

      // Compare user's input
      if (userInput <= 0)
        System.out.println( "Invalid number, primes are positive" );
      else if (userInput % 2 == 0)
        System.out.println( "Not a prime" );
      else if (userInput % 3 == 0)
        System.out.println( "Not a prime" );
      else if (userInput % 4 == 0)
        System.out.println( "Not a prime" );
      else if (userInput % 5 == 0)
        System.out.println( "Not a prime" );
      else if (userInput % 6 == 0)
        System.out.println( "Not a prime" );
      else if (userInput % 7 == 0)
        System.out.println( "Not a prime" );
      else if (userInput % 8 == 0)
        System.out.println( "Not a prime" );
      else if (userInput % 9 == 0)
        System.out.println( "Not a prime" );
      else if (userInput % 10 == 0)
        System.out.println( "Not a prime" );
      else if (userInput > 100)
        System.out.println( "Number is too large for this tester" );
      else
        System.out.println( "The number is prime" );
    }
} 

/**
 * Exercise Seven
 * Lab Three
 **/

import java.util.Scanner;

public class ExerciseSeven
{
  public static void main( String[] argsv )
    {
      // Initialize a scanner object
      Scanner input = new Scanner( System.in );

      // Create variables to hold input
      float grade = 0;
      float sum = 0;
      float average = 0;
      int counter = -1;

      // Get user input and average grades
      System.out.println( "Please enter your grades to average:" );
      System.out.println( "When you are complete, enter -1." );
      while (grade != -1) {
        System.out.println( "Please enter your next grade:" );
        grade = input.nextFloat();
        if (grade < -1) {
          System.out.println( "Please enter a non-negative number:" );
          grade = input.nextFloat();
          }
        else if (grade > 100) {
          System.out.println( "Please enter a number less than 100:" );
          grade = input.nextFloat();
          }
        sum = sum + grade;
        counter++;
        }
      average = (sum + 1) / (float) counter;
      System.out.println( "Your average is " + average );
    }
} 

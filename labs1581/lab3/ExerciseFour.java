/**
 * Exercise Four
 * Lab Three
 **/

import java.util.Scanner;

public class ExerciseFour
{
  public static void main( String[] argsv )
    {
      // Initialize a scanner object
      Scanner input = new Scanner( System.in );

      // Create variables to hold input
      float grade = 0;
      float sum = 0;
      float average = 0;
      int numberOfGrades = 0;
      int counter = 1;

      // Get user input and average grades
      System.out.println( "Please enter the number of grades to average:" );
      numberOfGrades = input.nextInt();
      while (counter <= numberOfGrades) {
        System.out.println( "Please enter the next grade to average:" );
        grade = input.nextFloat();
        sum = sum + grade;
        counter++;
        }
      average = sum / (float) numberOfGrades;
      System.out.println( "Your average is " + average );
    }
} 

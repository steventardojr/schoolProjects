/**
 * Exercise Three
 * Lab Four
 **/

import java.util.Scanner;

public class ExerciseThree
{
  public static void main( String[] argsv )
    {
      // Initialize a scanner object
      Scanner input = new Scanner( System.in );

      // Create and initalize variables
      int userInput = 0;
      float percent = 1;
      float grade = 0;
      float sum = 0;
      float average = 0;
      int totalNumberOfGrades = 0;
      int numberOfGrades = 0;
      int counter = 0;
      float totalAvg = 0;

      // Get user input and perform operations
      while (userInput != 4) {
        System.out.println( "Please pick from one of the following options:" );
        System.out.println( "1. Set percentage of total for new grades." );
        System.out.println( "2. Enter new grades." );
        System.out.println( "3. Get average." );
        System.out.println( "4. Quit." );
        userInput = input.nextInt();
        switch ( userInput )
        {
          case 1:
            System.out.println( "Enter the percentage for which the grades" );
            System.out.println( "count as a decimal (Example: Enter 10% as 0.1)" );
            percent = input.nextFloat();
            totalNumberOfGrades = 0;
            numberOfGrades = 0;
            sum = 0;
            grade = 0;
            break;
          case 2:
            counter = 0;
            System.out.println( "Please enter the number of grades to average:" );
            numberOfGrades = input.nextInt();
            while (counter < numberOfGrades) {
              System.out.println( "Please enter the next grade to average:" );
              grade = input.nextFloat();
              sum = sum + grade;
              counter++;
              }
            totalNumberOfGrades = numberOfGrades + totalNumberOfGrades;
            break;
          case 3:
            average = sum / (float) totalNumberOfGrades;
            totalAvg = totalAvg + (percent * average);
            System.out.println ("Your current average is " + totalAvg );
            totalNumberOfGrades = 0;
            numberOfGrades = 0;
            sum = 0;
            grade = 0;
            break;
          case 4:
            break;
          default:
            System.out.println( "Please choose a correct option." );
            break;
        }
      }
    }
} 

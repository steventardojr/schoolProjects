/**
 * Steven Tardo
 * CSCI 1583 Spring 2014
 * Homework 3
 * February 6, 2014
**/

/* This program will allow the user to enter grades
   to be averaged */

import java.util.Scanner;

public class Homework3
{
  public static void main( String[] args )
  {
    // Initialize a scanner object
    Scanner input = new Scanner( System.in );

    // Declare and initialize variables
    int userChoice = 0;
    String studentFirstName = "";
    String studentLastName = "";
    String studentFullName = "";
    double homeworkGrade = 0;
    double homeworkSum = 0;
    double homeworkAverage = 0;
    int homeworkCounter = 0;
    double quizGrade = 0;
    double quizSum = 0;
    double quizAverage = 0;
    int quizCounter = 0;
    double testGrade = 0;
    double testSum = 0;
    double testAverage = 0;
    int testCounter = 0;
    double finalAverage = 0;

    // Print availble operations to screen and accept user input
    System.out.println( "\nThis program will average a student's grades as follows:" );
    System.out.println( "25% Homework, 25% Quizzes, 50% Tests\n" );
    System.out.println( "Select from one of the following menu options:" );
    System.out.println( "1. Average grades for a new student" );
    System.out.println( "2. Quit" );
    userChoice = input.nextInt();
    while ( userChoice != 1 && userChoice != 2 ) {
      System.out.println( "Menu option not available. Choose a correct option: " );
      userChoice = input.nextInt();
      }
    while ( userChoice == 1 ) {
      System.out.println( "\nPlease enter the student's first name:" );
      studentFirstName = input.next();
      System.out.println( "\nPlease enter the student's last name:" );
      studentLastName = input.next();
      studentFullName = studentFirstName + " " + studentLastName;
      System.out.println( "\nEnter each homework grade then hit Enter" );
      System.out.println( "Enter -1 when complete" );
      while ( homeworkGrade != -1 ) {
        System.out.println( "Grade:" );
        homeworkGrade = input.nextFloat();
        while ( homeworkGrade < -1 ) {
          System.out.println( "Enter a valid number:" );
          homeworkGrade = input.nextFloat();
          }
        homeworkSum = homeworkSum + homeworkGrade;
        homeworkCounter++;
        }
      homeworkCounter--;
      homeworkSum++;
      homeworkAverage = homeworkSum / (double) homeworkCounter;
      System.out.println( "\n" + studentFullName + "'s homework average is " + homeworkAverage + "\n" );
      homeworkSum = 0;
      homeworkGrade = 0;
      homeworkCounter = 0;
      System.out.println( "Enter each quiz grade then hit Enter" );
      System.out.println( "Enter -1 when complete" );
      while ( quizGrade != -1 ) {
        System.out.println( "Grade:" );
        quizGrade = input.nextFloat();
        while ( quizGrade < -1 ) {
          System.out.println( "Enter a valid number:" );
          quizGrade = input.nextFloat();
          }
        quizSum = quizSum + quizGrade;
        quizCounter++;
        }
      quizCounter--;
      quizSum++;
      quizAverage = quizSum / (double) quizCounter;
      System.out.println( "\n" + studentFullName + "'s quiz average is " + quizAverage + "\n" );
      quizSum = 0;
      quizGrade = 0;
      quizCounter = 0;
      System.out.println( "Enter each test grade then hit Enter" );
      System.out.println( "Enter -1 when complete" );
      while ( testGrade != -1 ) {
        System.out.println( "Grade:" );
        testGrade = input.nextFloat();
        while ( testGrade < -1 ) {
          System.out.println( "Enter a valid number:" );
          testGrade = input.nextFloat();
          }
        testSum = testSum + testGrade;
        testCounter++;
        }
      testCounter--;
      testSum++;
      testAverage = testSum / (double) testCounter;
      System.out.println( "\n" + studentFullName + "'s test average is " + testAverage + "\n" );
      testSum = 0;
      testGrade = 0;
      testCounter = 0;
      finalAverage = homeworkAverage * 0.25 + quizAverage * 0.25 + testAverage * 0.5;
      System.out.println( studentFullName + "'s final average is " + finalAverage + "\n" );
      System.out.println( "1. Average grades for a new student" );
      System.out.println( "2. Quit" );
      userChoice = input.nextInt();
      }
  }
} 

/**
 * Steven Tardo
 * CSCI 1583 Spring 2014
 * Homework 4
 * March 11, 2014
**/

/* This program will allow the user to enter grades
   to be averaged */

import java.util.Scanner;
import java.util.ArrayList;

public class Homework4
{
  public static void main(String argv[])
  {
    Scanner input = new Scanner(System.in);
    double userChoice = mainMenu();
    double homeworkAverage = 0.0;
    double quizAverage = 0.0;
    double testAverage = 0.0;
    double totalAverage = 0.0;
    String studentName = "";
    while (userChoice == 1) {
      System.out.println("\nEnter the student's name:");
      studentName = input.nextLine();
      ArrayList<Double> homework = new ArrayList<Double>(homework());
      ArrayList<Double> quiz = new ArrayList<Double>(quiz());
      ArrayList<Double> test = new ArrayList<Double>(test());
      homeworkAverage = average(homework);
      System.out.println("\n" + studentName + "'s homework average is " + homeworkAverage);
      quizAverage = average(quiz);
      System.out.println(studentName + "'s quiz average is " + quizAverage);
      testAverage = average(test);
      System.out.println(studentName + "'s test average is " + testAverage);
      totalAverage = totalAverage(homeworkAverage, quizAverage, testAverage);
      System.out.println(studentName + "'s overall average is " + totalAverage);
      userChoice = mainMenu();
    }
  }

  public static int mainMenu()
  {
    Scanner input = new Scanner( System.in );
    System.out.println( "\nThis program will average a student's grades as follows:" );
    System.out.println( "25% Homework, 25% Quizzes, 50% Tests\n" );
    System.out.println( "Select from one of the following menu options:" );
    System.out.println( "1. Average grades for a new student" );
    System.out.println( "2. Quit" );
    int userChoice = input.nextInt();
    while ( userChoice != 1 && userChoice != 2 ) {
      System.out.println( "Menu option not available. Choose a correct option: " );
      userChoice = input.nextInt();
      }
    return userChoice;
  }

  public static ArrayList homework()
  {
    Scanner input = new Scanner(System.in);
    ArrayList<Double> homeworkGrade = new ArrayList<Double>();
    double userInput = 0.0;
    System.out.println("\nEnter a homework grade then press enter. When finished enter -1.");
    while (userInput != -1) {
      userInput = input.nextDouble();
      while (userInput < -1) {
        System.out.println("Enter a valid grade.");
        userInput = input.nextDouble();
      }
      homeworkGrade.add(userInput);
    }
    return homeworkGrade;
  }

  public static ArrayList quiz()
  {
    Scanner input = new Scanner(System.in);
    ArrayList<Double> quizGrade = new ArrayList<Double>();
    double userInput = 0.0;
    System.out.println("\nEnter a quiz grade then press enter. When finished enter -1.");
    while (userInput != -1) {
      userInput = input.nextDouble();
      while (userInput < -1) {
        System.out.println("Enter a valid grade.");
        userInput = input.nextDouble();
      }
      quizGrade.add(userInput);
    }
    return quizGrade;
  }

  public static ArrayList test()
  {
    Scanner input = new Scanner(System.in);
    ArrayList<Double> testGrade = new ArrayList<Double>();
    double userInput = 0.0;
    System.out.println("\nEnter a test grade then press enter. When finished enter -1.");
    while (userInput != -1) {
      userInput = input.nextDouble();
      while (userInput < -1) {
        System.out.println("Enter a valid grade.");
        userInput = input.nextDouble();
      }
      testGrade.add(userInput);
    }
    return testGrade;
  }

  public static double average(ArrayList<Double> averageGrade)
  {
    int i = 0;
    double averageTotal = 0.0;
    double averageSum = 0.0;
    while (i < averageGrade.size()) {
      averageSum = averageGrade.get(i);
      averageTotal += averageSum;
      i++;
    }
    double average = (averageTotal + 1) / (double) (averageGrade.size() - 1);
    return average;
  }

  public static double totalAverage(double homeworkAverage, double quizAverage, double testAverage)
  {
    double totalAverage = (0.25*homeworkAverage) + (0.25*quizAverage) + (0.5*testAverage);
    return totalAverage;
  }
} 

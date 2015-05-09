/**
 * Steven Tardo
 * CSCI 1583 Spring 2014
 * Homework 2
 * January 24, 2014
**/

/* This program is a simple calculator. It will prompt the user
   to choose an operation and two numbers. The program will
   use the input to perform the correct operation then print
   the output to the display. */

import java.util.Scanner;

public class Homework2
{
  public static void main( String[] args )
  {
    // Initialize a scanner object
    Scanner input = new Scanner( System.in );

    // Declare and initialize variables
    double number1 = 1;
    double number2 = 1;
    double answer = 1;
    int operation = 1;

    // Print availble operations to screen and accept user input
    System.out.println( "This program is a simple calculator." );
    System.out.println( "When prompted, choose an operation and enter two numbers." );

    // Ask user for two numbers and accept user input
    while ( operation != -1 ) {
      System.out.println( "Select from one of the following operations:" );
      System.out.println( "1 for addition\n2 for subtraction\n3 for multiplication" );
      System.out.println( "4 for division\nor 5 for modulus/remainder" );
      operation = input.nextInt();
      System.out.println( "Enter a number:" );
      number1 = input.nextDouble();
      System.out.println( "Enter a second number:" );
      number2 = input.nextDouble();

      // Use if control structure to display correct operation and answer
      if ( operation == 1 ) {
        answer = number1 + number2;
        System.out.println( number1 + " + " + number2 + " = " + answer );
        }
      else if ( operation == 2 ) {
        answer = number1 - number2;
        System.out.println( number1 + " - " + number2 + " = " + answer );
        }
      else if ( operation == 3 ) {
        answer = number1 * number2;
        System.out.println( number1 + " * " + number2 + " = " + answer );
        }
      else if ( operation == 4 ) {
        answer = number1 / number2;
        System.out.println( number1 + " / " + number2 + " = " + answer );
        }
      else if ( operation == 5 ) {
        answer = number1 % number2;
        System.out.println( "The remainder of " + number1 + " / " + number2 + " = " + answer );
        }
      else
        System.out.println( "There appears to be a problem with your choice of operation." );
      System.out.println( "To perform another operation, enter 0" );
      System.out.println( "To quit the program, enter -1:" );
      operation = input.nextInt();
    }  
  }
} 

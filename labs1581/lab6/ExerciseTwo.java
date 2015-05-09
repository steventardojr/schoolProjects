/**
 * Exercise Two
 * Lab Six
 **/

import java.util.Scanner;

public class ExerciseTwo
{
  public static void main( String[] argv )
  {
    Scanner input = new Scanner(System.in);
    String[] binaryVersion = {"0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000"};
    int number_given = 0;
    while (number_given >= 0 && number_given <= 8) {
        System.out.println("Pick a number from 0 to 8 to see it's 4 bit binary representation:");
        number_given = input.nextInt();
        System.out.println("The number " + number_given + " is " + binaryVersion[number_given] + " in binary");
    }
  }
}

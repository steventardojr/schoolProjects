/**
 * Exercise Three
 * Lab Six
 **/

import java.util.Scanner;

public class ExerciseThree
{
  public static void main( String[] argv )
  {
    Scanner input = new Scanner(System.in);
    int[] array1 = new int[3];
    int[] array2 = new int[3];
    System.out.println("This program will calculate the dot product of two vectors");
    System.out.println("The first three values will be the first vector, and the second three values will be the second vector");
    for (int i = 0; i < 3; i++) {
      System.out.println("Enter an integer:");
      array1[i] = input.nextInt();
    }
    for (int i = 0; i < 3; i++) {
      System.out.println("Enter an integer:");
      array2[i] = input.nextInt();
    }
    int sum = dotProduct(array1, array2);
    System.out.println("The dot product of the two arrays is " + sum);
  }

  public static int dotProduct(int firstArray[], int secondArray[])
  {
    int sum = 0;
    for (int i = 0; i < 3; i++) {
      int multiply = firstArray[i] * secondArray[i];
      sum = sum + multiply;
    }
    return sum;
  }
}

/**
 * Exercise Five
 * Lab Six
 **/

import java.util.Scanner;

public class ExerciseFive
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int[] array1 = new int[3];
    int[] array2 = new int[3];
    if (args.length != 6)
      System.out.println("Invalid number of arguments");
    for (int i = 0; i < 3; i++) {
      array1[i] = Integer.parseInt(args[i]);
      array2[i] = Integer.parseInt(args[i+3]);
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

/**
 * Exercise One
 * Lab Six
 **/

import java.util.Scanner;
import java.util.Random;

public class ExerciseOne
{
  public static void main( String[] argv )
  {
    Scanner input = new Scanner(System.in);
    Random generator = new Random();
    int[] array1 = new int[10];
    for (int i = 0; i < 10; i++) {
      array1[i] = generator.nextInt();
      System.out.println(array1[i]);
    }
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    int j = 0 + generator.nextInt(11);
    System.out.println(months[j]);
  }
}

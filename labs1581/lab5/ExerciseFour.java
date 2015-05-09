/**
 * Exercise Four
 * Lab Five
 **/

import java.util.Scanner;
import java.util.Random;

public class ExerciseFour
{
  public static void main( String[] argv )
  {
    Scanner input = new Scanner(System.in);
    Random generator = new Random();
    System.out.println("Pick the number of points to use to approximate pi:");
    int userInput = input.nextInt();
    double actualPiApprox = piApprox(generator, userInput);
    System.out.println("Pi is approximately " + actualPiApprox);
  }

  public static double piApprox(Random pi, int totalNumber)
  {
    int totalPoints = 0;
    int i = 1;
    double actualApprox = 0;
    while (i <= totalNumber)
    {
      double x=pi.nextDouble();
      double y=pi.nextDouble();
      if ((x*x)+(y*y) <= 1)
        totalPoints++;
      i++;
    }
    actualApprox = (((double) totalPoints) / ((double) totalNumber) * 4);
    return actualApprox;
  }
}

/**
 * Exercise Five
 * Lab Five
 **/

import java.util.Scanner;
import java.util.Random;

public class ExerciseFive
{
  public static void main( String[] argv )
  {
    Scanner input = new Scanner(System.in);
    Random generator = new Random();
    System.out.println("Pick from the following menu items");
    System.out.println("1. Approximate pi using random numbers");
    System.out.println("2. Approximate pi using Taylor series");
    int userInput = input.nextInt();
    double actualPiApprox = 0;
    switch (userInput)
    {
      case 1:
        System.out.println("Pick the number of points to approximate pi:");
        int userInput1 = input.nextInt();
        actualPiApprox = piApprox(generator, userInput1);
        System.out.println("Pi is approximately " + actualPiApprox);
        break;
      case 2:
        System.out.println("Pick the number of points to approximate pi:");
        int userInput2 = input.nextInt();
        actualPiApprox = piApprox(userInput2);
        System.out.println("Pi is approximately " + actualPiApprox);
        break;
      default:
        System.out.println("Invalid menu selection");
        break;
    }
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

  public static double piApprox(int totalNumberOfPoints)
  {
    double i = 3;
    double series = 1;
    while (i <= totalNumberOfPoints)
    {
      series = series - (1 / i) + (1 / (i + 2));
      i=i+4;
    }
    double actualApprox = 4 * series;
    return actualApprox;
  }
}

/**
 * Exercise One
 * Lab Eight
 **/

import java.util.Scanner;

public class ExerciseOne
{
  public static void main(String[] args)
  {
    Scanner input = new Scanner(System.in);
    int num1 = 0;
    int num2 = 0;
    int den1 = 1;
    int den2 = 1;
    int userInput = 1;
    while (userInput != 0)
    {
      System.out.println("Choose from one of the following operations to perform on fractions:");
      System.out.println("1. Add");
      System.out.println("2. Subtract");
      System.out.println("3. Multiply");
      System.out.println("4. Divide");
      userInput = input.nextInt();
      System.out.println("Enter the numerator for the first fraction:");
      num1 = input.nextInt();
      System.out.println("Enter the denominator for the first fraction (nonzero):");
      den1 = input.nextInt();
      while (den1 == 0)
      {
        System.out.println("Enter a nonzero integer:");
        den1 = input.nextInt();
      }
      System.out.println("Enter the numerator for the second fraction:");
      num2 = input.nextInt();
      System.out.println("Enter the denominator for the second fraction (nonzero):");
      den2 = input.nextInt();
      while (den2 == 0)
      {
        System.out.println("Enter a nonzero integer:");
        den2 = input.nextInt();
      }
      Fraction f1 = new Fraction(num1, den1);
      Fraction f2 = new Fraction(num2, den2);
      Fraction f3;      
      switch (userInput)
      {
        case 1:
          f3 = f1.add(f2);
          System.out.println(f3.toString());
          break;
        case 2:
          f3 = f1.subtract(f2);
          System.out.println(f3.toString());
          break;
        case 3:
          f3 = f1.multiply(f2);
          System.out.println(f3.toString());
          break;
        case 4:
          f3 = f1.divide(f2);
          System.out.println(f3.toString());
          break;
        case 0:
          break;
        default:
          break;
      }
      System.out.println("To run again, enter 1");
      System.out.println("To exit, enter 0");
      userInput = input.nextInt();
    }
  }
}

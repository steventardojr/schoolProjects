/**
 * Exercise Two
 * Lab Five
 **/

import java.util.Scanner;

public class ExerciseTwo
{
  public static void main( String[] argsv )
  {
    Scanner input = new Scanner(System.in);
    double test = 1;
    int userChoice = 1;
    int x = 1;
    float temp=fToC(test);
    while (userChoice < 3 && userChoice > 0)
    {
      userChoice=choice(x);
      switch (userChoice)
      {
      case 1:
        System.out.print("Enter a temperature in Fahrenheit: ");
        float fahrenheit=input.nextFloat();
        float celsius=fToC(fahrenheit);
        System.out.println("The temperature in Celsius is " + celsius + "\n");
        break;
      case 2:
        System.out.print("Enter a temperature in Celsius: ");
        celsius=input.nextFloat();
        fahrenheit=cToF(celsius);
        System.out.println("The temperature in Fahrenheit is " + fahrenheit + "\n");
        break;
      case 3:
        break;
      default:
        System.out.println("Invalid choice");
        break;
      }
    }
  }

  public static float fToC(float fahrenheit)
  {
   float celsius=(fahrenheit-32)*5/9;
   return celsius; 
  }

  public static float cToF(float celsius)
  {
    float fahrenheit=celsius*9/5+32;
    return fahrenheit;
  }

  public static int choice(int userChoice)
  {
    Scanner input=new Scanner(System.in);
    System.out.println("Pick from the following choices:");
    System.out.println("1. Convert Fahrenheit to Celsius");
    System.out.println("2. Convert Celsius to Fahrenheit");
    System.out.println("3. Quit");
    userChoice = input.nextInt();
    return userChoice;
  }
} 

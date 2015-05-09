/**
 * Exercise Two
 * Lab Thirteen
 **/

import java.util.*;
import java.lang.*;

public class ExerciseTwo
{
  public static void main(String[] args)
  {
    Scanner sc1 = new Scanner(System.in);
    String test = "This is a test string";
    System.out.println("This is the string before modification:");
    System.out.println(test + "\n");
    stringModifier(test);
    System.out.println("This is the string after modification:");
    System.out.println(test + "\n");
    StringBuilder testString = new StringBuilder(test);
    System.out.println("This is the StringBuilder before modification:");
    System.out.println(testString + "\n");
    stringModifier(testString);
    System.out.println("This is the StringBuilder after modification:");
    System.out.println(testString + "\n");
  }

  public static void stringModifier(String text) {
    text = text.concat(" that has been modified.");
    System.out.println("This is the string in the string stringModifier method:");
    System.out.println(text + "\n");
  }

  public static void stringModifier(StringBuilder text) {
    text = text.append(" that has been modified.");
    System.out.println("This is the string in the StringBuilder stringModifier method:");
    System.out.println(text + "\n");
  }
}

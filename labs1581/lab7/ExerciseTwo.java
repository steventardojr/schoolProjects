/**
 * Exercise Two
 * Lab Seven
 **/

import java.util.Scanner;
import java.util.Formatter;
import java.io.*;

public class ExerciseTwo
{
  public static void main(String[] args) throws FileNotFoundException
  {
    File declarationInput = new File("declaration.txt");
    Scanner input = new Scanner(declarationInput);
    String declarationCheck = "";
    String firstSentence = "";
    int declarationIndex = 0;
    declarationCheck = input.nextLine();
    firstSentence = declarationCheck;
    while (declarationIndex <= 0) {
      declarationCheck = input.nextLine();
      firstSentence = firstSentence + "\n" + declarationCheck;
      declarationIndex = firstSentence.indexOf(".");
    }
    declarationIndex++;
    firstSentence = firstSentence.substring(0, declarationIndex);
    File declarationOutput = new File("sentence.txt");
    Formatter output = new Formatter(declarationOutput);
    output.format(firstSentence);
    input.close();
    output.close();
  }
}

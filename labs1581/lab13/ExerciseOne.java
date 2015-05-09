/**
 * Exercise One
 * Lab Thirteen
 **/

import java.util.*;
import java.io.*;

public class ExerciseOne
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

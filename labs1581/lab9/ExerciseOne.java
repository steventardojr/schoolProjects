/**
 * Exercise One
 * Lab Nine
 **/

import java.util.*;

public class ExerciseOne
{
  public static void main(String[] args)
  {
    Scanner sc1 = new Scanner(System.in);
    Scanner sc2 = new Scanner(System.in);
    int userInput = 1;
    String userString = "";
    int userSize = 0;
    int userIndex = 0;
    DynamicArray userArray = new DynamicArray();
    while (userInput != 0) {
      System.out.println("\nSelect from one of the following menu items:");
      System.out.println("1. Create a dynamic array of default size");
      System.out.println("2. Create a dynamic array of specified size");
      System.out.println("3. Create a static array");
      System.out.println("0. Quit");
      userInput = sc1.nextInt();
      while (userInput < 1 && userInput > 4) {
        System.out.println("Menu selection invalid. Enter correct option");
        userInput = sc1.nextInt();
      }
      if (userInput == 1) {
        userArray = new DynamicArray();
      }
      else if (userInput == 2) {
        System.out.println("\nSelect a size for the array");
        userSize = sc1.nextInt();
        userArray = new DynamicArray(userSize);
      }
      else if (userInput == 3) {
        System.out.println("\nEnter the size of the array");
        userIndex = sc1.nextInt();
        String[] userStringArray = new String[userIndex];
        for (int i = 0; i < userIndex; i++) {
          System.out.println("Enter a string");
          userStringArray[i] = sc2.nextLine();
        }
        userArray = new DynamicArray(userStringArray);
      }
      while (userInput != 7 && userInput !=0) {
        System.out.println("\nSelect from one of the following menu items:");
        System.out.println("1. Add a string to the end of the array");
        System.out.println("2. Add a string to a specific point in the array");
        System.out.println("3. Remove a string from the array");
        System.out.println("4. Retrieve a string from the array");
        System.out.println("5. Check to see if the array is empty");
        System.out.println("6. Check the size of the array");
        System.out.println("7. Return to the main menu");
        userInput = sc1.nextInt();
        while (userInput < 1 && userInput > 7) {
          System.out.println("Menu selection invalid. Enter correct option");
          userInput = sc1.nextInt();
        }
        switch (userInput) {
          case 1:
            System.out.println("\nEnter a string to add to the array");
            userString = sc2.nextLine();
            userArray.add(userString);
            break;
          case 2:
            System.out.println("\nEnter the index at which to add the string");
            System.out.println("CAUTION: The current element at this index will be overwritten!");
            userIndex = sc1.nextInt();
            System.out.println("\nEnter a string to add to the array");
            userString = sc2.nextLine();
            userArray.add(userString, userIndex);
            break;
          case 3:
            System.out.println("\nEnter the index at which to remove the string");
            userIndex = sc1.nextInt();
            userArray.remove(userIndex);
            break;
          case 4:
            System.out.println("\nEnter the index at which to show the string");
            userIndex = sc1.nextInt();
            System.out.println(userArray.get(userIndex));
            break;
          case 5:
            if (userArray.isEmpty() == true)
              System.out.println("\nThe array is empty");
            else
              System.out.println("\nThe array is not empty");
            break;
          case 6:
            System.out.println("\nThe size of the array is " + userArray.sizeOf());
            break;
          case 7:
            break;
          default:
            break;
        }
      }
    }
  }
}

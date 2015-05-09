/**
 * Steven Tardo
 * CSCI 2125, Spring 2015
 * 3 February 2015
 * Homework 1, An implementation of the Java class ArrayList
 * This class shows the functionality of the different methods
 * of the MyArrayList class.
 */

public class Startup {
    public static void main(String[] args) {
        //Create new MyArrayList
        MyArrayList newList = new MyArrayList();

        // Show that current size is 0
        System.out.println("Current size is " + newList.size() + "\n");

        // Add the integer 0 and show the new size
        int test0 = 0;
        newList.add(test0);
        System.out.println("Add the integer 0 to the ArrayList");
        System.out.println("Current size is " + newList.size() + "\n");

        // Add the integer 1 and show the new size
        int test1 = 1;
        newList.add(test1);
        System.out.println("Add the integer 1 to the ArrayList");
        System.out.println("Current size is " + newList.size() + "\n");

        // Add the integer 2 and show the new size
        int test2 = 2;
        newList.add(test2);
        System.out.println("Add the integer 2 to the ArrayList");
        System.out.println("Current size is " + newList.size() + "\n");

        // Add the integer 3 and show the new size
        int test3 = 3;
        newList.add(test3);
        System.out.println("Add the integer 3 to the ArrayList");
        System.out.println("Current size is " + newList.size() + "\n");

        // Show the MyArrayList with toString() method
        String output = newList.toString();
        System.out.println("The output of the ArrayList is: " + output + "\n");

        // Remove the integer 0, show the new size and MyArrayList
        newList.remove(0);
        System.out.println("Remove the integer 0 from the ArrayList");
        System.out.println("Current size is " + newList.size());
        output = newList.toString();
        System.out.println("The output of the ArrayList is: " + output + "\n");

        // Remove the integer 3, show the new size and MyArrayList
        newList.remove(2);
        System.out.println("Remove the integer 3 from the ArrayList");
        System.out.println("Current size is " + newList.size());
        output = newList.toString();
        System.out.println("The output of the ArrayList is: " + output + "\n");

        // Remove the integer 2, show the new size and MyArrayList
        newList.remove(1);
        System.out.println("Remove the integer 2 from the ArrayList");
        System.out.println("Current size is " + newList.size());
        output = newList.toString();
        System.out.println("The output of the ArrayList is: " + output + "\n");

        // Remove the integer 1, show the new size and MyArrayList
        newList.remove(0);
        System.out.println("Remove the integer 1 from the ArrayList");
        System.out.println("Current size is " + newList.size());
        output = newList.toString();
        System.out.println("The output of the ArrayList is: " + output);
    }
}
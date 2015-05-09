import java.util.*;

/**
 * Steven Tardo
 * CSCI 2125, Spring 2015
 * 18 February 2015
 * Homework 2, An implementation of a singly linked list
 * This class is the starting place for demonstration of the capabilites
 * of the SinglyLinkedList class.
 */

public class Startup {
	// Main method
	public static void main(String[] args) {
		/**
		 * Declare and initialize and instance of the SinglyLinkedList class
		 * with Integer as the type parameter
		 */
		SinglyLinkedList<Integer> myLinkedList = new SinglyLinkedList<Integer>();
		
		// Add the Integers from 1 to 10 in order to the list
		myLinkedList.add(1);
		myLinkedList.add(2);
		myLinkedList.add(3);
		myLinkedList.add(4);
		myLinkedList.add(5);
		myLinkedList.add(6);
		myLinkedList.add(7);
		myLinkedList.add(8);
		myLinkedList.add(9);
		myLinkedList.add(10);
		
		/**
		 * Print out size of list after addding ten elements and using
		 * Java 6 for-each loop print out each element in the list
		 * by iterating over the list
		 */
		System.out.println("Size after add: " + myLinkedList.size());
		System.out.print("List after add: ");
		for (Integer item: myLinkedList)
			System.out.print(item + " ");
		System.out.println();

		/**
		 * Print out size of list after removing four elements and using
		 * Java 6 for-each loop print out each element in the list
		 * by iterating over the list
		 */
		myLinkedList.remove(1);
		myLinkedList.remove(2);
		myLinkedList.remove(10);
		myLinkedList.remove(9);
		System.out.println("Size after remove: " + myLinkedList.size());
		System.out.print("List after remove: ");
		for (Integer item: myLinkedList)
			System.out.print(item + " ");
		System.out.println();
	}
}
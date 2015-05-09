import junit.framework.TestCase;
import java.util.*;

/**
 * Steven Tardo
 * CSCI 2120, Fall 2014
 * Homework 4
**/

public class BinaryTreeTraversalTest extends TestCase {
	private ArrayList<Integer> arrayToTest = new ArrayList<Integer>();
	
	// Test arrayToBinaryTree method
	public void testArrayToBinaryTree() {
		arrayToTest.add(0);
		arrayToTest.add(1);
		arrayToTest.add(2);
		BinaryTree binaryTreeToTest = BinaryTreeTraversal.arrayToBinaryTree(arrayToTest);
		assertTrue(binaryTreeToTest.getData() == 0);
	}
	
}
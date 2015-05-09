import junit.framework.TestCase;

/**
 * Steven Tardo
 * CSCI 2120, Fall 2014
 * Homework 4
**/

public class BinaryTreeTest extends TestCase {
	private BinaryTree binaryTreeToTest = new BinaryTree(0);

	/** Test the default constructor to be sure the root has
		the correct value
	**/
	public void testConstructor() {
		assertTrue(binaryTreeToTest.getData() == 0);
	}
	
	/** Test the inOrder method to be sure the method
		behaves correctly with just a root
	**/
	public void testInOrder() {
		binaryTreeToTest.inOrder(binaryTreeToTest);
		assertTrue(binaryTreeToTest.getData() == 0);
	}
	
	// Test the insert and inOrder methods to be sure they behave correctly
	public void testInsertAndInOrder() {
		binaryTreeToTest = new BinaryTree(0);
		binaryTreeToTest.insert(-1);
		binaryTreeToTest.insert(-2);
		binaryTreeToTest.insert(2);
		binaryTreeToTest.insert(1);
		binaryTreeToTest.inOrder(binaryTreeToTest);
		assertTrue(binaryTreeToTest.getData() == 0);
	}

}
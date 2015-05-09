import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import java.lang.ClassNotFoundException;

/**
 * Steven Tardo
 * CSCI 2120, Fall 2014
 * Homework 4
**/

public class BinaryTreeTraversal {
	public static void main(String[] args) {
        
		// Create and initialize variables
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> toBinaryTree = new ArrayList<Integer>();
		ObjectInputStream reader = null;
		
		// Prompt the user to enter the name of the serailized file
		System.out.println("Enter the name of the serialized file:");
		String userInput = sc.next();
		
		// Deserialize the file and place its contents into an ArrayList
		try
		{
			reader = new ObjectInputStream( new FileInputStream( userInput ) );
			toBinaryTree  = ( ArrayList<Integer> ) reader.readObject();
			reader.close();
		}
		catch( IOException e )
		{
			System.out.println( "Couldn't read serialized file" );
		}
		catch( ClassNotFoundException e )
		{
			System.out.println( "Couldn't find class" );
		}
		
		// Place the contents of the ArrayList into a BinaryTree object
		// and print the integers in sorted order using in order traversal
		BinaryTree binaryTreeToSort = arrayToBinaryTree(toBinaryTree);
		binaryTreeToSort.inOrder(binaryTreeToSort);
		
	}
	
	// This method will iterate over the ArrayList and place each value
	// in a BinaryTree object
	public static BinaryTree arrayToBinaryTree(ArrayList<Integer> toBinaryTree) {
		BinaryTree treeToSort = new BinaryTree(toBinaryTree.get(0));
		for (int i = 1; i<toBinaryTree.size(); i++) {
			treeToSort.insert(toBinaryTree.get(i));
		}
		return treeToSort;
	}
	
}
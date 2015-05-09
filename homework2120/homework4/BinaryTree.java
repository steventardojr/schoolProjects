/**
 * Steven Tardo
 * CSCI 2120, Fall 2014
 * Homework 4
**/

/**
* Class implementing a binary tree
* with in order traversal
**/
public class BinaryTree
{

	// Instance variables
	private int data;
	private BinaryTree leftSubtree;
	private BinaryTree rightSubtree;

	/** Constructor:
	* Parameters: int value contains the data being stored
	* BinaryTree instance variables do not contain sub-trees
	* initially, so they are set to null.
	**/
	public BinaryTree( int value )
	{
		this.data = value;
		this.leftSubtree = null;
		this.rightSubtree = null;
	}

	/**
	* Returns the value stored in this node
	**/
	public int getData()
	{
		return this.data;
	}

	/**
	* Method insert, adds a value to the tree
	* Parameters: int value contains the value to be added
	**/
	public void insert( int value )
	{
		if (value<this.data) {
			if (leftSubtree != null)
				leftSubtree.insert(value);
			else
				leftSubtree = new BinaryTree(value);
		}
		else {
			if (rightSubtree != null)
				rightSubtree.insert(value);
			else
				rightSubtree = new BinaryTree(value);
		}
	}

	/**
	* Method inOrder traverses the tree following the in order
	* traversal algorithm. When each node is ‘visited’ by the
	* algorithm print the value at that node to the screen
	**/

	public void inOrder(BinaryTree root)
	{
		if (root != null) {
			root.inOrder(root.leftSubtree);
			System.out.println(root.getData());
			root.inOrder(root.rightSubtree);
		}
	}

}
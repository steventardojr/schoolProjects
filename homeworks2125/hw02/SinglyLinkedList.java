import java.util.*;

/**
 * Steven Tardo
 * CSCI 2125, Spring 2015
 * 18 February 2015
 * Homework 2, An implementation of a singly linked list
 * This class is an implementation of a singly linked list.
 * Contained inside are two inner classes: a static Node class
 * that keeps track of each element, and an Iterator class
 * that iterates over the list.
 */

public class SinglyLinkedList<T> implements Iterable<T> {
	// Instance Variables
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	// Constructor
	public SinglyLinkedList() {
		this.head = null;
		this.tail = null;
		this.size = 0;
	}
	
    /**
     * @param data - The generic value to be added to the list
     *
     * This method adds an element to the end of the list.
     */
	public void add(T data) {
		Node<T> newNode = new Node<T>(data);
		
		// If list is empty
		if (this.head == null) {
			this.head = newNode;
			this.tail = newNode;
		}
		// If list contains at least one element
		else {
			Node<T> currentNode = this.tail;
			this.tail = newNode;
			currentNode.setNext(newNode);
		}
		
		this.size++;
	}
	
    /**
     * This method adds a generic value at the specified index.
	 * If the given index is invalid, an IndexOutOfBoundsException is thrown.
     * @param element - The generic value to be added to the list
	 * @param index - The index at which to add data 
     */
	public void insertAt(T element, int index) {
		Node<T> newNode = new Node<T>(element);
		
		// Throw exception if index is invalid
		if (this.size == 0 || index > size || index < 0)
			throw new IndexOutOfBoundsException();
		// Add element to list
		else {
			Node<T> previousNode = this.head;
			for (int i = 0; i < index - 1; i++) {
				previousNode = previousNode.getNext();
			}
			Node<T> nextNode = this.head;
			for (int i = 0; i < index; i++) {
				nextNode = nextNode.getNext();
			}
	
			previousNode.setNext(newNode);
			newNode.setNext(nextNode);
			size++;
		}
	}
	
    /**
     * @param element - generic value to be removed
     *
     * This method removes the first instance of the element
	 * passed to the method.
	 * If the list is empty or the element is not found,
	 * a NoSuchElementException is thrown
     */
	public void remove (T element) {
		// Throw exception if list is empty
		if (this.size == 0)
			throw new NoSuchElementException();
			
		Node<T> currentNode = this.head;
		Node<T> nextNode = this.head.getNext();
		boolean elementFound = false;
		
		// Check if first element in list matches
		if (this.head.getData() == element) {
			this.head = nextNode;
			size--;
			elementFound = true;
		}
		
		// Check each element in the list up to the last element
		int i = 0;
		while (elementFound == false && i < this.size - 1) {
			if (nextNode.getData() == element) {
				currentNode.setNext(nextNode.getNext());
				size--;
				elementFound = true;
			}
			i++;
			currentNode = nextNode;
			nextNode = currentNode.getNext();
		}

		// Check if last element matches
		if (elementFound == false && currentNode.getData() == element) {
			this.tail = currentNode;
			size--;
		}
		
		// Throw exception if element isn't in list
		if (elementFound == false)
			throw new NoSuchElementException();
	}
	
    /**
     * This method resets the list to its original state.
     */
	public void clear() {
		this.head = this.tail =  null;
		this.size = 0;
	}
	
	/**
	 * @return isEmpty - boolean value that is true if the list is empty
	 * and false if the list has at least one value
	 *
	 * This method checks to see if the list is empty.
	 */
	public boolean isEmpty() {
		boolean isEmpty = true;
		if (this.size > 0)
			isEmpty = false;
		return isEmpty; 
	}
	
	/**
	 * @return this.size - the size of the list
	 *
	 * This method returns the size of the list.
	 */
	public int size() {
		return this.size;
	}
	
	/**
	 * @param index - the index at which to add a generic value
	 * starting from the beginning of the list
	 *
	 * @return data - the element found at index
	 * 
	 * This method will return the element found at the specified
	 * index starting from the beginning of the list
	 */
	public T getNthFromFirst(int index) {
		T data = null;
		
		// Throw exception if index is invalid
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index invalid");
		
		// Get element at index
		Node<T> currentNode = this.head;
		for (int i = 0; i < size; i++) {
			if (i == index)
				data = currentNode.getData();
			else {
				if (currentNode == this.tail)
					data = this.tail.getData();
				else
					currentNode = currentNode.getNext();
			}
		}
		return data;
	}
	
	/**
	 * @param index - the index at which to add a generic value
	 * starting from the end of the list
	 *
	 * @return data - the element found at index
	 * 
	 * This method will return the element found at the specified
	 * index starting from the end of the list
	 */
	public T getNthFromLast(int index) {
		T data = null;
		
		index = size - 1 - index; // Change index to start at end of list
		
		// Throw exception if index is invalid
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index invalid");
		
		// Get element at index
		Node<T> currentNode = this.head;
		for (int i = 0; i < size; i++) {
			if (i == index)
				data = currentNode.getData();
			else {
				if (currentNode == this.tail)
					data = this.tail.getData();
				else
					currentNode = currentNode.getNext();
			}
		}
		return data;
	}
	
	/**
	 * @return SinglyLinkedListIterator() - an iterator for the list
	 * 
	 * This method returns an iterator from the list
	 * The iterator is implemented as a subclass of the list
	 */
	public SinglyLinkedListIterator iterator() {
		return new SinglyLinkedListIterator();
	}
	
	/**
	 * @return data - a String representation of the data in the list
	 * 
	 * This method will return a String that contains each element in the list
	 * followed by a space
	 */
	public String toString() {
		Node<T> printNode = this.head;
		
		// Create String and add first element
		String data = printNode.getData().toString();
		
		// Add each additional elemtn to String
		for (int i = 1; i < size; i++) {
			printNode = printNode.getNext();
			data += " " + printNode.getData().toString();
		}
		return data;
	}
	
	
	// The following class implements a container for each element in the list
	private static class Node<T> {
		// Instance variables
		private T data;
		private Node<T> next;
	
		/**
		 * @param data - the generic value to be added to the list
		 *
		 * Constructor
		 */
		public Node(T data) {
			this.data = data;
			this.next = null;
		}
	
		/**
		 * @param next - the element in the list following the current element
		 *
		 * This method sets the element following the current element in the list
		 */
		public void setNext(Node<T> next) {
			this.next = next;
		}
	
		/**
		 * @return this.next - the next element in the list
		 * 
		 * This method returns the element following the current element in the list
		 */
		public Node<T> getNext() {
			return this.next;
		}
	
		/**
		 * @return this.data - the generic value in the list
		 *
		 * This method returns the current generic value in the list
		 */
		public T getData() {
			return this.data;
		}
	}
	
	// The method implements the Iterator interface to iterate through the list
	public class SinglyLinkedListIterator implements Iterator<T> {
		// Instance variable
		private Node<T> current;
	
		// Constructor
		public SinglyLinkedListIterator() {
			current = head;
		}

		/**
		 * @return value - the current generic value in the list
		 *
		 * This method gets the generic value stored at spot in the list
		 */
		public T next() {
			// Throw exception if the end of the list has been reached
			if (hasNext() == false)
				throw new NoSuchElementException();
			
			// Return next value in list
			T value = current.getData();
			current = current.getNext();
			return value;
		}
		
		/**
		 * @return hasNext - returns true if there is a next value in the list
		 * and false if the end of the list has been reached
		 *
		 * This method is used to determine if the end of the list has been reached
		 */
		public boolean hasNext() {
			boolean hasNext = true;
			if (current == null)
				hasNext = false;
			return hasNext;
		}
		
		/**
		 * This method is not supported in this implementation of the iterator
		 * and thus throws an UnsupportedOperationException if called
		 */
		public void remove () {
			throw new UnsupportedOperationException("The remove operation is not supported by this iterator");
		}
	}
}


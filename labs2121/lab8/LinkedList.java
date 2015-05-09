/** Steven Tardo
	CSCI 2121, Fall 2014
	Lab 8
**/

public class LinkedList<Element> {
	// Instance variables
	int size;
	Node<Element> head;
	Node<Element> current;
	Node<Element> tail;
	
	public LinkedList() {
		this.size = 0;
		this.head = null;
		this.current = null;
		this.tail = null;
	}
	
	/**
	  * Reimplemented insert method as it was
	  * previously inserting backwards
	**/
		
	public void insert(Element item) {
		Node<Element> newNode = new Node<Element>(item);
		if (this.size == 0) {
			this.head = newNode;
			this.tail = newNode;
			this.current = newNode;
		}
		else {
			this.current = this.head;
			while (this.current.getNext() != null)
				this.current = this.current.getNext();
			this.current.setNext(newNode);
		}
		this.size++;
	}
	
	/**
	  * @require this.size() != 0
	  * @ensure returns null if at end of list
	**/
	public void next() {
		if (this.current != null) {
			this.current = this.current.getNext();
		}
	}
	
	/**
	  * @require index < this.size()
	  * @require index >= 0	
	*/
	public Element get(int index) {
		int count = 0;
		this.current = this.head;
		while (count < index) {
			this.next();
			count++;
		}
		return this.current.getData();
	}
	
	public void remove(int index) {
		int count = 0;
		this.current = this.head;
		while (count < index -1) {
			this.next();
			count++;
		}
		Node<Element> temp = this.current.getNext();
		this.current.setNext(this.current.getNext().getNext());
		temp.setNext(null);
		this.size--;
	}
	
	// Implemented isEmpty and reset
	public Boolean isEmpty() {
		if (this.size == 0)
			return true;
		return false;
	}
	
	public void reset() {
		this.size = 0;
		this.head = null;
		this.current = null;
		this.tail = null;
	}
}
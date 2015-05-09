/** Steven Tardo
	CSCI 2121, Fall 2014
	Lab 8
**/

public class Node<Element> {
	// Instance Variables
	Element data;
	Node<Element> next;
	
	public Node(Element data) {
		this.data = data;
		this.next = null;
	}
	
	public Element getData() {
		return data;
	}
	
	public Node<Element> getNext() {
		return next;
	}
	
	public void setNext(Node<Element> next) {
		this.next = next;
	}
}
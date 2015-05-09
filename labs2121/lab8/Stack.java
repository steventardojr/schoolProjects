import java.util.*;

/** Steven Tardo
	CSCI 2121, Fall 2014
	Lab 8
**/

public class Stack<T> {
	private ArrayList<T> elements;
	
	public Stack() {
		this.elements = new ArrayList<T>();
	}
	
	public void push (T item) {
		this.elements.add(item);	
	}
	
	public T pop() {
		if (this.elements.size() == 0)
			return null;
		T poppedItem = this.elements.get(this.elements.size()-1);
		this.elements.remove(this.elements.size()-1);
		return poppedItem;
	}
	
	public String toString() {
			return this.elements.toString();
	}
}
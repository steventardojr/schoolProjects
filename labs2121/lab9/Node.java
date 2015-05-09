public class Node<Element> {
	private Element value;
	private Node<Element> next;
	private Node<Element> prev;
	
	public Node(Element value) {
		this.value = value;
		this.next = null;
		this.prev = null;
	}
	
	public Element getValue() {
		return this.value;
	}
	
	public Node<Element> getNext() {
		return this.next;
	}
	
	public Node<Element> getPrev() {
		return this.prev;
	}
	
	public void setValue(Element value) {
		this.value = value;
	}
	
	public void setNext(Node<Element> next) {
		this.next = next;
	}
	
	public void setPrev(Node<Element> prev) {
		this.prev = prev;
	}
}
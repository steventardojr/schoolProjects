public class DoublyLinkedList<Element> {
	private int size;
	private Node<Element> first;
	private Node<Element> last;
	
	public DoublyLinkedList() {
		this.size = 0;
		this.first = null;
		this.last = null;
	}
	
	public boolean isEmpty() {
		if (this.size == 0)
			return true;
		return false;
	}
	
	public int size() {
		return this.size;
	}
	
	/**
	 * @require !isEmpty()
	 * @require index < size()	
	 */
		
	public Element get(int index) {
		Node<Element> current = this.first;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getValue();
	}
	
	/**
	 * @require !isEmpty()
     * @require index < size()	
	 */
	public void set(int index, Element value) {
		Node<Element> current = this.first;
		for (int i = 0; i < index; i++) {
			current = current.getNext();
		}
		current.setValue(value);
	}
	
	public void add(Element value) {
		Node<Element> newNode = new Node<Element>(value);
		
		if (this.last == null) {
			this.first = newNode;
			this.last = newNode;
		}
		else {
			Node<Element> current = this.last;
			this.last = newNode;
			current.setNext(newNode);
			newNode.setPrev(current);
		}
		this.size++;
	}
	
	/**
	 * @require index < size()
	 */
	public void add(int index, Element value) {
		Node<Element> newNode = new Node<Element>(value);
		if (index == this.size - 1) {
			Node<Element> current = this.last;
			this.last = newNode;
			current.setNext(newNode);
			newNode.setPrev(current);
		}
		else if (index == 0) {
			Node<Element> current = this.first;
			this.first = newNode;
			newNode.setNext(current);
			current.setPrev(newNode);
		}
		else {
			Node<Element> previous = this.first;
			for (int i = 0; i < index - 1; i++) {
				previous = previous.getNext();
			}
			Node<Element> current = this.first;
			for (int i = 0; i < index; i++) {
				current = current.getNext();
			}
			previous.setNext(newNode);
			newNode.setPrev(previous);
			current.setPrev(newNode);
			newNode.setNext(current);
			
		}
		this.size++;
	}
	
	public void remove(int index) {
		Node<Element> previous = this.first;
		for (int i = 0; i < index - 1; i++) {
			previous = previous.getNext();
		}
		Node<Element> next = this.first;
		for (int i = 0; i < index + 1; i++) {
			next = next.getNext();
		}
		previous.setNext(next);
		next.setPrev(previous);
		this.size--;
	}
	
	public Iterator<Element> getIterator() {
		return new Iterator<Element>(this);
	}
	
	private class Iterator<Type> {
		private DoublyLinkedList<Type> list;
		private Node<Type> current;
		
		public Iterator(DoublyLinkedList<Type> list) {
			this.list = list;
			this.current = list.head;
		}
		
		public Type next() {
			if (this.current != null) {
				Type value = this.current.getValue();
				this.current = this.current.getNext();
				return value;
			}
			return null;
		}
		
		public boolean hasNext() {
			if (this.current.getNext() == null)
				return false;
			return true;
		}
	}
}


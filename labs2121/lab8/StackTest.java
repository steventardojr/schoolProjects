import java.util.*;
import junit.framework.TestCase;

/** Steven Tardo
	CSCI 2121, Fall 2014
	Lab 8
**/

public class StackTest extends TestCase {
	// Test Fixtures
	private Stack<Integer> intStack;
	private Stack<String> stringStack;
	private Stack<Integer> emptyStack;
	
	protected void setUp() {
		this.intStack = new Stack<Integer>();
		this.stringStack = new Stack<String>();
		this.emptyStack = new Stack<Integer>();
		
		this.intStack.push(5);
		this.intStack.push(-7);
		this.intStack.push(111);
		
		this.stringStack.push("hello");
		this.stringStack.push("world");
	}
	
	public void testPop() {
		assertTrue(this.intStack.pop() == 111);
		assertTrue(this.intStack.pop() == -7);
		
		assertEquals(this.stringStack.pop(), "world");
		assertEquals(this.stringStack.pop(), "hello");
		
		assertNull(this.emptyStack.pop());
	}
	
	public void testPush() {
		this.stringStack.push("goodbye");
		assertEquals(this.stringStack.pop(), "goodbye");
		
		this.emptyStack.push(2);
		assertEquals(this.emptyStack.toString(), "[2]");
	}
}
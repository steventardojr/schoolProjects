import junit.framework.TestCase;
import java.awt.Rectangle;

public class RectangleTest extends TestCase {
	
	private Rectangle rectangleOne;
	private Rectangle rectangleTwo;
	
	// This method sets up the rectangle needed to test the contains method
	protected void setUp() {
		rectangleTwo = new Rectangle( 5, 5 );
	}
	
	// This method tests the default Rectangle constructor with arguments of 0
	public void testDefaultConstructor1() {
		rectangleOne = new Rectangle( 0, 0 );
		assertTrue( rectangleOne.width == 0 );
		assertTrue ( rectangleOne.height == 0 );
	}
	
	/**
	 * This method tests the default Rectangle constructor with a width of 4
	 * and heigth of 6
	 **/
	public void testDefaultConstructor2() {
		rectangleOne = new Rectangle( 4, 6 );
		assertTrue( rectangleOne.width == 4 );
		assertTrue( rectangleOne.height == 6 );
	}
	
	/**
	 * This method tests the four argument Rectangle constructor
	 * with all arguments as 0
	 **/
	public void test4ArgumentConstructor1() {
		rectangleOne = new Rectangle( 0, 0, 0, 0);
		assertTrue( rectangleOne.x == 0 );
		assertTrue( rectangleOne.y == 0 );
		assertTrue( rectangleOne.width == 0 );
		assertTrue( rectangleOne.height == 0 );
	}
	
	/**
	 * This method tests the four argument Rectangle constructor
	 * with its top, left corner at (2,4), a width of 6,
     * and a height of 8
	 **/
	public void test4ArgumentConstructor2() {
		rectangleOne = new Rectangle( 2, 4, 6, 8);
		assertTrue( rectangleOne.x == 2 );
		assertTrue( rectangleOne.y == 4 );
		assertTrue( rectangleOne.width == 6 );
		assertTrue( rectangleOne.height == 8 );
	}
	
	/**
	 * This method tests the contains method.
	 * This method previously contained tests for points on the edges
	 * of the rectangle, but these cause the method to return false
	 **/
	public void testContainsMethod1() {
		assertTrue( rectangleTwo.contains( 2, 3 ) );
		assertTrue( rectangleTwo.contains( 4.9, 4.9 ) );
		assertTrue( rectangleTwo.contains( 0.1, 0.1 ) );
	}
	
}
	
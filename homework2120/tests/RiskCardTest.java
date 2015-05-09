import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCardTest
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class RiskCardTest extends TestCase {
	private RiskCard test;
	
	protected void setUp() {
		test = new RiskCard();
	}
	
	public void testGetType() {
		assertTrue(test.getType() == null);
	}
	
	public void testGetTerritory() {
		assertTrue(test.getTerritory() ==  null);
	}
}
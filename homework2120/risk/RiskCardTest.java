import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCardTest
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class RiskCardTest extends TestCase {
	private RiskCard testCard1;
	private RiskCard testCard2;
	private Territory territory1;
	
	protected void setUp() {
		territory1 = new Territory("territory1");
		testCard1 = new RiskCard("Card1", territory1);
		testCard2 = new RiskCard("", territory1);
	}
	
	public void testGetType() {
		assertTrue(testCard1.getType() == "Card1");
		assertTrue(testCard2.getType() == "");
	}
	
	public void testGetTerritory() {
		Territory testTerritory1 = testCard1.getTerritory();
		assertTrue(testTerritory1.getName() == "territory1");
		Territory testTerritory2 = testCard2.getTerritory();
		assertTrue(testTerritory2.getName() == "territory1");
	}
}
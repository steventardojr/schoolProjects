import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCardHandTest
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class RiskCardHandTest extends TestCase {
	private RiskCardHand test;
	
	protected void setUp() {
		test = new RiskCardHand();
	}
	
	public void testRiskCardHand() {
		assertTrue(test.getRiskCardHand() == null);
	}
	
	public void testAcceptCard() {
		test.acceptCard();
		assertTrue(test.getRiskCardHand() != null);
	}
	
	public void testReturnRiskCard() {
		int[] testSet = {0};
		test.returnRiskCard(testSet);
		assertTrue(test.getRiskCardHand() != null);
	}
	
}

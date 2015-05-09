import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCardDeckTest
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class RiskCardDeckTest extends TestCase {
	private RiskCardDeck test;
	
	protected void setUp() {
		test = new RiskCardDeck();
	}
	
	public void testDeal() {
		assertTrue(test.deal() == null);
	}
	
	public void testAcceptCard() {
		ArrayList<RiskCard> testRiskCardSet = new ArrayList<RiskCard>();
		test.acceptCard(testRiskCardSet);
		assertTrue(test.deal() != null);
	}
	
	public void testShuffle() {
		test.shuffle();
		assertTrue(test.deal() != null);
	}
	
	public void testHasCards() {
		assertTrue(test.hasCards() == false);
	}
}

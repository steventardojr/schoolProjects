import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCardHandTest
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class RiskCardHandTest extends TestCase {
	private RiskCardHand testHand;
	private Territory territory1;
	private Territory territory2;
	private RiskCard riskcard1;
	private RiskCard riskcard2;
	private RiskCard riskcard3;
	private RiskCard riskcard4;
	
	protected void setUp() {
		testHand = new RiskCardHand();
		territory1 = new Territory("territory1");
		territory2 = new Territory("territory2");
		riskcard1 = new RiskCard("card1", territory1);
		riskcard2 = new RiskCard("card2", territory1);
		riskcard3 = new RiskCard("card3", territory2);
		riskcard4 = new RiskCard("card4", territory2);
	}
	
	public void testRiskCardHandAndAcceptCard() {
		testHand.acceptCard(riskcard1);
		testHand.acceptCard(riskcard2);
		testHand.acceptCard(riskcard3);
		testHand.acceptCard(riskcard4);
		ArrayList<RiskCard> handTest = testHand.getRiskCardHand();
		RiskCard testCard = handTest.get(0);
		handTest = testHand.getRiskCardHand();
		testCard = handTest.get(0);
		assertTrue(testCard.getType() == "card1");
		testCard = handTest.get(1);
		assertTrue(testCard.getType() == "card2");
		testCard = handTest.get(2);
		assertTrue(testCard.getType() == "card3");
		testCard = handTest.get(3);
		assertTrue(testCard.getType() == "card4");
	}
	
	public void testReturnRiskCard() {
		int[] set = {1, 3};
		testHand.acceptCard(riskcard1);
		testHand.acceptCard(riskcard2);
		testHand.acceptCard(riskcard3);
		testHand.acceptCard(riskcard4);
		ArrayList<RiskCard> handTest = testHand.returnRiskCard(set);
		RiskCard testCard = handTest.get(0);
		assertTrue(testCard.getType() == "card2");
		testCard = handTest.get(1);
		assertTrue(testCard.getType() == "card4");
	}
	
}

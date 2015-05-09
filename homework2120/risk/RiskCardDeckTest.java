import java.util.ArrayList;
import java.util.Collections;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCardDeckTest
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class RiskCardDeckTest extends TestCase {
	private RiskCardDeck testDeck;
	private Territory territory1;
	private Territory territory2;
	private RiskCard riskCard1;
	private RiskCard riskCard2;
	private RiskCard riskCard3;
	private RiskCard riskCard4;
	private ArrayList<RiskCard> riskCards;
	
	protected void setUp() {
		territory1 = new Territory("territory1");
		territory2 = new Territory("territory2");
		riskCard1 = new RiskCard("Card1", territory1);
		riskCard2 = new RiskCard("Card2", territory1);
		riskCard3 = new RiskCard("Card3", territory2);
		riskCard4 = new RiskCard("Card4", territory2);
		riskCards = new ArrayList<RiskCard>();
		riskCards.add(riskCard1);
		riskCards.add(riskCard2);
		riskCards.add(riskCard3);
		riskCards.add(riskCard4);
		testDeck = new RiskCardDeck(riskCards);
	}
	
	public void testDeal() {
		RiskCard cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card4");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card3");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card2");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card1");
		
	}
	
	public void testAcceptCard() {
		testDeck.acceptCard(riskCards);
		RiskCard cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card4");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card3");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card2");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card1");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card4");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card3");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card2");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card1");
	}
	
	public void testHasCards() {
		assertTrue(testDeck.hasCards());
		RiskCard cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card4");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card3");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card2");
		cardTest = testDeck.deal();
		assertTrue(cardTest.getType() == "Card1");
		assertFalse(testDeck.hasCards());
	}
}

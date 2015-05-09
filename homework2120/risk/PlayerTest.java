import java.util.ArrayList;
import java.util.Arrays;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class PlayerTest
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class PlayerTest extends TestCase {
	private Player testPlayer1;
	private Player testPlayer2;
	private Territory territory1;
	private Territory territory2;
	private ArrayList<Territory> territoryList1;
	private ArrayList<Territory> territoryList2;
	private Continent continent1;
	private Continent continent2;
	private RiskCard riskCard1;
	private RiskCard riskCard2;
	
	protected void setUp() {
		testPlayer1 = new Player("Test1", 10);
		testPlayer2 = new Player("Test2", 5);
		territory1 = new Territory("territory1");
		territory2 = new Territory("territory2");
		territoryList1 = new ArrayList<Territory>();
		territoryList2 = new ArrayList<Territory>();
		territoryList1.add(territory1);
		territoryList2.add(territory2);
		continent1 = new Continent("continent1", 0, territoryList1);
		continent2 = new Continent("continent2", 0, territoryList2);
		riskCard1 = new RiskCard("card1", territory1);
		riskCard2 = new RiskCard("card2", territory2);
		territory1.setNumberOfArmies(5);
		territory2.setNumberOfArmies(5);
	}
	
	public void testGetName() {
		assertTrue(testPlayer1.getName() == "Test1");
		assertTrue(testPlayer2.getName() == "Test2");
	}
	
	public void testGetNumberOfArmies() {
		assertTrue(testPlayer1.getNumberOfArmies() == 10);
		testPlayer1.updateNumberOfArmies(-1);
		assertTrue(testPlayer1.getNumberOfArmies() == 9);
		assertTrue(testPlayer2.getNumberOfArmies() == 5);
		testPlayer2.updateNumberOfArmies(-1);
		assertTrue(testPlayer2.getNumberOfArmies() == 4);
	}
	
	public void testGetUnplacedArmies() {
		assertTrue(testPlayer1.getUnplacedArmies() == 0);
		testPlayer1.addArmies(10);
		assertTrue(testPlayer1.getUnplacedArmies() == 10);
		assertTrue(testPlayer2.getUnplacedArmies() == 0);
		testPlayer2.addArmies(5);
		assertTrue(testPlayer2.getUnplacedArmies() == 5);
	}
	
	public void testGetTerritories() {
		testPlayer1.addTerritory(territory1);
		ArrayList<Territory> testTerritoryList1 = testPlayer1.getTerritories();
		Territory testTerritory1 = testTerritoryList1.get(0);
		assertTrue(testTerritory1.getName() == "territory1");
		testPlayer2.addTerritory(territory2);
		ArrayList<Territory> testTerritoryList2 = testPlayer2.getTerritories();
		Territory testTerritory2 = testTerritoryList2.get(0);
		assertTrue(testTerritory2.getName() == "territory2");
	}
	
	public void testGetContinents() {
		testPlayer1.addContinent(continent1);
		ArrayList<Continent> testContinentList1 = testPlayer1.getContinents();
		Continent testContinent1 = testContinentList1.get(0);
		assertTrue(testContinent1.getName() == "continent1");
		testPlayer2.addContinent(continent2);
		ArrayList<Continent> testContinentList2 = testPlayer2.getContinents();
		Continent testContinent2 = testContinentList2.get(0);
		assertTrue(testContinent2.getName() == "continent2");
	}
	
	public void testAddRiskCard() {
		testPlayer1.addRiskCard(riskCard1);
		RiskCardHand testHand1 = testPlayer1.getRiskCardHand();
		ArrayList<RiskCard> testHandList1 = testHand1.getRiskCardHand();
		RiskCard testCard1 = testHandList1.get(0);
		assertTrue(testCard1.getType() == "card1");
		testPlayer2.addRiskCard(riskCard2);
		RiskCardHand testHand2 = testPlayer2.getRiskCardHand();
		ArrayList<RiskCard> testHandList2 = testHand2.getRiskCardHand();
		RiskCard testCard2 = testHandList2.get(0);
		assertTrue(testCard2.getType() == "card2");
	}
	
	public void testAttack() {
		testPlayer1.attack(territory1, territory2, 2);
		assertTrue(territory1.getArmies() < 5 || territory2.getArmies() < 5);
		testPlayer1.attack(territory1, territory2, 2);
		assertTrue(territory1.getArmies() < 5 || territory2.getArmies() < 5);
	}
}

import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class PlayerTest
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class PlayerTest extends TestCase {
	private Player test;
	
	protected void setUp() {
		test = new Player();
	}
	
	public void testGetName() {
		assertTrue(test.getName() == null);
	}
	
	public void testGetNumberOfArmies() {
		assertTrue(test.getNumberOfArmies() == 0);
	}
	
	public void testGetUnplacedArmies() {
		assertTrue(test.getUnplacedArmies() == 0);
	}
	
	public void testGetTerritories() {
		assertTrue(test.getTerritories() == null);
	}
	
	public void testGetContinents() {
		assertTrue(test.getContinents() == null);
	}
	
	public void testAddTerritory() {
		Territory testTerritory = new Territory();
		test.addTerritory(testTerritory);
		assertTrue(test.getTerritories() == null);
	}
	
	public void testAddContinent() {
		Continent testContinent = new Continent();
		test.addContinent(testContinent);
		assertTrue(test.getContinents() == null);
	}
	
	public void testAddArmies() {
		int testArmies = 0;
		test.addArmies(testArmies);
		assertTrue(test.getNumberOfArmies() == 0);
	}
	
	public void testAddRiskCard() {
		RiskCard testCard = new RiskCard();
		test.addRiskCard(testCard);
		assertTrue(test.getUnplacedArmies() == 0);
	}
	
	public void testAttack() {
		Territory testAttackTerritory = new Territory();
		Territory testDefendTerritory = new Territory();
		test.Attack(testAttackTerritory, testDefendTerritory, 0);
		assertTrue(test.getNumberOfArmies() == 0);
	}
}

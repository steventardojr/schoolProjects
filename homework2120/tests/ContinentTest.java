import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class ContinentTest
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class ContinentTest extends TestCase {
	private Continent test;
	
	protected void setUp() {
		test = new Continent();
	}
	
	public void testGetName() {
		assertTrue(test.getName() == null);
	}
	
	public void testGetPlayer() {
		assertTrue(test.getOccupant() == null);
	}
	
	public void testGetBonusArmies() {
		assertTrue(test.getBonusArmies() == 0);
	}
	
	public void testSetOccupant() {
		Player occupant = new Player();
		test.setOccupant(occupant);
		assertTrue(test.getOccupant() == null);
	}
	
	public void testIsOccupied() {
		Continent test = new Continent();
		assertTrue(test.isOccupied() == false);
	}
	
	public void testGetTerritories() {
		assertTrue(test.getTerritories() == null);
	}
}

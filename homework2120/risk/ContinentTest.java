import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class ContinentTest
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class ContinentTest extends TestCase {
	private Continent continent1;
	private Continent continent2;
	private Continent continent3;
	
	protected void setUp() {
		Territory territory1 = new Territory("territory1");
		Territory territory2 = new Territory("territory2");
		Territory territory3 = new Territory("territory3");
		ArrayList<Territory> territories = new ArrayList<Territory>();
		territories.add(territory1);
		territories.add(territory2);
		territories.add(territory3);
		continent1 = new Continent("continent1", 1, territories);
		continent2 = new Continent("", 0, territories);
		continent3 = new Continent("continent3", 3, null);
		Player occupant = new Player("player1", 10);
	}
	
	public void testGetName() {
		assertTrue(continent1.getName().equals("continent1"));
		assertTrue(continent2.getName().equals(""));
		assertTrue(continent3.getName().equals("continent3"));
	}
	
	public void testGetOccupant() {
		assertTrue(continent1.getOccupant() == null);
		assertTrue(continent2.getOccupant() == null);
		assertTrue(continent3.getOccupant() == null);
	}
	
	public void testGetBonusArmies() {
		assertTrue(continent1.getBonusArmies() == 1);
		assertTrue(continent2.getBonusArmies() == 0);
		assertTrue(continent3.getBonusArmies() == 3);
	}
	
	public void testSetOccupant() {
		Player occupant = new Player("player1", 10);
		continent1.setOccupant(occupant);
		assertTrue(continent1.getOccupant() == occupant);
		assertTrue(continent2.getOccupant() == null);
		assertTrue(continent3.getOccupant() == null);
	}
	
	public void testIsOccupied() {
		Player occupant = new Player("player1", 10);
		continent1.setOccupant(occupant);
		assertTrue(continent1.isOccupied());
		assertFalse(continent2.isOccupied());
		assertFalse(continent3.isOccupied());
	}
	
	public void testGetTerritories() {
		assertNull(continent3.getTerritories());
		assertNotNull(continent1.getTerritories());
		assertNotNull(continent2.getTerritories());
	}
}

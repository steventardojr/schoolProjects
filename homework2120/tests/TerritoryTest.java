import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class TerritoryTest
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class TerritoryTest extends TestCase {
	private Territory test;
	
	protected void setUp() {
		test = new Territory();
	}
	
	public void testGetName() {
		assertTrue(test.getName() ==  null);
	}
	
	public void testGetOccupant() {
		assertTrue(test.getOccupant() == null);
	}
	
	public void testGetArmies() {
		assertTrue(test.getArmies() == 0);
	}
	
	public void testGetNeighbors() {
		assertTrue(test.getNeighbors() == null);
	}
	
	public void testSetNumberOfArmies() {
		int testNum = 0;
		test.setNumberOfArmies(testNum);
		assertTrue(test.getArmies() == 0);
	}
	
	public void testSetOccupant() {
		Player testOccupant = new Player();
		test.setOccupant(testOccupant);
		assertTrue(test.getOccupant() == null);
	}
}

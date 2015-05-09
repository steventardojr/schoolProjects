import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class TerritoryTest
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class TerritoryTest extends TestCase {
	private Territory territory1;
	private Territory territory2;
	private Territory territory3;
	private Territory territory4;
	private Player player1;
	
	protected void setUp() {
		territory1 = new Territory("territory1");
		territory2 = new Territory("territory2");
		territory3 = new Territory("territory3");
		territory4 = new Territory("territory4");
		player1 = new Player("player1", 10);
	}
	
	public void testGetName() {
		assertTrue(territory1.getName() ==  "territory1");
		assertTrue(territory2.getName() ==  "territory2");
		assertTrue(territory3.getName() ==  "territory3");
		assertTrue(territory4.getName() ==  "territory4");
	}
	
	
	public void testSetNumberOfArmies() {
		assertTrue(territory1.getArmies() == 0);
		assertTrue(territory2.getArmies() == 0);
		assertTrue(territory3.getArmies() == 0);
		assertTrue(territory4.getArmies() == 0);
		territory1.setNumberOfArmies(10);
		assertTrue(territory1.getArmies() == 10);
		territory1.setNumberOfArmies(5);
		assertTrue(territory1.getArmies() == 15);
	}
	
	public void testSetOccupant() {
		assertTrue(territory1.getOccupant() == null);
		assertTrue(territory2.getOccupant() == null);
		assertTrue(territory3.getOccupant() == null);
		assertTrue(territory4.getOccupant() == null);
		territory1.setOccupant(player1);
		territory2.setOccupant(player1);
		territory3.setOccupant(player1);
		territory4.setOccupant(player1);
		assertTrue(territory1.getOccupant() == player1);
		assertTrue(territory1.getOccupant() == player1);
		assertTrue(territory1.getOccupant() == player1);
		assertTrue(territory1.getOccupant() == player1);
	}
	
	public void testAddNeighbor() {
		territory1.addNeighbor(territory2);
		territory1.addNeighbor(territory3);
		territory1.addNeighbor(territory4);
		ArrayList<Territory> neighborList = territory1.getNeighbors();
		assertTrue(neighborList.get(0) == territory2);
		assertTrue(neighborList.get(1) == territory3);
		assertTrue(neighborList.get(2) == territory4);
	}
}

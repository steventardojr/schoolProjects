import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class GameBoardTest
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class GameBoardTest extends TestCase {
	private GameBoard test;
	
	protected void setUp() {
		test = new GameBoard();
	}
	
	public void testGetTerritories() {
		assertTrue(test.getTerritoriesList() == null);
	}
	
	public void testGetContinents() {
		assertTrue(test.getContinentsList() == null);
	}
	
	public void testGetTerritoryByName() {
		String testString = "";
		assertTrue(test.getTerritoryByName(testString) ==  null);
	}
	
	public void testGetContinentByName() {
		String testString = "";
		assertTrue(test.getContinentByName(testString) ==  null);
	}
}

import java.util.HashMap;
import java.util.ArrayList;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class GameBoardTest
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class GameBoardTest extends TestCase {
	private GameBoard gameboard1;
	private Territory territory1;
	private Territory territory2;
	private Territory territory3;
	private Territory territory4;
	private ArrayList<Territory> territories1;
	private ArrayList<Territory> territories2;
	private Continent continent1;
	private Continent continent2;
	private HashMap<String, Territory> territoriesList;
	private HashMap<String, Continent> continentsList;
	
	protected void setUp() {
		territory1 = new Territory("territory1");
		territory2 = new Territory("territory2");
		territory3 = new Territory("territory3");
		territory4 = new Territory("territory4");
		territories1 = new ArrayList<Territory>();
		territories2 = new ArrayList<Territory>();
		territories1.add(territory1);
		territories1.add(territory2);
		territories2.add(territory3);
		territories2.add(territory4);
		continent1 = new Continent("continent1", 0, territories1);
		continent2 = new Continent("continent2", 0, territories2);
		territoriesList = new HashMap<String, Territory>();
		continentsList = new HashMap<String, Continent>();
		territoriesList.put("territory1", territory1);
		territoriesList.put("territory2", territory2);
		territoriesList.put("territory3", territory3);
		territoriesList.put("territory4", territory4);
		continentsList.put("continent1", continent1);
		continentsList.put("continent2", continent2);
		gameboard1 = new GameBoard(territoriesList, continentsList);
	}
	
	public void testGetTerritories() {
		ArrayList<Territory> territorytest = gameboard1.getTerritoriesList();
		Territory territorytest1 = territorytest.get(0);
		Territory territorytest2 = territorytest.get(1);
		Territory territorytest3 = territorytest.get(2);
		Territory territorytest4 = territorytest.get(3);
		assertTrue(territorytest1.getName() == "territory1");
		assertTrue(territorytest2.getName() == "territory4");
		assertTrue(territorytest3.getName() == "territory3");
		assertTrue(territorytest4.getName() == "territory2");
	}
	
	public void testGetContinents() {
		ArrayList<Continent> continenttest = gameboard1.getContinentsList();
		Continent continenttest1 = continenttest.get(0);
		Continent continenttest2 = continenttest.get(1);
		assertTrue(continenttest1.getName() == "continent1");
		assertTrue(continenttest2.getName() == "continent2");
	}
	
	public void testGetTerritoryByName() {
		Territory territorytest1 = gameboard1.getTerritoryByName("territory1");
		Territory territorytest2 = gameboard1.getTerritoryByName("territory2");
		Territory territorytest3 = gameboard1.getTerritoryByName("territory3");
		Territory territorytest4 = gameboard1.getTerritoryByName("territory4");
		assertTrue(territorytest1.getName() == "territory1");
		assertTrue(territorytest2.getName() == "territory2");
		assertTrue(territorytest3.getName() == "territory3");
		assertTrue(territorytest4.getName() == "territory4");
	}
	
	public void testGetContinentByName() {
		Continent continenttest1 = gameboard1.getContinentByName("continent1");
		Continent continenttest2 = gameboard1.getContinentByName("continent2");
		assertTrue(continenttest1.getName() == "continent1");
		assertTrue(continenttest1.getName() == "continent1");
	}
}

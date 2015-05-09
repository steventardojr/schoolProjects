import java.util.HashMap;
import java.util.ArrayList;
import java.io.Serializable;

/**
* CSCI 2120 Fall 2014
* Risk Game Class GameBoard
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class GameBoard implements Serializable {
	// Instance variables
	private HashMap<String, Territory> territoriesList;
	private HashMap<String, Continent> continentsList;
	
	// Constructor
	public GameBoard(HashMap<String, Territory> territoriesList, HashMap<String, Continent> continentsList) {
		this.territoriesList = territoriesList;
		this.continentsList = continentsList;
	}
	
	/**
	* Returns a list of territories on gameboard
	*
	* return type ArrayList<Territory>, territories on gameboard
	**/
	public ArrayList<Territory> getTerritoriesList() {
		ArrayList<Territory> territories = new ArrayList<Territory>();
		territories.addAll(this.territoriesList.values());
		return territories;
	}
	
	/**
	* Returns a list of continents on gameboard
	*
	* return type ArrayList<Continent>, continents on gameboard
	**/
	public ArrayList<Continent> getContinentsList() {
		ArrayList<Continent> continents = new ArrayList<Continent>();
		continents.addAll(this.continentsList.values());
		return continents;
	}
	
	/**
	* Returns a the territory requested by name
	*
	* argument String territoryName, name of Territory requested
	*	
	* return type Territory, territory requested
	**/
	public Territory getTerritoryByName( String territoryName ) {
		Territory territory = territoriesList.get(territoryName);
		return territory;
	}
	
	/**
	* Returns a the continent requested by name
	*
	* argument String continentName, name of Continent requested
	*	
	* return type Continent, continent requested
	**/
	public Continent getContinentByName( String continentName ) {
		Continent continent = continentsList.get(continentName);
		return continent;
	}
}

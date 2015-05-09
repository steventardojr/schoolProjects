import java.util.ArrayList;

/**
 * GameBoard Interface
 * Homework 2
 * Steven Tardo
 * CSCI 2120
 * Fall 2014
 **/

public interface GameBoardInterface {
	ArrayList<Territory> getTerritoriesList();
	
	ArrayList<Continent> getContinentsList();
	
	Territory getTerritoryByName( String territoryName );
	
	Continent getContinentByName( String continentName );
}

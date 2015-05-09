import java.util.ArrayList;

/**
* CSCI 2120 Fall 2014
* Risk Game Class Player
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class Player {
	private String name;
	private int numberOfArmies;
	private int unplacedArmies;
	private ArrayList<Territory> territories;
	private ArrayList<Continent> continents;
	
	public Player() {
		this.name = null;
		this.numberOfArmies = 0;
		this.unplacedArmies = 0;
		this.territories = null;
		this.continents = null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumberOfArmies() {
		return this.numberOfArmies;
	}
	
	public int getUnplacedArmies() {
		return this.unplacedArmies;
	}
	
	public ArrayList<Territory> getTerritories() {
	  return this.territories;
  	}
  	
	public ArrayList<Continent> getContinents() {
	  return this.continents;
  	}
	
	public void addTerritory( Territory newTerritory ) {
 	 	
 	 }
	 
	public void addContinent( Continent newContinent ) {
		
	}
	
	public void addArmies( int newArmies ) {
		
	}
	
	public void addRiskCard( RiskCard newCard ) {
		
	}
	
	public void Attack( Territory attacker, Territory defender, int numAttackingArmies ) {
		
	}
}

import java.util.ArrayList;
import java.util.Arrays;
import java.io.Serializable;

/**
* CSCI 2120 Fall 2014
* Risk Game Class Player
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class Player implements Serializable {
	// Instance variables
	private String name;
	private int numberOfArmies;
	private int unplacedArmies;
	private ArrayList<Territory> territories;
	private ArrayList<Continent> continents;
	private RiskCardHand riskCardHand;
	
	// Constructor
	public Player(RiskCardHand hand) {
		this.name = "";
		this.numberOfArmies = 0;
		this.unplacedArmies = 0;
		this.territories = new ArrayList<Territory>();
		this.continents = new ArrayList<Continent>();
		this.riskCardHand = hand;
	}
	
	/**
	* Returns the player's name
	*
	* return type String, name of player
	**/
	public String getName() {
		return this.name;
	}
	
	public void addName(String name) {
		this.name = name;
	}
	
	/**
	* Returns the number of armies the player has on the board
	*
	* return type int, number of placed armies
	**/
	public int getNumberOfArmies() {
		return this.numberOfArmies;
	}
	
	/**
	* Returns the number of armies the player has yet
	* to place on the board
	*
	* return type int, number of unplaced armies
	**/
	public int getUnplacedArmies() {
		return this.unplacedArmies;
	}
	
	/**
	* Returns the territories the player controls
	*
	* return type ArrayList<Territory>, the territories controlled
	**/
	public ArrayList<Territory> getTerritories() {
	  return this.territories;
  	}
  	
	/**
	* Returns continents the player controls
	*
	* return type ArrayList<Continent>, the continents controlled
	**/
	public ArrayList<Continent> getContinents() {
	  return this.continents;
  	}
	
	/**
	* Returns the card hand of the player
	*
	* return type RiskCardHand, the player's hand
	**/
	public RiskCardHand getRiskCardHand() {
		return this.riskCardHand;
	}
	
	/**
	* Adds a territory when player takes control
	*
	* argument type Territory, the territory the player took
	* control of
	**/
	public void addTerritory( Territory newTerritory ) {
 	 	this.territories.add(newTerritory);
 	 }
	 
 	/**
 	* Adds a continent when player takes control
 	*
 	* argument type Continent, the continent the player took
 	* control of
 	**/
	public void addContinent( Continent newContinent ) {
		this.continents.add(newContinent);
	}
	
	/**
	* Adds the number of unplaced armies a player recieves
	* from turning in risk cards
	*
	* argument type int, the number of new armies recevied
	**/
	public void addArmies( int newArmies ) {
		this.unplacedArmies += newArmies;
	}
	
	/**
	* Updates the number of armies the player has on the board
	*
	* argument type int, the number of armies added or removed
	**/
	public void updateNumberOfArmies( int newArmies ) {
		this.numberOfArmies += newArmies;
	}
	
	/**
	* Adds a risk card that the player drew
	*
	* argument type RiskCard, the risk card drawn
	**/
	public void addRiskCard( RiskCard newCard ) {
		this.riskCardHand.acceptCard(newCard);
	}
	
	/**
	* Simulates attacking in Risk
	*
	* argument type Territory attacker, the territory from which the player is attacking
	* argument type Territory defender, the teritory the player is attacking
	* argument type int, the number of armies the player is risking
	**/
	public void attack( Territory attacker, Territory defender, int numAttackingArmies ) {
		Dice dice = new Dice();
		int[] roll = dice.roll(numAttackingArmies, numAttackingArmies -1);
		int[] attackerRoll = new int[numAttackingArmies];
		int[] defenderRoll = new int[numAttackingArmies -1];
		for (int i = 0; i < numAttackingArmies; i++) {
			attackerRoll[i] = roll[i];
		}
		for (int i = numAttackingArmies; i < 2*numAttackingArmies - 1; i++) {
			defenderRoll[i-numAttackingArmies] = roll[numAttackingArmies];
		}
		Arrays.sort(attackerRoll);
		Arrays.sort(defenderRoll);
		for (int i = numAttackingArmies - 2; i >= 0 ; i--) {
			if (attackerRoll[i+1] > defenderRoll[i]) {
				defender.setNumberOfArmies(-1);
			}
			else {
				attacker.setNumberOfArmies(-1);
			}
		}
	}
}

import java.util.ArrayList;
import java.io.Serializable;

/**
* CSCI 2120 Fall 2014
* Risk Game Class Territory
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class Territory implements Serializable {
	// Instance variables
	private String name;
	private Player occupant;
	private int armies;
	private ArrayList<Territory> neighbors;
	
	// Constructor
	public Territory(String name) {
		this.name = name;
		this.occupant = null;
		this.armies = 0;
		this.neighbors = new ArrayList<Territory>();
	}
	
	/**
	* Returns the name of the territory
	*
	* return type String, the name of the territory
	**/
	public String getName() {
		return this.name;
	}
	
	/**
	* Returns the player occupying the Territory
	*
	* return type Player, the player occupying the territory
	**/
	public Player getOccupant() {
		return this.occupant;
	}
	
	/**
	* Returns the number of armies on the territory
	*
	* return type int, the number of armies placed
	* on the territory
	**/
	public int getArmies() {
		return this.armies;
	}
	
	/**
	* Returns the neighbors of the territory,
	* i.e., those that can be attacked
	*
	* return type ArrayList<Territory>, the neighbors
	* of the territory
	**/
	public ArrayList<Territory> getNeighbors() {
		return this.neighbors;
	}
	
	/**
	* Adds armies placed on the territory
	*
	* argument type int, the number of new armies
	* being placed on the territory
	**/
	public void setNumberOfArmies( int numArmies ) {
		this.armies += numArmies;
	}
	
	/**
	* Updates the player who occupies the territory
	*
	* argument type Player, the new player who
	* took control of the territory
	**/
	public void setOccupant( Player occupant ) {
		this.occupant = occupant;
	}
	
	/**
	* Adds the neighbors of the territory
	* that can be attacked from this territory
	*
	* argument type Territory, the neighboring territory
	**/
	public void addNeighbors( ArrayList<Territory> neighbors ) {
		this.neighbors = neighbors;
	}
}

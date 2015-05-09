import java.util.ArrayList;
import java.io.Serializable;

/**
* CSCI 2120 Fall 2014
* Risk Game Class Continent
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class Continent implements Serializable {
	// Instance variables
	private String name;
	private Player occupant;
	private int bonusArmies;
	private ArrayList<Territory> territories;
	
	// Constructor
	public Continent(String name, ArrayList<Territory> territories) {
		this.name = name;
		this.occupant = null;
		this.bonusArmies = 0;
		this.territories = territories;
	}
	
	/**
	* Returns name of continent
	*
	* return type String, name of continent
	**/
	public String getName() {
		return this.name;
	}
	
	/**
	* Returns player who occupies continent
	*
	* return type Player, occupant of continent
	**/
	public Player getOccupant() {
		return this.occupant;
	}
	
	/**
	* Returns the number of bonus armies on the continent
	*
	* return type int, number of bonus armies
	**/
	public int getBonusArmies() {
		return this.bonusArmies;
    }
	
	/**
	* Sets the occupant of the continent
	*
	* Argument type Player, new occupant of continent
	**/
	public void setOccupant( Player occupant ) {
		this.occupant = occupant;
	}
	
	/**
	* Checks if continent is occupied
	*
	* return type Boolean, true if occupied, false if not
	**/
    public boolean isOccupied() {
		boolean occupied = true;
		if (this.occupant == null)
			occupied = false;
		return occupied;
	}
	
	/**
	* Returns a list of territories on continent
	*
	* return type ArrayList<Territory>, territories located on continent
	**/
	public ArrayList<Territory> getTerritories() {
		return this.territories;
    }
}

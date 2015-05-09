import java.util.ArrayList;

/**
* CSCI 2120 Fall 2014
* Risk Game Class Continent
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class Continent {
	private String name;
	private Player occupant;
	private int bonusArmies;
	
	public Continent() {
		this.name = null;
		this.occupant = null;
		this.bonusArmies = 0;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Player getOccupant() {
		return this.occupant;
	}
	
	public int getBonusArmies() {
		return this.bonusArmies;
    }
	
	public void setOccupant( Player occupant ) {
		
	}
  
    public boolean isOccupied() {
		return false;
	}
	
	public ArrayList<Territory> getTerritories() {
		return null;
    }
}

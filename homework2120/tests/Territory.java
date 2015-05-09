import java.util.ArrayList;

/**
* CSCI 2120 Fall 2014
* Risk Game Class Territory
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class Territory {
	private String name;
	private Player occupant;
	private int armies;
	private ArrayList<Territory> neighbors;
	
	public Territory() {
		this.name = null;
		this.occupant = null;
		this.armies = 0;
		this.neighbors = null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Player getOccupant() {
		return this.occupant;
	}
	
	public int getArmies() {
		return this.armies;
	}
	
	public ArrayList<Territory> getNeighbors() {
		return this.neighbors;
	}
	
	public void setNumberOfArmies( int numArmies ) {
		
	}
	
	public void setOccupant( Player occupant ) {
		
	}
}

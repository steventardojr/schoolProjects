import java.io.Serializable;

/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCard
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class RiskCard implements Serializable {
	// Instance variables
	private String type;
	private Territory territory;
	
	// Constructor
	public RiskCard(String type, Territory territory) {
		this.type = type;
		this.territory = territory;
	}
	
	/**
	* Returns the type of the risk card
	*
	* return type String, the type of Risk Card
	**/
	public String getType() {
		return this.type;
	}
	
	/**
	* Returns the kind of territory on the risk card
	*
	* return type Territory, the territory on the risk card
	**/
	public Territory getTerritory() {
		return this.territory;
	}
}

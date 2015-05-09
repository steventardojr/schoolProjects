/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCard
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class RiskCard {
	private String type;
	private Territory territory;
	
	public RiskCard() {
		this.type = null;
		this.territory = null;
	}
	
	public String getType() {
		return this.type;
	}
	
	public Territory getTerritory() {
		return this.territory;
	}
}

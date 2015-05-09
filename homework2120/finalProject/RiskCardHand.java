import java.util.ArrayList;
import java.io.Serializable;

/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCardHand
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class RiskCardHand implements Serializable {
	// Instance variable
	private ArrayList<RiskCard> riskCardHand;
	
	// Constructor
	public RiskCardHand() {
		this.riskCardHand = new ArrayList<RiskCard>();
	}
	
	/**
	* Returns the risk card hand
	*
	* return type ArrayList<RiskCard>, the risk card hand
	**/
	public ArrayList<RiskCard> getRiskCardHand() {
		return this.riskCardHand;
	}
	
	/**
	* Adds a risk card to the hand
	*
	* argument type RiskCard, the risk card being added
	**/
	public void acceptCard(RiskCard card) {
		this.riskCardHand.add(card);
	}
	
	/**
	* Removes the specified cards from the deck
	* based on the values contained in set
	*
	* argument type int[] set, the indexes of the cards
	* to be removed from the hand
	**/
	public ArrayList<RiskCard> returnRiskCard( int[] set ) {
		ArrayList<RiskCard> returnCards = new ArrayList<RiskCard>();
		for (int i = 0; i < set.length; i++) {
			returnCards.add(this.riskCardHand.get(set[i]));
			riskCardHand.set(set[i], null);
		}
		riskCardHand.trimToSize();
		return returnCards;
	}
}

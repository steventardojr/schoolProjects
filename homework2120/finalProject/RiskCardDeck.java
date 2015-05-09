import java.util.ArrayList;
import java.util.Collections;
import java.io.Serializable;

/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskCardDeck
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class RiskCardDeck implements Serializable {
	// Instance variable
	private ArrayList<RiskCard> deck;
	
	// Constructor
	public RiskCardDeck(ArrayList<RiskCard> deck) {
		this.deck = deck;
	}
	
	/**
	* Deals a card and removes it from the deck
	*
	* return type RiskCard, the card being dealt
	**/
	public RiskCard deal() {
		RiskCard card = this.deck.get(this.deck.size() - 1);
		this.deck.remove(this.deck.size() - 1);
		return card;
	}
	
	/**
	* Adds a set of RiskCards to the deck
	*
	* argument type ArrayList<RiskCard>, the risk cards being added
	**/
	public void acceptCard( ArrayList<RiskCard> set ) {
		this.deck.addAll(set);
	}
	
	/**
	*
	* Simulates the shuffling of the deck
	*
	**/
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/**
	* Returns whether or not the deck
	* contains cards
	*
	* return type boolean, true if deck contains cards
	* false if not
	**/
	public boolean hasCards() {
		if (this.deck.size() != 0)
			return true;
		return false;
	}
}

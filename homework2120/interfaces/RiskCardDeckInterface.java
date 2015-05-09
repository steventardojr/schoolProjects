import java.util.ArrayList;

/**
 * RiskCardDeck Interface
 * Homework 2
 * Steven Tardo
 * CSCI 2120
 * Fall 2014
 **/

public interface RiskCardDeckInterface {
	RiskCard deal();
	
	void acceptCard( ArrayList<RiskCard> set );
	
	void shuffle();
	
	boolean hasCards();
}

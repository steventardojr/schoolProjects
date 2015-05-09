import java.util.ArrayList;

/**
 * RiskCardHand Interface
 * Homework 2
 * Steven Tardo
 * CSCI 2120
 * Fall 2014
 **/

public interface RiskCardHandInterface {
  ArrayList<RiskCard> getRiskCardHand();
  
  void acceptCard();
  
  ArrayList<RiskCard> returnRiskCard( int[] set );
}

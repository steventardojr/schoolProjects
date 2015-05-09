import java.util.ArrayList;

/**
 * Player Interface
 * Homework 2
 * Steven Tardo
 * CSCI 2120
 * Fall 2014
 **/

public interface PlayerInterface {
  String getName();

  int getNumberOfArmies();
  
  int getUnplacedArmies();

  ArrayList<Territory> getTerritories();

  ArrayList<Continent> getContinents();
  
  void addTerritory( Territory newTerritory );
  
  void addContinent( Continent newContinent );
  
  void addArmies( int newArmies );
  
  void addRiskCard( RiskCard newCard );
  
  void Attack( Territory attacker, Territory defender, int numAttackingArmies );
}

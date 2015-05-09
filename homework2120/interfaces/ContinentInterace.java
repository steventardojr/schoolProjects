import java.util.ArrayList;

/**
 * Continent Interface
 * Homework 2
 * Steven Tardo
 * CSCI 2120
 * Fall 2014
 **/

public interface ContinentInterface {
  String getName();

  Player getOccupant();

  int getBonusArmies();

  void setOccupant( Player occupant );
  
  boolean isOccupied();
  
  ArrayList<Territory> getTerritories();
}

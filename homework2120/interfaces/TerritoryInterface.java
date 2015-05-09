import java.util.ArrayList;

/**
 * Territory Interface
 * Homework 2
 * Steven Tardo
 * CSCI 2120
 * Fall 2014
 **/

public interface TerritoryInterface {
  String getName();
  
  Player getOccupant();
  
  int getArmies();
  
  ArrayList<Territory> getNeighbors();
  
  void setNumberOfArmies( int numArmies );
  
  void setOccupant( Player occupant );
}

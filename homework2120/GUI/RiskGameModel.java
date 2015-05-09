/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskGameModel
* Author: Steven Tardo
* Date: 12/10/14
**/

import java.util.Observable;

public class RiskGameModel extends Observable {
	// Instance variable
	private String screen;
	
	/**
	* This constructor sets up the RiskGameModel class
	* which handles which screen should be showing
	**/
	public RiskGameModel() {
		this.screen = "";
	}
	
	// This method switches the screen to createNewGame
	public void createNewGame() {
		this.screen = "createNewGame";
		this.setChanged();
		this.notifyObservers();
	}
	
	// This method switches the screen to loadSavedGame
	public void loadSavedGame() {
		screen = "loadSavedGame";
		setChanged();
		notifyObservers();
	}
	
	// This method switches the screen to initializePlayers
	public void initializePlayers() {
		screen = "initializePlayers";
		setChanged();
		notifyObservers();
	}
	
	// This method switches the screen to initializeBoard
	public void initializeBoard() {
		screen = "initializeBoard";
		setChanged();
		notifyObservers();
	}
	
	// This method switches the screen to placeArmies
	public void placeArmies() {
		screen = "placeArmies";
		setChanged();
		notifyObservers();
	}
	
	// This method switches the screen to playerTurn
	public void playerTurn() {
		screen = "playerTurn";
		setChanged();
		notifyObservers();
	}
	
	// This method switches the screen to turnInCards
	public void turnInCards() {
		screen = "turnInCards";
		setChanged();
		notifyObservers();
	}
	
	// This method switches the screen to placeArmies subscreen
	public void placeArmiesTurn() {
		screen = "placeArmiesTurn";
		setChanged();
		notifyObservers();
	}
	
	// This method switches the screen to attack
	public void attack() {
		screen = "attack";
		setChanged();
		notifyObservers();
	}
	
	// This method switches the screen to attackResults
	public void attackResults() {
		screen = "attackResults";
		setChanged();
		notifyObservers();
	}
	
	// This method switches the screen to fortify
	public void fortify() {
		screen = "fortify";
		setChanged();
		notifyObservers();
	}
	
	/**
	* This method returns the name of the screen the view should switch to
	* 
	* return String this.screen, the screen the view should change to
	**/
	public String screenSet() {
		return this.screen;
	}
}
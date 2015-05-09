/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskGameModel
* Author: Steven Tardo
* Date: 12/10/14
**/

import java.util.Observable;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.lang.ClassNotFoundException;
import java.io.Serializable;

public class RiskGameModel extends Observable implements Serializable {
	// Instance variables
	private String screen;
	private RiskGame game;
	private int numberOfPlayers;
	
	/**
	* This constructor sets up the RiskGameModel class
	* which handles which screen should be showing
	**/
	public RiskGameModel() {
		this.screen = "";
		this.game = null;
	}
	
	// This method switches the screen to createNewGame
	public void createNewGame() {
		this.screen = "createNewGame";
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	* This method makes a new game if createNewGame is selected
	*
	* String gameName, name of new game
	**/
	public void makeGame(String gameName) {
		this.game = new RiskGame(gameName);
	}
	
	/**
	* This method returns the active Risk game
	*
	* return RiskGame this.game, the active Risk game
	**/
	public RiskGame getGame() {
		return this.game;
	}
	
	// This method switches the screen to loadSavedGame
	public void loadSavedGame() {
		screen = "loadSavedGame";
		setChanged();
		notifyObservers();
	}
	
	/**
	* This method loads a serialized game is loadSavedGame is selected
	*
	* String nameOfGame, name of saved game
	**/
	public void loadGame(String nameOfGame) {
		ObjectInputStream reader = null;
		
		try
		{
			reader = new ObjectInputStream( new FileInputStream(nameOfGame) );
			this.game = (RiskGame)reader.readObject();
			reader.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		catch( ClassNotFoundException e )
		{
			System.out.println(e);
		}
		setChanged();
		notifyObservers();
	}
	
	// This method saves a game is saveGame is selected
	public void saveGame() {
		FileOutputStream fileWriter;
		ObjectOutputStream writer = null;
		
		try
		{
			writer = new ObjectOutputStream(new FileOutputStream(game.getName() + ".ser"));
				
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		
		try
		{
			writer.writeObject(this.game);
			writer.flush();
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
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
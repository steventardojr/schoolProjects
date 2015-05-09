/**
* CSCI 2120 Fall 2014
* Risk Game Class RiskGUI
* Author: Steven Tardo
* Date: 12/10/14
**/

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.util.Observer;
import java.util.Observable;
import java.awt.event.ActionListener;

public class RiskGUI extends JFrame implements Observer {
	//Instance variables
	private JPanel currentScreen;
	private JPanel startScreen;
	private JPanel createNewGameScreen;
	private JPanel loadSavedGameScreen;
	private JPanel initializePlayersScreen;
	private JPanel initializeBoardScreen;
	private JPanel placeArmiesScreen;
	private JPanel playerTurnScreen;
	private JPanel turnInCardsScreen;
	private JPanel placeArmiesSubScreen;
	private JPanel attackScreen;
	private JPanel attackResultsScreen;
	private JPanel fortifyScreen;
	private RiskGameModel model;
	
	
	/**
	* This constructor sets up the RiskGUI,
	* initializes all of the screen instance variables,
	* and sets the first screen to the start screen.
	* 
	* RiskGameModel model, Risk MVC model
	**/
	public RiskGUI (RiskGameModel model) {
		this.model = model;
		
		this.startScreen = new StartScreen(this.model);
		this.createNewGameScreen = new CreateNewGameScreen(this.model);
		this.loadSavedGameScreen = new LoadSavedGameScreen(this.model);
		this.initializePlayersScreen = new InitializePlayersScreen(this.model);
		this.initializeBoardScreen = new InitializeBoardScreen(this.model);
		this.placeArmiesScreen = new PlaceArmiesScreen(this.model);
		this.playerTurnScreen = new PlayerTurnScreen(this.model);
		this.turnInCardsScreen = new TurnInCardsScreen(this.model);
		this.placeArmiesSubScreen = new PlaceArmiesSubScreen(this.model);
		this.attackScreen = new AttackScreen(this.model);
		this.attackResultsScreen = new AttackResultsScreen(this.model);
		this.fortifyScreen = new FortifyScreen(this.model);
		
		this.currentScreen = this.startScreen;
		this.getContentPane().add(this.currentScreen);
		

	}
	
	
	/**
	* This method updates the JFrame to the appropriate screen
    *
	* Observable obs and Object obj are the classes being observed
	**/
	public void update(Observable obs, Object obj) {
		String screen = this.model.screenSet();
		
		if (screen.equals("createNewGame")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.createNewGameScreen;
			this.getContentPane().add(this.currentScreen);
            this.revalidate();
            this.repaint();
		}
		else if (screen.equals("loadSavedGame")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.loadSavedGameScreen;
			this.getContentPane().add(this.currentScreen);
            this.revalidate();
            this.repaint();
		}
		else if (screen.equals("initializePlayers")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.initializePlayersScreen;
			this.getContentPane().add(this.currentScreen);
            this.revalidate();
            this.repaint();
		}
		else if (screen.equals("initializeBoard")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.initializeBoardScreen;
			this.getContentPane().add(this.currentScreen);
			this.revalidate();
			this.repaint();
		}
		else if (screen.equals("placeArmies")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.placeArmiesScreen;
			this.getContentPane().add(this.currentScreen);
			this.revalidate();
			this.repaint();
		}
		else if (screen.equals("playerTurn")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.playerTurnScreen;
			this.getContentPane().add(this.currentScreen);
			this.revalidate();
			this.repaint();
		}
		else if (screen.equals("turnInCards")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.turnInCardsScreen;
			this.getContentPane().add(this.currentScreen);
			this.revalidate();
			this.repaint();
		}
		else if (screen.equals("placeArmiesTurn")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.placeArmiesSubScreen;
			this.getContentPane().add(this.currentScreen);
			this.revalidate();
			this.repaint();
		}
		else if (screen.equals("attack")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.attackScreen;
			this.getContentPane().add(this.currentScreen);
			this.revalidate();
			this.repaint();
		}
		else if (screen.equals("attackResults")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.attackResultsScreen;
			this.getContentPane().add(this.currentScreen);
			this.revalidate();
			this.repaint();
		}
		else if (screen.equals("fortify")) {
			this.getContentPane().remove(this.currentScreen);
			this.currentScreen = this.fortifyScreen;
			this.getContentPane().add(this.currentScreen);
			this.revalidate();
			this.repaint();
		}
	}
	
	/**
	* This method is the main method,
	* it initializes a GUI instance and a model instance
	*
	* String[] args, command line arguments
	**/
	public static void main(String[] args) {
		RiskGameModel gameModel = new RiskGameModel();
		RiskGUI gui = new RiskGUI(gameModel);
		gameModel.addObserver(gui);
		gui.setTitle("Risk");
		gui.setSize(800, 600);
		gui.setVisible(true);
		gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
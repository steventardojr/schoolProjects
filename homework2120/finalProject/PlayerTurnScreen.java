/**
* CSCI 2120 Fall 2014
* Risk Game Class PlayerTurnScreen
* Author: Steven Tardo
* Date: 12/10/14
**/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlayerTurnScreen extends JPanel {
	// Instance variables
    private JLabel playerLabel;
	private JButton nextScreen;
	private JButton saveGame;
	private int numberOfPlayers;
	private RiskGameModel model;

	/**
	* This constructor sets up the PlayerTurnScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public PlayerTurnScreen(RiskGameModel model) {
		this.model = model;
		this.numberOfPlayers = 2;
        PlayerTurnScreenListener handler = new PlayerTurnScreenListener(this.model);
        
        playerLabel = new JLabel("Player " + numberOfPlayers +"'s turn:");
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		saveGame = new JButton("Save Game");
		saveGame.addActionListener(handler);
		saveGame.setActionCommand("saveGame");
		
		this.setLayout(new GridLayout(3, 1));
		this.add(playerLabel);
		this.add(nextScreen);
		this.add(saveGame);
    }
	
	// This inner class is the PlayerTurnScreen controller
	public class PlayerTurnScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		private int numberOfPlayers;
		
		/**
		* This constructor sets up the PlayerTurnScreen
		*
		* RiskGameModel model, Risk MVC model
		**/
		public PlayerTurnScreenListener(RiskGameModel model) {
			this.model = model;
			this.numberOfPlayers = 2;
		}
		
		/**
		* This method handles ActionEvents from the PlayerTurnScreen
		*
		* ActionEvent e, ActionEvent from the PlayerTurn screen
		**/
	    public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.turnInCards();
			else if (command.equals("saveGame"))
				this.model.saveGame();
	    }
	}
}
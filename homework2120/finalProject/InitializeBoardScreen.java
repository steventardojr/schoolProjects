/**
* CSCI 2120 Fall 2014
* Risk Game Class InitializeBoardScreen
* Author: Steven Tardo
* Date: 12/10/14
**/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitializeBoardScreen extends JPanel {
	// Instance variables
    private JLabel playerLabel;
    private JComboBox territorySelect;
	private JButton nextScreen;
	private JButton saveGame;
	private int numberOfPlayers;
	private RiskGameModel model;
	private RiskGame game;

	/**
	* This constructor sets up the InitializeBoardScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public InitializeBoardScreen(RiskGameModel model) {
		this.model = model;
		this.game = this.model.getGame();
		this.numberOfPlayers = this.game.getNumberOfPlayers();
        InitializeBoardScreenListener handler = new InitializeBoardScreenListener(this.model);
        
        playerLabel = new JLabel(this.game.getPlayer1Name() + " pick a territory:");
		String[] territories = new String[42];
		for (int i = 0; i < 42; i++) {
			territories[i] = this.game.getTerritoryName(i);
		}
		territorySelect = new JComboBox<String>(territories);
		territorySelect.setSelectedIndex(0);
		territorySelect.addActionListener(handler);
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		saveGame = new JButton("Save Game");
		saveGame.addActionListener(handler);
		saveGame.setActionCommand("saveGame");
		
		this.setLayout(new GridLayout(4, 1));
		this.add(playerLabel);
		this.add(territorySelect);
		this.add(nextScreen);
		this.add(saveGame);
    }
	
	// This inner class is the InitializeBoardScreen controller
	public class InitializeBoardScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		private RiskGame game;
		private String selectedTerritory;
		private int numberOfPlayers;
		
		/**
		* This constructor sets up the InitializeBoardScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public InitializeBoardScreenListener(RiskGameModel model) {
			this.model = model;
			this.game = this.model.getGame();
			this.selectedTerritory = "";
			this.numberOfPlayers = this.game.getNumberOfPlayers();
		}
		
		/**
		* This method handles ActionEvents from the InitializeBoard screen
		*
		* ActionEvent e, ActionEvent from the InitializeBoard screen
		**/
	    public void actionPerformed(ActionEvent e) {
	        this.selectedTerritory = (String)territorySelect.getSelectedItem();
			
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.placeArmies();
			else if (command.equals("saveGame"))
				this.model.saveGame();
	    }
	}
}
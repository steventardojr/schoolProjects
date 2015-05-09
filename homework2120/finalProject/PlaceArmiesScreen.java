/**
* CSCI 2120 Fall 2014
* Risk Game Class PlaceArmiesScreen
* Author: Steven Tardo
* Date: 12/10/14
**/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PlaceArmiesScreen extends JPanel {
	// Instance variables
    private JLabel playerLabel;
    private JComboBox territorySelect;
	private JLabel armiesLabel;
	private JTextField armiesToPlace;
	private JButton nextScreen;
	private JButton saveGame;
	private int numberOfPlayers;
	private RiskGameModel model;

	/**
	* This constructor sets up the PlaceArmiesScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public PlaceArmiesScreen(RiskGameModel model) {
		this.model = model;
		this.numberOfPlayers = 2;
        PlaceArmiesScreenListener handler = new PlaceArmiesScreenListener(this.model);
        
        playerLabel = new JLabel("Player " + numberOfPlayers +" pick a territory:");
		String[] territories = {"2", "3", "4"};
		territorySelect = new JComboBox<String>(territories);
		territorySelect.setSelectedIndex(0);
		territorySelect.addActionListener(handler);
		
		armiesLabel = new JLabel("Enter how many armies to place on this territory:");
		armiesToPlace = new JTextField("0");
		armiesToPlace.setEnabled(true);
		armiesToPlace.addActionListener(handler);
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		saveGame = new JButton("Save Game");
		saveGame.addActionListener(handler);
		saveGame.setActionCommand("saveGame");
		
		this.setLayout(new GridLayout(6, 1));
		this.add(playerLabel);
		this.add(territorySelect);
		this.add(armiesLabel);
		this.add(armiesToPlace);
		this.add(nextScreen);
		this.add(saveGame);
    }
	
	// This inner class is the PlaceArmiesScreen controller
	public class PlaceArmiesScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		private String selectedTerritory;
		private int armies;
		private int numberOfPlayers;
		
		/**
		* This constructor sets up the PlaceArmiesScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public PlaceArmiesScreenListener(RiskGameModel model) {
			this.model = model;
			this.selectedTerritory = "";
			this.armies = 0;
			this.numberOfPlayers = 2;
		}
		
		/**
		* This method handles ActionEvents from the PlaceArmies screen
		*
		* ActionEvent e, ActionEvent from the PlaceArmies screen
		**/
	    public void actionPerformed(ActionEvent e) {
	        this.selectedTerritory = (String)territorySelect.getSelectedItem();
			this.armies = Integer.parseInt(armiesToPlace.getText());
			
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.playerTurn();
			else if (command.equals("saveGame"))
				this.model.saveGame();
	    }
	}
}
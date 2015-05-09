/**
* CSCI 2120 Fall 2014
* Risk Game Class FortifyScreen
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

public class FortifyScreen extends JPanel {
	// Instance variables
    private JLabel playerLabel;
	private JLabel fromTerritoryLabel;
    private JComboBox fromTerritorySelect;
	private JLabel toTerritoryLabel;
	private JComboBox toTerritorySelect;
	private JLabel armiesLabel;
	private JTextField armiesToPlace;
	private JButton nextScreen;
	private JButton saveGame;
	private int numberOfPlayers;
	private RiskGameModel model;

	/**
	* This constructor sets up the FortifyScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public FortifyScreen(RiskGameModel model) {
		this.model = model;
		this.numberOfPlayers = 2;
        FortifyScreenListener handler = new FortifyScreenListener(this.model);
        
        playerLabel = new JLabel("Player " + numberOfPlayers +", if you wish to fortify, select the territories and number of armies.");
	
		fromTerritoryLabel = new JLabel("Select the territory you wish to move armies from:");
		String[] fromTerritories = {"2", "3", "4"};
		fromTerritorySelect = new JComboBox<String>(fromTerritories);
		fromTerritorySelect.setSelectedIndex(0);
		fromTerritorySelect.addActionListener(handler);
		
		toTerritoryLabel = new JLabel("Select the territory you wish to move armies to:");
		String[] toTerritories = {"2", "3", "4"};
		toTerritorySelect = new JComboBox<String>(toTerritories);
		toTerritorySelect.setSelectedIndex(0);
		toTerritorySelect.addActionListener(handler);
		
		armiesLabel = new JLabel("Enter the number of armies you wish to risk");
		armiesToPlace = new JTextField("0");
		armiesToPlace.setEnabled(true);
		armiesToPlace.addActionListener(handler);
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		saveGame = new JButton("Save Game");
		saveGame.addActionListener(handler);
		saveGame.setActionCommand("saveGame");
		
		this.setLayout(new GridLayout(9, 1));
		this.add(playerLabel);
		this.add(fromTerritoryLabel);
		this.add(fromTerritorySelect);
		this.add(toTerritoryLabel);
		this.add(toTerritorySelect);
		this.add(armiesLabel);
		this.add(armiesToPlace);
		this.add(nextScreen);
		this.add(saveGame);
    }
	
	// This inner class is the FortifyScreen controller
	public class FortifyScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		private String selectedFromTerritory;
		private String selectedToTerritory;
		private int armies;
		private int numberOfPlayers;
		
		/**
		* This constructor sets up the FortifyScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public FortifyScreenListener(RiskGameModel model) {
			this.model = model;
			this.selectedFromTerritory = "";
			this.selectedToTerritory = "";
			this.armies = 0;
			this.numberOfPlayers = 2;
		}
		
		/**
		* This method handles ActionEvents from the Fortify screen
		*
		* ActionEvent e, ActionEvent from the Fortify screen
		**/
	    public void actionPerformed(ActionEvent e) {
	        this.selectedFromTerritory = (String)fromTerritorySelect.getSelectedItem();
			this.selectedToTerritory = (String)toTerritorySelect.getSelectedItem();
			this.armies = Integer.parseInt(armiesToPlace.getText());
			
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.attackResults();
			else if (command.equals("saveGame"))
				this.model.saveGame();
	    }
	}
}
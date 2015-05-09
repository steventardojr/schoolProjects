/**
* CSCI 2120 Fall 2014
* Risk Game Class PlaceArmiesSubScreen
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

public class PlaceArmiesSubScreen extends JPanel {
	// Instance variables
    private JLabel playerLabel;
	private JLabel numberOfArmiesLabel;
	private JLabel territoryLabel;
    private JComboBox territorySelect;
	private JLabel armiesLabel;
	private JTextField armiesToPlace;
	private JButton nextScreen;
	private JButton saveGame;
	private int numberOfPlayers;
	private int numberOfArmies;
	private RiskGameModel model;

	/**
	* This constructor sets up the PlaceArmiesSubScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public PlaceArmiesSubScreen(RiskGameModel model) {
		this.model = model;
		this.numberOfPlayers = 2;
        PlaceArmiesSubScreenListener handler = new PlaceArmiesSubScreenListener(this.model);
        
        playerLabel = new JLabel("Player " + numberOfPlayers +", you have armies to place");
		numberOfArmiesLabel = new JLabel("Number of armies to place: " + numberOfArmies);
		territoryLabel = new JLabel("Select a territory:");
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
		
		this.setLayout(new GridLayout(8, 1));
		this.add(playerLabel);
		this.add(numberOfArmiesLabel);
		this.add(territoryLabel);
		this.add(territorySelect);
		this.add(armiesLabel);
		this.add(armiesToPlace);
		this.add(nextScreen);
		this.add(saveGame);
    }
	
	// This inner class is the PlaceArmiesSubScreen controller
	public class PlaceArmiesSubScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		private String selectedTerritory;
		private int armies;
		private int numberOfPlayers;
		
		/**
		* This constructor sets up the PlaceArmiesSubScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public PlaceArmiesSubScreenListener(RiskGameModel model) {
			this.model = model;
			this.selectedTerritory = "";
			this.armies = 0;
			this.numberOfPlayers = 2;
		}
		
		/**
		* This method handles ActionEvents from the PlaceArmies subscreen
		*
		* ActionEvent e, ActionEvent from the PlaceArmies subscreen
		**/
	    public void actionPerformed(ActionEvent e) {
	        this.selectedTerritory = (String)territorySelect.getSelectedItem();
			this.armies = Integer.parseInt(armiesToPlace.getText());
			
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.attack();
	    }
	}
}
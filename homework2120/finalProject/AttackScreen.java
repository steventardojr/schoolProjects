/**
* CSCI 2120 Fall 2014
* Risk Game Class AttackScreen
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

public class AttackScreen extends JPanel {
	// Instance variables
    private JLabel playerLabel;
	private JLabel defendTerritoryLabel;
    private JComboBox defendTerritorySelect;
	private JLabel attackTerritoryLabel;
	private JComboBox attackTerritorySelect;
	private JLabel armiesLabel;
	private JTextField armiesToPlace;
	private JButton nextScreen;
	private int numberOfPlayers;
	private RiskGameModel model;

	/**
	* This constructor sets up the AttackScreen
	* and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public AttackScreen(RiskGameModel model) {
		this.model = model;
		this.numberOfPlayers = 2;
        AttackScreenListener handler = new AttackScreenListener(this.model);
        
        playerLabel = new JLabel("Player " + numberOfPlayers +", if you wish to attack, select the number of armies and territories.");
	
		defendTerritoryLabel = new JLabel("Select the territory you wish to attack from:");
		String[] defendTerritories = {"2", "3", "4"};
		defendTerritorySelect = new JComboBox<String>(defendTerritories);
		defendTerritorySelect.setSelectedIndex(0);
		defendTerritorySelect.addActionListener(handler);
		
		attackTerritoryLabel = new JLabel("Select the territory you wish to attack:");
		String[] attackTerritories = {"2", "3", "4"};
		attackTerritorySelect = new JComboBox<String>(attackTerritories);
		attackTerritorySelect.setSelectedIndex(0);
		attackTerritorySelect.addActionListener(handler);
		
		armiesLabel = new JLabel("Enter the number of armies you wish to risk");
		armiesToPlace = new JTextField("0");
		armiesToPlace.setEnabled(true);
		armiesToPlace.addActionListener(handler);
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		this.setLayout(new GridLayout(8, 1));
		this.add(playerLabel);
		this.add(defendTerritoryLabel);
		this.add(defendTerritorySelect);
		this.add(attackTerritoryLabel);
		this.add(attackTerritorySelect);
		this.add(armiesLabel);
		this.add(armiesToPlace);
		this.add(nextScreen);
    }
	
	// This inner class is the AttackScreen controller
	public class AttackScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		private String selectedDefendTerritory;
		private String selectedAttackTerritory;
		private int armies;
		private int numberOfPlayers;
		
		/**
		* This constructor sets up the AttackScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public AttackScreenListener(RiskGameModel model) {
			this.model = model;
			this.selectedDefendTerritory = "";
			this.selectedAttackTerritory = "";
			this.armies = 0;
			this.numberOfPlayers = 2;
		}
		
		/**
		* This method handles ActionEvents from the Attack screen
		*
		* ActionEvent e, ActionEven from the Attack Screen
		**/
	    public void actionPerformed(ActionEvent e) {
	        this.selectedDefendTerritory = (String)defendTerritorySelect.getSelectedItem();
			this.selectedAttackTerritory = (String)attackTerritorySelect.getSelectedItem();
			this.armies = Integer.parseInt(armiesToPlace.getText());
			
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.attackResults();
	    }
	}
}
/**
* CSCI 2120 Fall 2014
* Risk Game Class TurnInCardsScreen
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

public class TurnInCardsScreen extends JPanel {
	// Instance variables
    private JLabel playerLabel;
	private JComboBox card1;
	private JComboBox card2;
	private JComboBox card3;
	private JButton nextScreen;
	private JButton saveGame;
	private int numberOfPlayers;
	private RiskGameModel model;

	/**
	* This constructor sets up the TurnInCardsScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public TurnInCardsScreen(RiskGameModel model) {
		this.model = model;
        TurnInCardsScreenListener handler = new TurnInCardsScreenListener(this.model);
        
        playerLabel = new JLabel("Player " + numberOfPlayers + ", pick three cards to turn in:");
		
		String[] cards = {"2", "3", "4"};
		card1 = new JComboBox<String>(cards);
		card1.setSelectedIndex(0);
		card1.addActionListener(handler);
		
		card2 = new JComboBox<String>(cards);
		card2.setSelectedIndex(0);
		card2.addActionListener(handler);
		
		card3 = new JComboBox<String>(cards);
		card3.setSelectedIndex(0);
		card3.addActionListener(handler);
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		saveGame = new JButton("Save Game");
		saveGame.addActionListener(handler);
		saveGame.setActionCommand("saveGame");
		
		this.setLayout(new GridLayout(6, 1));
		this.add(playerLabel);
		this.add(card1);
		this.add(card2);
		this.add(card3);
		this.add(nextScreen);
		this.add(saveGame);
    }
	
	// This inner class is the TurnInCards controller
	public class TurnInCardsScreenListener implements ActionListener {
		// Instance variable
		private RiskGameModel model;
		
		/**
		* This constructor sets up the TurnInCards screen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public TurnInCardsScreenListener(RiskGameModel model) {
			this.model = model;
		}
		
		/**
		* This method handles ActionEvents from the TurnInCards screen
		*
		* ActionEvent e, ActionEvent from the TurnInCards screen
		**/
	    public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.placeArmiesTurn();
	    }
	}
}
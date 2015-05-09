/**
* CSCI 2120 Fall 2014
* Risk Game Class InitializePlayersScreen
* Author: Steven Tardo
* Date: 12/10/14
**/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InitializePlayersScreen extends JPanel {
	// Instance variables
    private JLabel player1Label;
    private JTextField player1Name;
    private JLabel player2Label;
    private JTextField player2Name;
    private JLabel player3Label;
    private JTextField player3Name;
    private JLabel player4Label;
    private JTextField player4Name;
	private JButton nextScreen;
	private JButton saveGame;
	private int numberOfPlayers;
	private RiskGameModel model;

	/**
	* This constructor sets up the InitializePlayersScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public InitializePlayersScreen(RiskGameModel model) {
		this.model = model;
		this.numberOfPlayers = 2;
        InitializePlayersScreenListener handler = new InitializePlayersScreenListener(this.model);
        
        player1Label = new JLabel("Player1:");
		player1Name = new JTextField();
		player1Name.setEnabled(true);
		player1Name.addActionListener(handler);
		
        player2Label = new JLabel("Player2:");
		player2Name = new JTextField();
		player2Name.setEnabled(true);
		player2Name.addActionListener(handler);
		
        player3Label = new JLabel("Player3:");
		player3Name = new JTextField();
		if (this.numberOfPlayers == 3) {
			player3Name.setEnabled(true);
		    player3Name.addActionListener(handler);
		}
		else
			player3Name.setEnabled(false);
		
        player4Label = new JLabel("Player4:");
		player4Name = new JTextField();
		if (this.numberOfPlayers == 4) {
			player4Name.setEnabled(true);
			player4Name.addActionListener(handler);
		}
		else
			player4Name.setEnabled(false);
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		saveGame = new JButton("Save Game");
		saveGame.addActionListener(handler);
		saveGame.setActionCommand("saveGame");
		
		this.setLayout(new GridLayout(10, 1));
		this.add(player1Label);
		this.add(player1Name);
		this.add(player2Label);
		this.add(player2Name);
		this.add(player3Label);
		this.add(player3Name);
		this.add(player4Label);
		this.add(player4Name);
		this.add(nextScreen);
		this.add(saveGame);
    }
	
	// This inner class is the InitalizePlayersScreen controller
	public class InitializePlayersScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		private String name1;
		private String name2;
		private String name3;
		private String name4;
		private int numberOfPlayers;
		
		/**
		* This constructor sets up the InitializePlayersScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public InitializePlayersScreenListener(RiskGameModel model) {
			this.model = model;
			this.name1 = "";
			this.name2 = "";
			this.name3 = "";
			this.name4 = "";
			this.numberOfPlayers = 2;
		}
		
		/**
		* This constructor handles ActionEvents from the InitializePlayers screen
		*
		* ActionEvent e, ActionEvent from the IntializePlayers screen
		**/
	    public void actionPerformed(ActionEvent e) {
	        this.name1 = player1Name.getText();
			this.name2 = player2Name.getText();
			
			if (this.numberOfPlayers == 3) {
				this.name3 = player3Name.getText();
			}
			
			if (this.numberOfPlayers == 4) {
				this.name4 = player4Name.getText();
			}
			
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.initializeBoard();
	    }
	}
}
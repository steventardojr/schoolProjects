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
    private JLabel player5Label;
    private JTextField player5Name;
    private JLabel player6Label;
    private JTextField player6Name;
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
		RiskGame game = this.model.getGame();
		int numberOfPlayers = game.getNumberOfPlayers();
        InitializePlayersScreenListener handler = new InitializePlayersScreenListener(this.model);
        
        player1Label = new JLabel("Player 1:");
		player1Name = new JTextField();
		player1Name.setEnabled(true);
		player1Name.addActionListener(handler);
		
        player2Label = new JLabel("Player 2:");
		player2Name = new JTextField();
		player2Name.setEnabled(true);
		player2Name.addActionListener(handler);
		
        player3Label = new JLabel("Player 3:");
		player3Name = new JTextField();
		player3Name.setEnabled(true);
		player3Name.addActionListener(handler);
		
        player4Label = new JLabel("Player 4:");
		player4Name = new JTextField();
		if (numberOfPlayers >= 4)
			player4Name.setEnabled(true);
		else
			player4Name.setEnabled(false);
		player4Name.addActionListener(handler);
		
        player5Label = new JLabel("Player 5:");
		player5Name = new JTextField();
		if (numberOfPlayers >= 5)
			player5Name.setEnabled(true);
		else
			player5Name.setEnabled(false);
		player5Name.addActionListener(handler);
		
        player6Label = new JLabel("Player 6:");
		player6Name = new JTextField();
		if (numberOfPlayers >= 6)
			player6Name.setEnabled(true);
		else
			player6Name.setEnabled(false);
		player6Name.addActionListener(handler);
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		saveGame = new JButton("Save Game");
		saveGame.addActionListener(handler);
		saveGame.setActionCommand("saveGame");
		
		this.setLayout(new GridLayout(14, 1));
		this.add(player1Label);
		this.add(player1Name);
		this.add(player2Label);
		this.add(player2Name);
		this.add(player3Label);
		this.add(player3Name);
		this.add(player4Label);
		this.add(player4Name);
		this.add(player5Label);
		this.add(player5Name);
		this.add(player6Label);
		this.add(player6Name);
		this.add(nextScreen);
		this.add(saveGame);
    }
	
	// This inner class is the InitalizePlayersScreen controller
	public class InitializePlayersScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		private RiskGame game;
		private String name1;
		private String name2;
		private String name3;
		private String name4;
		private String name5;
		private String name6;
		
		/**
		* This constructor sets up the InitializePlayersScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public InitializePlayersScreenListener(RiskGameModel model) {
			this.model = model;
			this.game = this.model.getGame();
			this.name1 = "";
			this.name2 = "";
			this.name3 = "";
			this.name4 = "";
			this.name5 = "";
			this.name6 = "";
		}
		
		/**
		* This constructor handles ActionEvents from the InitializePlayers screen
		*
		* ActionEvent e, ActionEvent from the IntializePlayers screen
		**/
	    public void actionPerformed(ActionEvent e) {
	        this.name1 = player1Name.getText();
			this.name2 = player2Name.getText();
			this.name3 = player3Name.getText();
			if (numberOfPlayers >= 4) {
				this.name4 = player4Name.getText();
			}
			if (numberOfPlayers >= 5) {
				this.name5 = player4Name.getText();
			}
			if (numberOfPlayers >= 6) {
				this.name6 = player4Name.getText();
			}
			
			this.game.setPlayer1Name(this.name1);
			this.game.setPlayer2Name(this.name1);
			this.game.setPlayer3Name(this.name1);
			this.game.setPlayer4Name(this.name1);
			this.game.setPlayer5Name(this.name1);
			this.game.setPlayer6Name(this.name1);
			
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.initializeBoard();
			else if (command.equals("saveGame"))
				this.model.saveGame();
	    }
	}
}
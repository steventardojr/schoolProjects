/**
* CSCI 2120 Fall 2014
* Risk Game Class CreateNewGameScreen
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

public class CreateNewGameScreen extends JPanel {
	// Instance variables
    private JLabel createNewGameLabel;
    private JTextField gameName;
	private JLabel numberOfPlayersLabel;
	private JComboBox<Integer> numberOfPlayersMenu;
	private JButton nextScreen;
	private RiskGameModel model;

	/**
	* This constructor sets up the CreateNewGameScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public CreateNewGameScreen(RiskGameModel model) {
		this.model = model;
        CreateNewGameScreenListener handler = new CreateNewGameScreenListener(this.model);
        
        createNewGameLabel = new JLabel("Enter a name for the game:");
		gameName = new JTextField();
		gameName.setEnabled(true);
		gameName.addActionListener(handler);

        numberOfPlayersLabel = new JLabel("Choose the number of players:");
		Integer[] players = {2, 3, 4};
		numberOfPlayersMenu = new JComboBox<Integer>(players);
		numberOfPlayersMenu.setSelectedIndex(0);
		numberOfPlayersMenu.addActionListener(handler);
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		this.setLayout(new GridLayout(5, 1));
		this.add(createNewGameLabel);
		this.add(gameName);
		this.add(numberOfPlayersLabel);
		this.add(numberOfPlayersMenu);
		this.add(nextScreen);
    }
	
	// This inner class is the CreateNewGameScreen controller
	public class CreateNewGameScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		private String name;
		private Integer numberOfPlayers;
		
		/**
		* This constructor sets up the AttackScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public CreateNewGameScreenListener(RiskGameModel model) {
			this.model = model;
			this.name = "";
			this.numberOfPlayers = 2;
		}
		
		/**
		* This method handles ActionEvents from the CreateNewGame screen
		*
		* ActionEvent e, ActionEvent from the CreateNewGame screen
		**/
	    public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
		        this.name = gameName.getText();
				this.numberOfPlayers = (Integer)numberOfPlayersMenu.getSelectedItem();
				this.model.initializePlayers();
	    }

	}
}
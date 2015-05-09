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
	private RiskGameModel model;
	private Integer numberOfPlayers;

	/**
	* This constructor sets up the CreateNewGameScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public CreateNewGameScreen(RiskGameModel model) {
		this.model = model;
        CreateNewGameScreenListener handler = new CreateNewGameScreenListener(this.model);

        numberOfPlayersLabel = new JLabel("Choose the number of players:");
		Integer[] players = {3, 4, 5, 6};
		numberOfPlayersMenu = new JComboBox<Integer>(players);
		numberOfPlayersMenu.addActionListener(handler);
		
        createNewGameLabel = new JLabel("Enter a name for the game:");
		gameName = new JTextField();
		gameName.setEnabled(true);
		gameName.addActionListener(handler);
		
		this.setLayout(new GridLayout(4, 1));
		this.add(createNewGameLabel);
		this.add(gameName);
		this.add(numberOfPlayersLabel);
		this.add(numberOfPlayersMenu);
    }
	
	// This inner class is the CreateNewGameScreen controller
	public class CreateNewGameScreenListener implements ActionListener {
		// Instance variables
		private RiskGameModel model;
		
		/**
		* This constructor sets up the AttackScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public CreateNewGameScreenListener(RiskGameModel model) {
			this.model = model;
		}
		
		/**
		* This method handles ActionEvents from the CreateNewGame screen
		*
		* ActionEvent e, ActionEvent from the CreateNewGame screen
		**/
	    public void actionPerformed(ActionEvent e) {
			numberOfPlayers = (Integer)numberOfPlayersMenu.getSelectedItem();
			String name = gameName.getText();
			this.model.makeGame(name);
			RiskGame game = this.model.getGame();
			game.setNumberOfPlayers(numberOfPlayers);
			this.model.initializePlayers();
	    }
	}
}
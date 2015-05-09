/**
* CSCI 2120 Fall 2014
* Risk Game Class StartScreen
* Author: Steven Tardo
* Date: 12/10/14
**/

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StartScreen extends JPanel {
	// Instance variables
    private JButton createNewGameButton;
    private JButton loadSavedGameButton;
	private RiskGameModel model;

	/**
	* This constructor sets up the StartScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public StartScreen(RiskGameModel model) {
		this.model = model;
        StartScreenListener handler = new StartScreenListener(this.model);
        
        createNewGameButton = new JButton("New Game");
		createNewGameButton.addActionListener(handler);
        createNewGameButton.setActionCommand("createNewGame");

        loadSavedGameButton = new JButton("Load Game");
        loadSavedGameButton.addActionListener(handler);
		loadSavedGameButton.setActionCommand("loadSavedGame");
        
		this.setLayout(new GridLayout(2, 1));
		this.add(createNewGameButton);
		this.add(loadSavedGameButton); 
    }
	
	// This inner class is the StartScreen controller
	public class StartScreenListener implements ActionListener {
		// Instance variable
		private RiskGameModel model;
		
		/**
		* This constructor sets up the StartScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public StartScreenListener(RiskGameModel model) {
			this.model = model;
		}
		
		/**
		* This method handles ActionEvents from the Start screen
		*
		* ActionEvent e, ActionEven from the Start screen
		**/
	    public void actionPerformed(ActionEvent e) {
	        String command = e.getActionCommand();

	        if (command.equals("createNewGame"))
	            this.model.createNewGame();
	        else if (command.equals("loadSavedGame"))
	            this.model.loadSavedGame();
	    }

	}
}
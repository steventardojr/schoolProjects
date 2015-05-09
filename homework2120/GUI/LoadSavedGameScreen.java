/**
* CSCI 2120 Fall 2014
* Risk Game Class LoadSavedGameScreen
* Author: Steven Tardo
* Date: 12/10/14
**/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoadSavedGameScreen extends JPanel {
	// Instance variables
    private JLabel loadLabel;
	private JFileChooser loadGame;
	private JButton nextScreen;
	private RiskGameModel model;

	/**
	* This constructor sets up the LoadSavedGameScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public LoadSavedGameScreen(RiskGameModel model) {
		this.model = model;
        LoadSavedGameScreenListener handler = new LoadSavedGameScreenListener(this.model);
        
        loadLabel = new JLabel("Load Game:");
		loadGame = new JFileChooser();
		loadGame.addActionListener(handler);
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		this.setLayout(new GridLayout(3, 1));
		this.add(loadLabel);
		this.add(loadGame);
		this.add(nextScreen);
    }
	
	// This inner class is the LoadSavedGameScreen controller
	public class LoadSavedGameScreenListener implements ActionListener {
		private RiskGameModel model;
		
		/**
		* This constructor sets up the LoadSavedGame controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public LoadSavedGameScreenListener(RiskGameModel model) {
			this.model = model;
		}
		
		/**
		* This method handles ActionEvents from the LoadSavedGame screen
		*
		* ActionEvent e, ActionEvent from the LoadSavedGame screen
		**/
	    public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.loadSavedGame();
	    }
	}
}
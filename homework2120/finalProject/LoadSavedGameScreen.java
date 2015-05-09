/**
* CSCI 2120 Fall 2014
* Risk Game Class LoadSavedGameScreen
* Author: Steven Tardo
* Date: 12/10/14
**/

import javax.swing.JPanel;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.GridLayout;

public class LoadSavedGameScreen extends JPanel {
	// Instance variables
	private JFileChooser loadGame;
	private RiskGameModel model;

	/**
	* This constructor sets up the LoadSavedGameScreen and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public LoadSavedGameScreen(RiskGameModel model) {
		this.model = model;
		loadGame = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter(".ser Files", "ser");
		loadGame.setFileFilter(filter);
		int load = loadGame.showOpenDialog(loadGame);
		if (load == JFileChooser.APPROVE_OPTION)
			this.model.loadGame(loadGame.getSelectedFile().getName());
    }
}
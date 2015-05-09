/**
* CSCI 2120 Fall 2014
* Risk Game Class AttackResultsScreen
* Author: Steven Tardo
* Date: 12/10/14
**/

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AttackResultsScreen extends JPanel {
	// Instance Variables
    private JLabel attackRollLabel;
	private JLabel defendRollLabel;
	private JLabel result;
	private JButton nextScreen;
	private int[] attackRolls;
	private int[] defendRolls;
	private int attackRoll;
	private int defendRoll;
	private int numberOfPlayers;
	private RiskGameModel model;

	/**
	* This constructor sets up the AttackResultsScreen
	* and its handler
	*
	* RiskGameModel model, Risk MVC model
	**/
    public AttackResultsScreen(RiskGameModel model) {
		this.model = model;
		this.attackRolls = new int[1];
		this.defendRolls = new int[1];
		this.attackRoll = 0;
		this.defendRoll = 0;
		this.numberOfPlayers = 2;
        AttackResultsScreenListener handler = new AttackResultsScreenListener(this.model);
        
        attackRollLabel = new JLabel("Attack Roll: " + attackRoll);
		defendRollLabel = new JLabel("Defend Roll: " + defendRoll);
		result = new JLabel("You win!");
		
		nextScreen = new JButton("Continue");
		nextScreen.addActionListener(handler);
		nextScreen.setActionCommand("nextScreen");
		
		this.setLayout(new GridLayout(4, 1));
		this.add(attackRollLabel);
		this.add(defendRollLabel);
		this.add(result);
		this.add(nextScreen);
    }
	
	// This inner class is the controller for the AttackResultsScreen
	public class AttackResultsScreenListener implements ActionListener {
		// Instance variable
		private RiskGameModel model;
		
		/**
		* This constructor sets up the AttackResultsScreen controller
		*
		* RiskGameModel model, Risk MVC model
		**/
		public AttackResultsScreenListener(RiskGameModel model) {
			this.model = model;
		}
		
		/**
		* This method handles ActionEvents from the AttackResults screen
		*
		* ActionEvent e, ActionEvent from AttackResults screen
		**/
	    public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("nextScreen"))
				this.model.fortify();
	    }
	}
}
import java.util.Random;
import java.io.Serializable;

/**
* CSCI 2120 Fall 2014
* Risk Game Class Dice
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class Dice implements Serializable {
	// Instance variable
	private Random die;
	
	// Constructor
	public Dice() {
		this.die = new Random();
	}
	
	/**
	* Simulates a dice roll based on the number
	* of dice the attacker chooses to roll.
	* Each roll is placed in an array of ints
	* with the first values being each of the
	* attacker's rolls and the second values
	* being the defender's rolls
	*
	* return type int[], dice rolls for attacker and defender
	**/
	public int[] roll( int attacking, int defending ) {
		int numberOfDice = attacking + defending;
		int[] roll = new int[numberOfDice];
		for (int i = 0; i < attacking; i++) {
			roll[i] = die.nextInt(6) + 1;
		}
		for (int i = attacking; i < (attacking + defending); i++) {
			roll[i] = die.nextInt(6) + 1;
		}
		return roll;
	}
}

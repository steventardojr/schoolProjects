import java.util.Random;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class DiceTest
* Authors: Steven Tardo
* Date: 10/21/14
**/

public class DiceTest extends TestCase {
	private Dice test;
	
	protected void setup() {
		test = new Dice();
	}
	
	public void testRoll() {
		int[] rollTest;
		int i = 0;
		int j = 0;
		rollTest = test.roll(i, j);
		assertTrue(rollTest == null);
	}
	
}

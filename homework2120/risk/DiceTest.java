import java.util.Random;
import junit.framework.TestCase;

/**
* CSCI 2120 Fall 2014
* Risk Game Class DiceTest
* Authors: Steven Tardo
* Date: 11/4/14
**/

public class DiceTest extends TestCase {
	private Dice test;
	
	public void testRoll() {
		test = new Dice();
		int[] rollTest = test.roll(3, 2);
		assertTrue(rollTest[0] >= 0 && rollTest[0] <= 6);
		assertTrue(rollTest[1] >= 0 && rollTest[1] <= 6);
		assertTrue(rollTest[2] >= 0 && rollTest[2] <= 6);
		assertTrue(rollTest[3] >= 0 && rollTest[3] <= 6);
		assertTrue(rollTest[4] >= 0 && rollTest[4] <= 6);
		assertFalse(rollTest[0] < 0);
		assertFalse(rollTest[0] > 6);
	}
	
}

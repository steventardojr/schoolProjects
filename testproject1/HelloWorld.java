import java.util.*;


/**
 * Prints Hello, world! to the screen, and squares a number.
 * This program will first print Hello, world! to the screen,
 * then square the integer 2 and print the result to the screen.
 * @author Steven Tardo
 * @version 1.0
 * @date 11/10/14
 **/
public class HelloWorld {
	/**
	 * The main method of the program.
	 * This method is the first method to execute when the program is run.
	 * @param args is an array of Strings that are the command line arguments.
	 * @see squareNumber()
	 **/
	public static void main(String[] args) {
		// Prints Hello, world! to the screen
		System.out.println("Hello, world!");
		int x = squareNumber(2);
		System.out.println(x);
	}
	
	/**
	 * This method squares the parameter.
	 * This method will take a parameter of int, square it, and return the result.
	 * @param numberToSquare is an int, it will be squared.
	 * @return the result of squaring numberToSquare.
	 **/
	public static int squareNumber(int numberToSquare) {
		return numberToSquare*numberToSquare;
	}
}
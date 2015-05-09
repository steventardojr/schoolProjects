import java.lang.Character;
import java.lang.String;
import java.util.Stack;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.Math;

public class PostFixCalc {
	public static void main(String[] args) throws FileNotFoundException {
		String infixExp = ""; // String to hold user's infix expression
		String postfixExp = ""; // String to hold the converted postfix expression for evaluation
		double result = 0; // Double to hold the result of the evaluation
		
		/**
		 * The following code block prints an error message if there's no command-line argument,
	     * removes the whitespace, and places the
		 * command-line argument into the String infixExp.
		 **/
		if (args.length == 0) {
			System.out.println("Rerun program with the correct command-line argument.");
			System.out.println("See readme.");
			System.exit(0);
		}
		for (String s: args)
			infixExp += s;
		infixExp += '$'; // End marker for infix expression
		
		/**
		 * Variables needed to print to a file and to switch
		 * between printing to the file and the terminal
		**/
		PrintStream terminal = System.out;
		File file = new File("output.txt");
		FileOutputStream output = new FileOutputStream(file);
		PrintStream toFile = new PrintStream(output);
		
		/**
		 * Call the method that converts the infix expression
		 * to a postfix expression
		 **/
		System.setOut(toFile);
		System.out.println("Infix to Postfix Steps:\n");
		postfixExp = infixToPostfix(infixExp);
		System.out.println("\n");
		
		// Call the method that evaluates the postfix expression
		System.out.println("Postfix Evaluation:\n");
		result = postfixEval(postfixExp);
		
		// Print confirmation message if program runs successfully
		System.setOut(terminal);
		System.out.println("The program ran successfully.");
		System.out.println("See output.txt for details.");
		System.out.println("The result is " + result + ".");
		
		// Print the result of the evaluation to the output file
		System.setOut(toFile);
		System.out.println("\n");
		System.out.println("Result:  " + result);
	}
	
	
	/**
	 * This method converts the input infix expression to a postfix
	 * and returns it as a string
	 **/
	public static String infixToPostfix(String infixExp) {
		String postfixExp = ""; // Variable to hold postfix expression as it's built
		Stack<Character> infixStack = new Stack<Character>(); // Intermediate stack
		infixStack.push('#'); // Insert bottom marker for stack
		Character infixChar = new Character(' '); // Character to hold each token as it's scanned
		int i = 0; // Counter
		
		// Check to see if first value is unary "-"
		if (infixExp.charAt(0) == '-') {
			postfixExp+=(infixExp.charAt(0));
			i = 1;
		}
		
		// Scan each token of the infix expression
		while (i < infixExp.length()-1) {
			infixChar = infixExp.charAt(i); // Variable for token being scanned
			
			// Handle beginning parenthesis
			if (infixChar == '(') {
				infixStack.push(infixChar);
				i++;
			}
			
			// Handle end parenthesis
			else if (infixChar == ')') {
				while (infixStack.peek() != '(')
					postfixExp += infixStack.pop();
				infixStack.pop(); // Delete beginning parenthesis from stack
				i++;
			}
			
			// Handle operators and operands
			else {
				System.out.println("Infix:   " + infixExp); // Print details of operation
				
				if (Character.getNumericValue(infixChar) >= 0 && Character.getNumericValue(infixChar) <= 9) {
					postfixExp += infixChar; // Add operand to postfix expression
				}
				else if (infixChar == '^') {
					infixStack.push(infixChar); // Push token onto stack
				}
				else if (infixChar == '*' || infixChar == '/') {
					while (infixStack.peek() == '^') // Pop tokens off of stack until lower precedence
						postfixExp += infixStack.pop();
					infixStack.push(infixChar); // Push token onto stack
				}
				else if (infixChar == '+' || infixChar == '-') {
					// Pop tokens off of stack until lower precedence
					while (infixStack.peek() == '*' || infixStack.peek() == '/' || infixStack.peek() == '^')
						postfixExp += infixStack.pop();
					infixStack.push(infixChar); // Push token onto stack
				}
				
				//Print details of operation
				System.out.println("Stack:   " + infixStack.toString());
				System.out.println("Postfix: " + postfixExp);
				System.out.println();
				
				i++; // Iterate to next token
			}
			
			
		}
		
		// Once all tokens have been read, pop remaining operators off of stack
		while (infixStack.peek() != '#')
			postfixExp += infixStack.pop();
		
		// Print details of operation
		System.out.println("Infix:   " + infixExp);
		System.out.println("Stack:   " + infixStack.toString());
		System.out.println("Postfix: " + postfixExp);
		System.out.println();
		
		// Return completed postfix expression
		return postfixExp;
	}
	
	/**
	 * This method evaluates the postfix expression and
	 * returns the result as a double
	 **/
	public static double postfixEval(String postfixExp) {
		double result = 0; // Variable for end result
		int i = 0; // Counter
		double operand1 = 0; // Variable for first operand during evaluation
		double operand2 = 0; // Variable for second operand during evaluation
		double stackResult = 0; // Variable for temporary result of evaluation to be pushed to stack
		postfixExp+='$'; // End marker for postfix expression
		Stack<String> postfixStack = new Stack<String>(); // Intermediate stack
		postfixStack.push("#"); // Insert bottom marker for stack
		Character postfixChar = new Character(' '); // Character to hold each token as it's scanned
		
		// If first token is unary "-" make second token negative
		postfixChar = postfixExp.charAt(i); // Variable for token being scanned
		if (postfixChar == '-') {
			String negative = "-";
			negative += postfixExp.charAt(i+1);
			postfixStack.push(negative);
			i=2; // Iterate to next token
		}
		
		// Scan each token of the postfix expression
		while (i < postfixExp.length()-1) {
			postfixChar = postfixExp.charAt(i);
			
			// Push operands onto stack 
			if (Character.getNumericValue(postfixChar) >= 0 && Character.getNumericValue(postfixChar) <= 9) {
				postfixStack.push(postfixChar.toString());
			}
			
			// If operator is encountered, perform operation on top two operands in stack
			else {
				operand2 = Double.parseDouble(postfixStack.pop());
				operand1 = Double.parseDouble(postfixStack.pop());
				if (postfixChar == '^')
					stackResult = Math.pow(operand1, operand2);
				else if (postfixChar == '*')
					stackResult = operand1 * operand2;
				else if (postfixChar == '/')
					stackResult = operand1/operand2;
				else if (postfixChar == '+')
					stackResult = operand1 + operand2;
				else if (postfixChar == '-')
						stackResult = operand1 - operand2;
				// Push result of operation to the stack
				postfixStack.push(Double.toString(stackResult));
			}
			
			// Print details of operation
			System.out.println("Postfix: " + postfixExp);
			System.out.println("Stack:   " + postfixStack.toString());
			System.out.println();
			i++; // Iterate to next token
		}
		
		// Pop final result from stack and return result
		result = Double.parseDouble(postfixStack.pop());
		return result;
	}
}
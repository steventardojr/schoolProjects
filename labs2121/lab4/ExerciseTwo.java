import java.util.Scanner;

public class ExerciseTwo {
    public static void main (String[] args) {
    	int fib1, fib2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter an integer to calculate the Fibonacci number:");
		
		fib1 = sc.nextInt();
		fib2=fibonacci(fib1);
		
		System.out.println("The Fibonacci number of " + fib1 + " is " + fib2);
    }
	
	public static int fibonacci(int n) {
		if(n==0)
			return 0;
		else if(n==1)
			return n;
		else
			return fibonacci(n-1) + fibonacci(n-2);
	}
}
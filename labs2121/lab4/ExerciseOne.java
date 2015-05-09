import java.util.Scanner;

public class ExerciseOne {
    public static void main (String[] args) {
    	int factorial1, factorial2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter an integer to calculate factorial:");
		
		factorial1 = sc.nextInt();
		factorial2=factorial(factorial1);
		
		System.out.println("The factorial of " + factorial1 + " is " + factorial2);
    }
	
	public static int factorial(int n) {
		if(n==0)
			return 1;
		else if(n==1)
			return n;
		else
			return n*(factorial(n-1));
	}
}
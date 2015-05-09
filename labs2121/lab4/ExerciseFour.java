import java.util.Scanner;

public class ExerciseFour {
    public static void main (String[] args) {
    	int evenOrOdd1;
		boolean evenOrOdd2;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter an integer to determine even or odd:");
		
		evenOrOdd1 = sc.nextInt();
		evenOrOdd2=isEven(evenOrOdd1);
		
		if(evenOrOdd2 == true)
			System.out.println(evenOrOdd1 + " is even");
		else
			System.out.println(evenOrOdd1 + " is odd");
    }
	
	public static boolean isEven(int n) {
		if(n==0)
			return true;
		else
			return isOdd(n-1);
	}
	
	public static boolean isOdd(int n) {
		if(n==0)
			return false;
		else
			return isEven(n-1);
	}
}
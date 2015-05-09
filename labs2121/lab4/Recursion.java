public class Recursion {
    public static void main (String[] args) {
    	int sum1=sum(10);
    }
	
	public static int sum(int n) {
		if(n==1)
			return n;
		else
			return n+sum(n-1);
	}
}
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseOne {
	public static void main(String[] args) {
		ObjectInputStream reader = null;
		ArrayList<Integer> data = new ArrayList<Integer>();
		Scanner sc = new Scanner( System.in );
		Integer location = 0;
		
		try
		{
			reader = new ObjectInputStream( new FileInputStream( "data.ser" ) );
			data  = ( ArrayList<Integer> ) reader.readObject();
			reader.close();
		}
		catch( IOException e )
		{
			System.out.println( "Couldn't read serialized file" );
		}
		catch( ClassNotFoundException e )
		{
			System.out.println( "Couldn't find class" );
		}
		System.out.println("Please enter a number to search for:");
		Integer userInput = sc.nextInt();
		location = linearSearch(userInput, data);
		System.out.println("The number is at index " + location);
	}
	
	public static int linearSearch(Integer check, ArrayList<Integer> list) {
		int location=-1;
		for (int i = 0; i<list.size(); i++) {
			if (list.get(i).equals(check))
				return i;
		}
		return -1;
	}
}
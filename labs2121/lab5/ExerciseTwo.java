import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ExerciseTwo {
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
		SelectionSort sorter = new SelectionSort(data);
		sorter.sort(0);
		System.out.println(data);
	}
}
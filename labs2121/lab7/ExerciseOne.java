import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.ClassNotFoundException;
import java.util.*;

public class ExerciseOne {
	public static void main(String[] args) {
		ObjectInputStream reader = null;
		ArrayList<Country> list = new ArrayList<Country>();
		
		try
		{
			reader = new ObjectInputStream( new FileInputStream( "countries.ser" ) );
			list  = ( ArrayList<Country> ) reader.readObject();
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
		
		HashMap<String, Country> map = new HashMap<String, Country>();
		for (Country country: list) {
			map.put(country.getName(), country);
		}
		
		for(String key : map.keySet()) {
			Country country = map.get(key);
			System.out.println(country);
		}
	}
}
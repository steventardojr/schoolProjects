import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.ClassNotFoundException;


public class Calendar2
{

    public static void main( String[] args )
    {

		String name = null;
		String date = null;
		String location = null;
		String description = null;
		String blank = null;
		BufferedReader reader = null;
		
		try
		{
			reader = new BufferedReader( new FileReader("eventData.txt"));
			do {
				name = reader.readLine();
				date = reader.readLine();
				location = reader.readLine();
				description = reader.readLine();
				blank = reader.readLine();
				Event event = new Event(name, date, location, description);
				System.out.println(event.toString() + "\n");
			} while (blank != null);
			reader.close();
			
		}
		catch( IOException e )
		{
			System.out.println( "Couldn't read text file" );
		}
        
    }


}
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;


public class Calendar
{

    public static void main( String[] args )
    {

        Event party = new Event( "Redmann's Party", "2014-03-03 22:00", "Redmann's House", "Come pass a good time" );

        Event test = new Event( "CSCI 2120 Test", "2014-03-24 16:30", "MATH 226", "2nd Test" );

        System.out.println( party.getName() );
        System.out.println( party.getDate() );
        System.out.println( party.getLocation() );
        System.out.println( party.getDescription() );
		
		FileOutputStream fileWriter;
		ObjectOutputStream writer = null;
		
		try
		{
			writer = new ObjectOutputStream( new FileOutputStream( "events.ser" ) );
				
		}
		catch( IOException e )
		{
			System.out.println( "Couldn't create serialized file" );
		}
		
		try
		{
			writer.writeObject( party );
			writer.writeObject( test );
			writer.flush();
			writer.close();
				
		}
		catch( IOException e )
		{
			System.out.println( "Couldn't write to serialized file" );
		}
        
    }


}
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import java.lang.ClassNotFoundException;


public class Calendar1
{

    public static void main( String[] args )
    {

        Event party;
		Event test;
		ObjectInputStream reader = null;
		
		try
		{
			reader = new ObjectInputStream( new FileInputStream( "events.ser" ) );
			party  = ( Event ) reader.readObject();
			test = ( Event ) reader.readObject();
			reader.close();
			
			System.out.println( party.getName() );
			System.out.println( party.getDate() );
			System.out.println( party.getLocation() );
			System.out.println( party.getDescription() );
			System.out.println( test.getName() );
			System.out.println( test.getDate() );
			System.out.println( test.getLocation() );
			System.out.println( test.getDescription() );
		}
		catch( IOException e )
		{
			System.out.println( "Couldn't read serialized file" );
		}
		catch( ClassNotFoundException e )
		{
			System.out.println( "Couldn't find class" );
		}
        
    }


}
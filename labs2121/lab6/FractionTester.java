import java.util.Scanner;

public class FractionTester
{

    public static void main( String[] args )
    {

        Scanner input = new Scanner( System.in );

        Fraction result;
        int numerator;
        int denominator;

        Fraction x = new Fraction( 3, 4);
        Fraction y = new Fraction( 2, 5 );

        result = x.add( y );
        System.out.println( x + " + " + y + " = " + result );

        result = x.subtract( y );
        System.out.println( x + " - " + y + " = " + result );

        x = x.multiply( y );
        System.out.println( x + " * " + y + " = " + x );
        
        y = y.divide( x );
        System.out.println( y + " / " + x + " = " + y );


        

    }


}
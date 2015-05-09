import javax.swing.JFrame;

public class CalculatorApp
{

    public static void main( String[] args )
    {
        CalculatorModel model = new CalculatorModel();
        CalculatorGUI gui = new CalculatorGUI( model );

        gui.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        gui.setSize( 400, 600 );
        gui.setVisible( true );
    }


}
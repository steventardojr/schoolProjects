import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.lang.StringBuilder;

public class CalculatorGUI extends JFrame
{

    private JButton addButton;
    private JButton subButton;
    private JButton mulButton;
    private JButton divButton;
    private JButton modButton;
    private JButton decButton;
    private JButton acButton;
    private JButton eqButton;
    private JButton signButton;
    private JButton dzeroButton;
    private JButton zeroButton;
    private JButton oneButton;
    private JButton twoButton;
    private JButton threeButton;
    private JButton fourButton;
    private JButton fiveButton;
    private JButton sixButton;
    private JButton sevenButton;
    private JButton eightButton;
    private JButton nineButton; 

    private JPanel screen;
    private JPanel keyboard;
    private JTextField mantissa;
    private ButtonHandler keyboardHandler;
    private StringBuilder currentNumber;
    private CalculatorModel model;

    public CalculatorGUI( CalculatorModel model )
    {
        super( "Calculator" );

        this.model = model;

        GridLayout mainLayout = new GridLayout( 2, 1, 5, 5 );
        GridLayout screenLayout = new GridLayout( 1, 1, 5, 5 );
        GridLayout keyboardLayout = new GridLayout( 5, 4, 5, 5 );

        this.screen = new JPanel();
        this.keyboard = new JPanel();

        this.mantissa = new Mantissa( model );
        this.mantissa.setHorizontalAlignment( JTextField.RIGHT );
        this.mantissa.setEditable( false );

        this.currentNumber = new StringBuilder( "" );
        this.mantissa.setText( currentNumber.toString() );

        this.screen.setSize( new Dimension( 300, 50 ) );
        this.screen.add( mantissa );

        this.keyboardHandler = new ButtonHandler();

        setLayout( mainLayout );
        this.screen.setLayout( screenLayout );
        this.keyboard.setLayout( keyboardLayout );

        this.addButton = new JButton( "+" );
        this.addButton.setActionCommand( "add" );
        this.addButton.addActionListener( keyboardHandler );
        this.keyboard.add( addButton  );

        this.subButton = new JButton( "-" );
        this.subButton.setActionCommand( "subtract" );
        this.subButton.addActionListener( keyboardHandler );
        this.keyboard.add( subButton  );

        this.mulButton = new JButton( "*" );
        this.mulButton.setActionCommand( "multiply" );
        this.mulButton.addActionListener( keyboardHandler );
        this.keyboard.add( mulButton  );

        this.divButton = new JButton( "/" );
        this.divButton.setActionCommand( "divide" );
        this.divButton.addActionListener( keyboardHandler );
        this.keyboard.add( divButton  );

        this.modButton = new JButton( "mod" );
        this.modButton.setActionCommand( "modulus" );
        this.modButton.addActionListener( keyboardHandler );
        this.keyboard.add( modButton  );

        this.decButton = new JButton( "." );
        this.decButton.setActionCommand( "decimal" );
        this.decButton.addActionListener( keyboardHandler );
        this.keyboard.add( decButton  );

        this.acButton = new JButton( "A/C" );
        this.acButton.setActionCommand( "a/c" );
        this.acButton.addActionListener( keyboardHandler );
        this.keyboard.add( acButton  );

        this.eqButton = new JButton( "=" );
        this.eqButton.setActionCommand( "equals" );
        this.eqButton.addActionListener( keyboardHandler );
        this.keyboard.add( eqButton  );

        this.signButton = new JButton( "+/-" );
        this.signButton.setActionCommand( "sign" );
        this.signButton.addActionListener( keyboardHandler );
        this.keyboard.add( signButton  );

        this.dzeroButton = new JButton( "00" );
        this.dzeroButton.setActionCommand( "dzero" );
        this.dzeroButton.addActionListener( keyboardHandler );
        this.keyboard.add( dzeroButton  );

        this.zeroButton = new JButton( "0" );
        this.zeroButton.setActionCommand( "0" );
        this.zeroButton.addActionListener( keyboardHandler );
        this.keyboard.add( zeroButton  );

        this.oneButton = new JButton( "1" );
        this.oneButton.setActionCommand( "1" );
        this.oneButton.addActionListener( keyboardHandler );
        this.keyboard.add( oneButton  );

        this.twoButton = new JButton( "2" );
        this.twoButton.setActionCommand( "2" );
        this.twoButton.addActionListener( keyboardHandler );
        this.keyboard.add( twoButton  );

        this.threeButton = new JButton( "3" );
        this.threeButton.setActionCommand( "3" );
        this.threeButton.addActionListener( keyboardHandler );
        this.keyboard.add( threeButton  );

        this.fourButton = new JButton( "4" );
        this.fourButton.setActionCommand( "4" );
        this.fourButton.addActionListener( keyboardHandler );
        this.keyboard.add( fourButton  );

        this.fiveButton = new JButton( "5" );
        this.fiveButton.setActionCommand( "5" );
        this.fiveButton.addActionListener( keyboardHandler );
        this.keyboard.add( fiveButton  );

        this.sixButton = new JButton( "6" );
        this.sixButton.setActionCommand( "6" );
        this.sixButton.addActionListener( keyboardHandler );
        this.keyboard.add( sixButton  );

        this.sevenButton = new JButton( "7" );
        this.sevenButton.setActionCommand( "7" );
        this.sevenButton.addActionListener( keyboardHandler );
        this.keyboard.add( sevenButton  );

        this.eightButton = new JButton( "8" );
        this.eightButton.setActionCommand( "8" );
        this.eightButton.addActionListener( keyboardHandler );
        this.keyboard.add( eightButton  );

        this.nineButton = new JButton( "9" );
        this.nineButton.setActionCommand( "9" );
        this.nineButton.addActionListener( keyboardHandler );
        this.keyboard.add( nineButton  );

        add( screen );
        add( keyboard );

    }


    private class ButtonHandler implements ActionListener
    {

        public void actionPerformed( ActionEvent event )
        {

            if( event.getActionCommand() == "0" )
            {
                currentNumber.append( "0" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );

            }
            else if( event.getActionCommand() == "1" )
            {
                currentNumber.append( "1" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "2" )
            {
                currentNumber.append( "2" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "3" )
            {
                currentNumber.append( "3" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "4" )
            {
                currentNumber.append( "4" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "5" )
            {
                currentNumber.append( "5" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "6" )
            {
                currentNumber.append( "6" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "7" )
            {
                currentNumber.append( "7" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "8" )
            {
                currentNumber.append( "8" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "9" )
            {
                currentNumber.append( "9" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "dzero" )
            {
                currentNumber.append( "00" );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "decimal" )
            {
                currentNumber.append( "." );
                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "sign" )
            {
                if( currentNumber.charAt( 0 ) == '-' )
                {
                    currentNumber.deleteCharAt( 0 );
                }
                else
                {
                    currentNumber.insert( 0, "-" );
                }

                double number = Double.parseDouble( currentNumber.toString() );
                model.setNumber( number );
            }
            else if( event.getActionCommand() == "add" )
            {
            }
            else if( event.getActionCommand() == "subtract" )
            {

            }
            else if( event.getActionCommand() == "multiply" )
            {

            }
            else if( event.getActionCommand() == "divide" )
            {

            }
            else if( event.getActionCommand() == "modulus" )
            {

            }
            else if( event.getActionCommand() == "equals" )
            {

            } 
            else if( event.getActionCommand() == "a/c" )
            {

            }
            else
            {
                System.out.println( "Error" );//do nothing now
            }        
  

        }

    }

}
import javax.swing.JTextField;
import java.util.Observer;
import java.util.Observable;

public class Mantissa extends JTextField 
{

    private CalculatorModel model;

    public Mantissa( CalculatorModel model )
    {
        super();
        this.model = model;
    }


}
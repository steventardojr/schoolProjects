import java.util.Observable;

public class CalculatorModel 
{

    private double result;
    private double number;
    private String lastOperation;
    private boolean holdingResult;

    public  CalculatorModel()
    {
        this.result = 0.0;
        this.number = 0.0;
        this.holdingResult = false;
        this.lastOperation = null;
    }

    public void setNumber( double number )
    {
        this.number = number;
    }

    public void add()
    {
        if( this.holdingResult == true )
        {
            this.result = this.result + this.number;
        }
        else
        {
            this.result = this.number;
            this.holdingResult = true;
        }
        this.lastOperation = "add";

    }

    public void subtract()
    {
        if( this.holdingResult == true )
        {
            this.result = this.result - this.number;
        }
        else
        {
            this.result = this.number;
            this.holdingResult = true;
        }
        this.lastOperation = "subtract";

    }

    public void multiply()
    {
        if( this.holdingResult == true )
        {
            this.result = this.result * this.number;
        }
        else
        {
            this.result = this.number;
            this.holdingResult = true;
        }
        this.lastOperation = "multiply";

    }

    public void divide()
    {
        if( this.holdingResult == true )
        {
            this.result = this.result / this.number;
        }
        else
        {
            this.result = this.number;
            this.holdingResult = true;
        }
        this.lastOperation = "divide";

    }

    public void modulus()
    {   

        if( this.holdingResult == true )
        {
            this.result =  this.result % this.number;
        }
        else
        {
            this.result = this.number;
            this.holdingResult = true;
        }
        this.lastOperation = "modulus";

    }

    public void equals()
    {

        if( this.lastOperation == "add" )
        {
            this.add();
        }
        else if( this.lastOperation == "subtract" )
        {
            this.subtract();
        }
        else if( this.lastOperation == "multiply" )
        {
            this.multiply();
        }
        else if( this.lastOperation == "divide" )
        {
            this.divide();
        }
        else if( this.lastOperation == "modulus" )
        {
            this.modulus();
        }
        else
        {
            //do nothing for now
        }

        this.lastOperation = null;

    }

    public void clear()
    {
        this.holdingResult = false;
        this.number = 0.0;
        this.result = 0.0;

    }

    public double getResult()
    {
        return this.result;
    }

    public double getNumber()
    {
        return this.number;
    }


}
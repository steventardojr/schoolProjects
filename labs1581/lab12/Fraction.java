/**
 * Fraction Class
 * Lab Twelve
 **/

public class Fraction
{
  protected int num;
  protected int den;

  public Fraction(int num, int den)
  {
    this.num = num;
    this.den = den;
  }

  public Fraction add(Fraction otherFraction)
  {
    int temp1 = (this.num * otherFraction.den) + (otherFraction.num * this.den);
    int temp2 = (this.den * otherFraction.den);
    return new Fraction(temp1, temp2);
  }

  public Fraction subtract(Fraction otherFraction)
  {
    int temp1 = (this.num * otherFraction.den) - (otherFraction.num * this.den);
    int temp2 = (this.den * otherFraction.den);
    return new Fraction(temp1, temp2);
  }

  public Fraction multiply(Fraction otherFraction)
  {
    int temp1 = (this.num * otherFraction.num);
    int temp2 = (this.den * otherFraction.den);
    return new Fraction(temp1, temp2);
  }

  public Fraction divide(Fraction otherFraction) throws IllegalArgumentException
  {
    if (otherFraction.num == 0)
      throw new IllegalArgumentException("Division by Zero");
    int temp1 = (this.num * otherFraction.den);
    int temp2 = (this.den * otherFraction.num);
    return new Fraction(temp1, temp2);
  }

  public String toString()
  {
    return (num + "/" + den);
  }  
}



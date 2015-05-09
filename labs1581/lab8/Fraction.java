/**
 * Fraction Class
 * Lab Eight
 **/

public class Fraction
{
  private int num;
  private int den;

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

  public Fraction divide(Fraction otherFraction)
  {
    int temp1 = (this.num * otherFraction.den);
    int temp2 = (this.den * otherFraction.num);
    return new Fraction(temp1, temp2);
  }

  public String toString()
  {
    return (num + "/" + den);
  }  
}



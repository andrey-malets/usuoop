package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;

public class ComplexValue extends AbstractValue {

  private double re;
  private double im;

  private double getRe() {
    return re;
  }
  
  private double getIm() {
    return im;
  }
  
  public ComplexValue(double re,double im) {
    this.re = re;
    this.im = im;
  }
  
  public AbstractValue add(AbstractValue operand)
      throws OperationNotSupportedException {    
    return new ComplexValue(re + ((ComplexValue)operand).getRe(), im + ((ComplexValue)operand).getIm());
  }

  public AbstractValue sub(AbstractValue operand)
      throws OperationNotSupportedException {
    return new ComplexValue(re - ((ComplexValue)operand).getRe(), im - ((ComplexValue)operand).getIm());
  }

  
  /*
   *  (a+bi) (c+di) = (ac - bd) (ad + cb)
   * (non-Javadoc)
   * @see calculator.AbstractValue#mul(calculator.AbstractValue)
   */
  public AbstractValue mul(AbstractValue operand)
      throws OperationNotSupportedException {    
    return new ComplexValue(re * ((ComplexValue)operand).getRe() - im * ((ComplexValue)operand).getIm(), re * ((ComplexValue)operand).getIm() + im * ((ComplexValue)operand).getRe());
  }

  /*
   * (a+bi) / (c+di) = ((a+bi) * (c-di)) / (c^2-d^2) = 
   * = ((ac + bd) + (bc - ad)) / (c^2 - d^2) 
   * (non-Javadoc)
   * @see calculator.AbstractValue#div(calculator.AbstractValue)
   */
  public AbstractValue div(AbstractValue operand)
      throws DivisionByZeroException, OperationNotSupportedException {
    double new_re = (re * ((ComplexValue)operand).getRe() + im * ((ComplexValue)operand).getIm()) / (((ComplexValue)operand).getRe() * ((ComplexValue)operand).getRe() + ((ComplexValue)operand).getIm() * ((ComplexValue)operand).getIm());
    double new_im =  (im * ((ComplexValue)operand).getRe() - re * ((ComplexValue)operand).getIm()) / (((ComplexValue)operand).getRe() * ((ComplexValue)operand).getRe() + ((ComplexValue)operand).getIm() * ((ComplexValue)operand).getIm());
    return new ComplexValue(new_re, new_im);
  }

  public String toString() {
    StringBuffer buffer = new StringBuffer("");
    buffer.append(re);
    if (im >= 0 ) {
      buffer.append("+");
    }
    buffer.append(im);    
    buffer.append("i");
    return buffer.toString();
  }
}

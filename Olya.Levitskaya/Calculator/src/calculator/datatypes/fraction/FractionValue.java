package calculator.datatypes.fraction;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;

public class FractionValue extends AbstractValue {

   
  private int p;
  private int q;

  public FractionValue(int p,int q) {
    this.p = p;
    this.q = q;
    reduce();
  }
  
  private int getP() {
    return p;
  }
  
  private int getQ() {
    return q;
  }
  
  private void reduce() {
    int max = (p > q) ? p : q;
    for (int i = 2; i < max + 1; ++i) {
      while ( (p % i == 0) && (q % i == 0)) {
        p /= i;
        q /= i;
      }
    }
  }
  
  public AbstractValue add(AbstractValue operand)
      throws OperationNotSupportedException {
    int new_p = p*((FractionValue)operand).getQ() + q*((FractionValue)operand).getP();
    int new_q = q*((FractionValue)operand).getQ();    
    return new FractionValue(new_p, new_q);
  }

  public AbstractValue sub(AbstractValue operand)
      throws OperationNotSupportedException {
    int new_p = p*((FractionValue)operand).getQ() - q*((FractionValue)operand).getP();
    int new_q = q*((FractionValue)operand).getQ();    
    return new FractionValue(new_p, new_q);
  }

  public AbstractValue mul(AbstractValue operand)
      throws OperationNotSupportedException {    
    return new FractionValue(p * ((FractionValue)operand).getP(), q * ((FractionValue)operand).getQ());
  }

  public AbstractValue div(AbstractValue operand)
      throws DivisionByZeroException, OperationNotSupportedException {    
    return new FractionValue(p * ((FractionValue)operand).getQ(), q * ((FractionValue)operand).getP());
  }

  public String toString() {
    return p+"/"+q;
  }
}

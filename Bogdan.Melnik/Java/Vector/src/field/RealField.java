package field;

import exceptions.InvalidValueException;

public class RealField implements IField {
  private final double _elem;

  public RealField(double i) {
    _elem = i;
  }

  public double getValue() {    
    return _elem;
  }

  public RealField reverseForAdd() {
    return new RealField(-_elem);
  }

  public RealField reverseForMul() {
    return new RealField(1 / _elem);
  }

  public RealField add(IField rhs) throws InvalidValueException {
    if (! (rhs instanceof RealField) ) {
      throw new InvalidValueException("Argument must be RealField type.");      
    }
    RealField valid = (RealField) rhs;
    return new RealField(_elem  + valid.getValue());
  }

  public RealField mul(IField rhs) throws InvalidValueException {
    if (! (rhs instanceof RealField) ) {
      throw new InvalidValueException("Argument must be RealField type.");      
    }
    RealField valid = (RealField) rhs;
    return new RealField(_elem * valid.getValue());
  }
  
  public String toString() {
    return new Double(_elem).toString();
  }
  
  public boolean equals(Object rhs) {
    if (this == rhs)
      return true;
    if (rhs instanceof RealField) {
      RealField realRhs = (RealField) rhs;              
      return ( (realRhs.getValue() - this.getValue()) < 0.2);
    }
    return true;
  }

  public IField getZero() { 
    return new RealField(0.);
  }

  public IField getUnit() {
    return new RealField(1.);
  }  
}
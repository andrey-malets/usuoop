package field;

import exceptions.InvalidValueException;
import exceptions.OutOfComponentIndexException;

public class RealField implements IField {
  private final Double _elem;

  public RealField(Double i) {
    _elem = i;
  }

  public Double getComponent(int i) throws OutOfComponentIndexException {
    if (i != 0) {
      throw new OutOfComponentIndexException("Index must be zero");
    }
    return _elem;
  }

  public RealField reverseForAdd() {
    return new RealField(-_elem.doubleValue());
  }

  public RealField reverseForMul() {
    return new RealField(1 / _elem.doubleValue());
  }

  public RealField add(IField rhs) throws OutOfComponentIndexException, InvalidValueException {
    if (! (rhs instanceof RealField) ) {
      throw new InvalidValueException("Argument must be RealField type.");      
    }
    RealField valid = (RealField) rhs;
    return new RealField(_elem.doubleValue()
        + valid.getComponent(0).doubleValue());
  }

  public RealField mul(IField rhs) throws OutOfComponentIndexException, InvalidValueException {
    if (! (rhs instanceof RealField) ) {
      throw new InvalidValueException("Argument must be RealField type.");      
    }
    RealField valid = (RealField) rhs;
    return new RealField(_elem.doubleValue()
        * valid.getComponent(0).doubleValue());
  }
  
  public String toString() {
    return _elem.toString();
  }
  
  public boolean equals(Object rhs) {
    if (this == rhs)
      return true;
    if (rhs instanceof RealField) {
      RealField realRhs = (RealField) rhs;
      try {        
        return ( (realRhs.getComponent(0).doubleValue() - this.getComponent(0).doubleValue()) < 0.01);
      } catch (OutOfComponentIndexException e) {
        return false;
      }
    }
    return true;
  }
}
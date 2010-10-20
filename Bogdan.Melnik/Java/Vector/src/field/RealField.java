package field;

import vector.OutOfComponentIndexException;

public class RealField implements IField<Double> {
  Double _elem;

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

  public RealField add(IField<Double> rhs) throws OutOfComponentIndexException {
    return new RealField(_elem.doubleValue()
        + rhs.getComponent(0).doubleValue());
  }

  public RealField mul(IField<Double> rhs) throws OutOfComponentIndexException {
    return new RealField(_elem.doubleValue()
        * rhs.getComponent(0).doubleValue());
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
        return (realRhs.getComponent(0).doubleValue() == this.getComponent(0).doubleValue());
      } catch (OutOfComponentIndexException e) {
        return false;
      }
    }
    return true;
  }
}
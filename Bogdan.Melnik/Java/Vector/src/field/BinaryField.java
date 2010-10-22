package field;

import exceptions.InvalidValueException;
import exceptions.OutOfComponentIndexException;

public class BinaryField implements IField {
  private final Integer _elem;
  
  public BinaryField(Integer i) throws InvalidValueException  {
    if (i != 1 && i != 0)
      throw new InvalidValueException("Value must be 0 or 1");
    _elem = i;
  }
  
  public Integer getComponent(int i) throws OutOfComponentIndexException {
    if (i != 0) {
      throw new OutOfComponentIndexException("Index must be zero");
    }
    return _elem;    
  }

  public BinaryField reverseForAdd() throws InvalidValueException {
    return new BinaryField(_elem);
  }

  public BinaryField reverseForMul() throws ArithmeticException, InvalidValueException {
    if (_elem == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return new BinaryField(1);
  }

  public IField add(IField rhs)  
      throws OutOfComponentIndexException, InvalidValueException {
    if (! (rhs instanceof BinaryField) ) {
      throw new InvalidValueException("Argument must be BinaryField type.");      
    }
    BinaryField valid = (BinaryField) rhs;
    return new BinaryField((_elem.intValue() + valid.getComponent(0).intValue()) % 2);
  }

  public IField mul(IField rhs)
      throws OutOfComponentIndexException, InvalidValueException {
    if (! (rhs instanceof BinaryField) ) {
      throw new InvalidValueException("Argument must be BinaryField type.");      
    }
    BinaryField valid = (BinaryField) rhs;
    return new BinaryField(_elem.intValue() * valid.getComponent(0).intValue());    
  }  
  
  public String toString() {
    return _elem.toString();
  }
}

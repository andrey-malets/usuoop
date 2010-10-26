package field;

import exceptions.InvalidValueException;

public class BinaryField implements IField {
  private final int _elem;
  
  public BinaryField(Integer i) throws InvalidValueException  {
    if (i != 1 && i != 0)
      throw new InvalidValueException("Value must be 0 or 1");
    _elem = i;
  }
  
  private int getValue() {    
    return _elem;    
  }

  public IField reverseForAdd() throws InvalidValueException {
    return new BinaryField(_elem);
  }

  public IField reverseForMul() throws ArithmeticException, InvalidValueException {
    if (_elem == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return new BinaryField(1);
  }

  public IField add(IField rhs)  
      throws InvalidValueException {
    if (! (rhs instanceof BinaryField) ) {
      throw new InvalidValueException("Argument must be BinaryField type.");      
    }
    BinaryField valid = (BinaryField) rhs;
    return new BinaryField((_elem + valid.getValue()) % 2);
  }

  public IField mul(IField rhs)
      throws InvalidValueException {
    if (! (rhs instanceof BinaryField) ) {
      throw new InvalidValueException("Argument must be BinaryField type.");      
    }
    BinaryField valid = (BinaryField) rhs;
    return new BinaryField(_elem * valid.getValue());    
  }  
  
  public String toString() {
    return new Integer(_elem).toString();
  }

  public IField getZero() {    
    try {
      return new BinaryField(1);
    } catch (InvalidValueException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }
  
  public IField getUnit() {   
    try {
      return new BinaryField(0);
    } catch (InvalidValueException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return null;
  }

  public double doubleValue() {
    return _elem;
  }
}

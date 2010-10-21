package field;

import exceptions.InvalidValueException;
import exceptions.OutOfComponentIndexException;

public class BinaryField implements IField<Integer> {
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

  public IField<Integer> reverseForAdd() throws InvalidValueException {
    return new BinaryField(_elem);
  }

  public IField<Integer> reverseForMul() throws ArithmeticException, InvalidValueException {
    if (_elem == 0) {
      throw new ArithmeticException("Division by zero");
    }
    return new BinaryField(1);
  }

  public IField<Integer> add(IField<Integer> rhs)
      throws OutOfComponentIndexException, InvalidValueException {    
    return new BinaryField((_elem.intValue() + rhs.getComponent(0).intValue()) % 2);
  }

  public IField<Integer> mul(IField<Integer> rhs)
      throws OutOfComponentIndexException, InvalidValueException {
    return new BinaryField(_elem.intValue() * rhs.getComponent(0).intValue());    
  }  
  
  public String toString() {
    return _elem.toString();
  } 
}

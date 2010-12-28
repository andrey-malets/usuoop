package lexer.datatype.integer;

import lexer.datatype.AbstractValue;
import lexer.datatype.TypeMissmatchException;

public class Int implements AbstractValue {
  private final int _value;
  
  public Int() {
    this._value = 0;
  };
  
  public Int(int defaultValue) {
    this._value = defaultValue;
  };
    
  public AbstractValue add(AbstractValue av) throws TypeMissmatchException {
    if (! (av instanceof Int) )
      throw new TypeMissmatchException();
    return new Int( this._value + ((Int)av)._value );
  }
  
  public AbstractValue sub(AbstractValue av) throws TypeMissmatchException {
    if (! (av instanceof Int) )
      throw new TypeMissmatchException();
    return new Int( this._value - ((Int)av)._value );
  }
  
  public AbstractValue mul(AbstractValue av) throws TypeMissmatchException {
    if (! (av instanceof Int) )
      throw new TypeMissmatchException();
    return new Int( this._value * ((Int)av)._value );
  }
  
  public AbstractValue div(AbstractValue av) throws TypeMissmatchException {
    if (! (av instanceof Int) )
      throw new TypeMissmatchException();
    return new Int( this._value / ((Int)av)._value );
  }
  
  public String toString() {
    return new Integer(_value).toString();
    
  }
}

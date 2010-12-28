package lexer.datatype.pair;

import lexer.datatype.AbstractValue;
import lexer.datatype.TypeMissmatchException;

public class Pair implements AbstractValue {

  private int _right;
  private int _left;

  public Pair(int left,int right) {
    this._left = left;
    this._right = right;
  }
  
  public AbstractValue add(AbstractValue av) throws TypeMissmatchException {
    if (! (av instanceof Pair) )
      throw new TypeMissmatchException();
    return new Pair( this._left + ((Pair)av)._left,this._right + ((Pair)av)._right);
  }

  public AbstractValue sub(AbstractValue av) throws TypeMissmatchException {
    if (! (av instanceof Pair) )
      throw new TypeMissmatchException();
    return new Pair( this._left + ((Pair)av)._left,this._right + ((Pair)av)._right);
  }

  public AbstractValue mul(AbstractValue av) throws TypeMissmatchException {
    if (! (av instanceof Pair) )
      throw new TypeMissmatchException();
    return new Pair( this._left + ((Pair)av)._left,this._right + ((Pair)av)._right);
  }
  
  public AbstractValue div(AbstractValue av) throws TypeMissmatchException {
    if (! (av instanceof Pair) )
      throw new TypeMissmatchException();
    return new Pair( this._left + ((Pair)av)._left,this._right + ((Pair)av)._right);
  }

  public String toString() {    
    return "<" + new Integer(_left) + "," + new  Integer(_right) + ">";
  }
  
}

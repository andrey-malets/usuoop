package lexer.datatype.identifier;

import lexer.datatype.AbstractValue;
import lexer.datatype.TypeMissmatchException;

public class Identifier implements AbstractValue {

  private String _name;
  private int _id;

  public Identifier(String name,int id) {
    this._name = name;
    this._id = id;
  }
  public AbstractValue add(AbstractValue av) throws TypeMissmatchException {  
    return null;
  }
  
  public AbstractValue sub(AbstractValue av) throws TypeMissmatchException {  
    return null;
  }

  public AbstractValue mul(AbstractValue av) throws TypeMissmatchException {
    return null;
  }
  
  public AbstractValue div(AbstractValue av) throws TypeMissmatchException {
    return null;
  }

  public String toString() {    
    return this._name;
  }
  
  public int hashCode() {
    return _id;    
  } 
  
  public boolean equals(Object o) {
    if ( ! (o instanceof Identifier))
      return false;
    return hashCode() == ((Identifier)o).hashCode();    
  }
  
}

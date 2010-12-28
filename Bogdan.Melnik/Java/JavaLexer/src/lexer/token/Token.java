package lexer.token;

import lexer.datatype.AbstractValue;
import lexer.token.TokenReader.type;

public class Token {  
  private Integer _integerValue;
  private type _type;
  private AbstractValue _av;
  
  public Token(Integer integerValue,TokenReader.type type,AbstractValue av) {    
    this._integerValue = integerValue;
    this._type = type;    
    this._av = av;
  }
  
  public Token(Token t) {    
    this._integerValue = t._integerValue;
    this._type = t._type;
    this._av = t._av;
  }
  
  public Integer getID() {
    return _integerValue;
  } 
  
  public TokenReader.type getType() {
     return _type;
  }
  
  public AbstractValue getAbstractValue() {
    return _av;
  }
  
}

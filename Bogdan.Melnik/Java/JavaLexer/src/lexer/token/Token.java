package lexer.token;

import lexer.token.TokenReader.type;

public class Token {  
  private Integer _integerValue;
  private type _type;
  
  public Token(Integer integerValue,TokenReader.type type) {    
    this._integerValue = integerValue;
    this._type = type;    
  }
  
  public Token(Token t) {    
    this._integerValue = t._integerValue;
    this._type = t._type;
  }
  
  public Integer getIntegerValue() {
    return _integerValue;
  } 
  
  public TokenReader.type getType() {
     return _type;
  }
  
}

package lexer.token;

import lexer.token.TokenReader.type;

public class Token {
  private Integer _value;
  private type _type;
  
  public Token(Integer value,TokenReader.type type) {
    this._value = value;
    this._type = type;    
  }
  
  public Token(Token t) {
    this._value = t._value;
    this._type = t._type;
  }
  
  public Integer getValue() {
    return _value;
  }  
  
  public TokenReader.type getType() {
     return _type;
  }
  
}

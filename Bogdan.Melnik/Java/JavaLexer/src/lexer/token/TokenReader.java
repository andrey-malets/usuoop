package lexer.token;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import lexer.datatype.AbstractValue;
import lexer.datatype.identifier.Identifier;
import lexer.datatype.integer.Int;
import lexer.datatype.pair.Pair;
import lexer.input.ReadStream;

public class TokenReader {   
  
    
  private ReadStream readStream;
  final public HashMap<Identifier, AbstractValue> nameTable = new HashMap<Identifier, AbstractValue>();
  
  public enum type {    
    ID,
    PLUS,
    MINUS,
    MUL,
    DIV,
    OPEN_BRK,
    CLOSE_BRK,
    EOC,
    ABSTRACT_VALUE,
    EQU,
    COM,
    TRASH
  };
  
  public TokenReader(InputStream in) {
    readStream = new ReadStream(in);    
  }  
    
  private boolean isSpace(Character c) {
    switch (c) {
      case ' ': case '\t': case '\n':
        return true;
      default:
        return false;
    }
  
  }
  
  public Token getToken() throws IOException {
    Character block = readStream.readChar();
    while (isSpace(block)) {
      block = readStream.readChar();      
    }
    
    if (Character.isLetter(block)) {
      StringBuffer stringBuffer = new StringBuffer("");
      while(Character.isDigit(block) || Character.isLetter(block)) {
        stringBuffer.append(block);
        block = readStream.readChar();
      }
      readStream.unreadChar(block);
      String value = stringBuffer.toString();
      Identifier identifier = new Identifier(value,value.hashCode());
      if (!nameTable.containsKey(identifier))
        nameTable.put(identifier, null);
      return new Token(value.hashCode(),type.ID,identifier);
    }
    
    if (Character.isDigit(block)) {
      StringBuffer stringBuffer = new StringBuffer("");               
      while(Character.isDigit(block)) {         
        stringBuffer.append(block);
        block = readStream.readChar();          
      }        
      readStream.unreadChar(block);        
      Int av = new Int(Integer.parseInt(stringBuffer.toString()));      
      return new Token(av.hashCode(),type.ABSTRACT_VALUE,av);
    }
    
    if (block == '<') {
      Token left = getToken();
      getToken();
      Token right = getToken();
      getToken();
      Pair pair = new Pair(Integer.parseInt(left.getAbstractValue().toString()), Integer.parseInt(right.getAbstractValue().toString()));
      return new Token(pair.hashCode(),type.ABSTRACT_VALUE,pair);
    }
    
    switch (block) { 
      
      case '+':
        return new Token(0,type.PLUS,null);
      case '-':
        return new Token(0,type.MINUS,null);
      case '*':
        return new Token(0,type.MUL,null);
      case '/':
        return new Token(0,type.DIV,null);       
      case '(':
        return new Token(0,type.OPEN_BRK,null);
      case ')':
        return new Token(0,type.CLOSE_BRK,null);
      case ';':
        return new Token(0,type.EOC,null);
      case '=':
        return new Token(0,type.EQU,null);
      case ',':
        return new Token(0,type.COM,null);
      case '>': case '<':
        return new Token(0,type.TRASH,null);
    }
    return null;
  }
  
}


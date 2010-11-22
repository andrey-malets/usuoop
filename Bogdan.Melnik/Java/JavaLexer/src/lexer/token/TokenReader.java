package lexer.token;

import java.io.IOException;
import java.io.InputStream;

import lexer.input.ReadStream;

public class TokenReader {   
  
    
  private ReadStream readStream;

  public enum type {    
    ID,
    PLUS,
    MINUS,
    MUL,
    DIV,
    OPEN_BRK,
    CLOSE_BRK,
    EOC,
    INT
  } 
  
  public TokenReader(InputStream in) {
    readStream = new ReadStream(in);
  }
  
  private boolean isNum(Character c) {
    switch (c) {
      case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
        return true;
      default:
        return false;
    }   
  }
  
  public Token getToken() throws IOException {
    Character block = readStream.readChar();
    switch (block) {
      case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
        StringBuffer stringBuffer = new StringBuffer("");               
        while(isNum(block)) {         
          stringBuffer.append(block);
          block = readStream.readChar();          
        }        
        readStream.unreadChar(block);        
        return new Token(Integer.parseInt(stringBuffer.toString()),type.INT);
      case '+':
        return new Token(0,type.PLUS);
      case '-':
        return new Token(0,type.MINUS);
      case '*':
        return new Token(0,type.MUL);
      case '/':
        return new Token(0,type.DIV);       
      case '(':
        return new Token(0,type.OPEN_BRK);
      case ')':
        return new Token(0,type.CLOSE_BRK);
      case ';':
        return new Token(0,type.EOC);                
    }
    return null;
  }
  
}


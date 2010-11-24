package lexer.token;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.TreeMap;

import lexer.input.ReadStream;

public class TokenReader {   
  
    
  private ReadStream readStream;
  final public TreeMap<Integer, Integer> nameTable = new TreeMap<Integer, Integer>();
  
  public enum type {    
    ID,
    PLUS,
    MINUS,
    MUL,
    DIV,
    OPEN_BRK,
    CLOSE_BRK,
    EOC,
    INT,
    EQU
  };
  
  public TokenReader(InputStream in) {
    readStream = new ReadStream(in);    
  }  
    
  private boolean isSpace(Character c) {
    switch (c) {
      case ' ': case '\t':
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
      if (!nameTable.containsKey(value.hashCode()))
        nameTable.put(value.hashCode(), 0);
      return new Token(value.hashCode(),type.ID);
    }
    if (Character.isDigit(block)) {
      StringBuffer stringBuffer = new StringBuffer("");               
      while(Character.isDigit(block)) {         
        stringBuffer.append(block);
        block = readStream.readChar();          
      }        
      readStream.unreadChar(block);        
      return new Token(Integer.parseInt(stringBuffer.toString()),type.INT);
    }
    switch (block) { 
      
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
      case '=':
        return new Token(0,type.EQU);    
    }
    return null;
  }
  
}


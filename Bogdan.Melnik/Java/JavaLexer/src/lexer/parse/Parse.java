package lexer.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

import lexer.token.Token;
import lexer.token.TokenReader;
import lexer.token.TokenReader.type;

public class Parse {  
  private Token look;
  private TokenReader readToken;
  final protected ArrayList<Token> tokenTree = new ArrayList<Token>();
  
  public Parse(InputStream in) throws IOException {
    readToken = new TokenReader(in);    
    look = readToken.getToken();
    while(true) {
      statement();
      match(type.EOC);      
      this.debug_calculate();      
      if (look == null) {
        showNameTable();
        System.exit(0);
      }
    }
  }  
  
  private void statement() throws IOException {
    if (look.getType() == type.ID) {
      emit(look);
      match(type.ID);
      if (look.getType() == type.EQU) {
        Token t = new Token(look);
        match(look.getType());
        expr(true);
        emit(t);
      } else {
        expr(false);
      }
    } else {
      expr(true);
    }    
  }
  
  private void match(type t) throws IOException {
    if (look.getType() == t)
      look = readToken.getToken();
  }  
  
  private void factor() throws IOException {
     switch(look.getType()) {
    case OPEN_BRK:
      match(type.OPEN_BRK);
      expr(true);
      match (type.CLOSE_BRK);
      break;
    case INT:
      emit(look);
      match(type.INT);
      break;
    case ID:
      emit(look);
      match(type.ID);
      break;    
    }  
  }
  
  private void expr(boolean a) throws IOException {    
    term(a);
    while(true)
      switch(look.getType()) {
        case MINUS: case PLUS:
          Token t = look;
          match(look.getType());
          term(true);   
          emit(t);
          break;
        default:
          return;
      }
    }
  
  private void term(boolean a) throws IOException {
    if (a)
      factor();
    while(true)
      switch (look.getType()) {
        case MUL: case DIV:
          Token t = look;
          match(look.getType());
          factor();
          emit(t);
          continue;
        default:
          return;
      }
  }
  private void emit(Token t) {
    tokenTree.add(new Token(t));        
  }  
  
  private void showNameTable() {
    for (Integer Int : readToken.nameTable.keySet()) {
      System.out.println(Int + " " + readToken.nameTable.get(Int));
    }    
  }
  
  public void debug_calculate() {
    Stack<Token> stack = new Stack<Token>();    
    Token a,b;
    Integer avalue,bvalue;
    for (Token t : tokenTree) {
      switch(t.getType()) {
        case EQU:
          a = stack.pop();
          b = stack.pop();
          if (b.getType() == type.ID) {
            readToken.nameTable.put(b.getIntegerValue(), a.getIntegerValue());
          } else {
            System.out.println("lvalue need!");
          }
          stack.push(a);
          break;
        case ID:
          stack.push(new Token(t));
          break;
        case INT:
          stack.push(new Token(t));
          break;
        case PLUS:
          a = stack.pop();
          b = stack.pop();      
          avalue = a.getIntegerValue();
          bvalue = b.getIntegerValue();
          if (a.getType() == type.ID) {            
            avalue = readToken.nameTable.get(a.getIntegerValue());            
          }
          if (b.getType() == type.ID) {
            bvalue = readToken.nameTable.get(b.getIntegerValue());
          }
          stack.push(new Token(avalue + bvalue,type.INT));
          break;
        case MINUS:
          a = stack.pop();
          b = stack.pop();
          avalue = a.getIntegerValue();
          bvalue = b.getIntegerValue();
          if (a.getType() == type.ID) {
            avalue = readToken.nameTable.get(a.getIntegerValue());
          }
          if (b.getType() == type.ID) {
            bvalue = readToken.nameTable.get(b.getIntegerValue());
          }
          stack.push(new Token(avalue - bvalue,type.INT));
          break;
        case MUL:
          a = stack.pop();
          b = stack.pop();
          avalue = a.getIntegerValue();
          bvalue = b.getIntegerValue();
          if (a.getType() == type.ID) {
            avalue = readToken.nameTable.get(a.getIntegerValue());
          }
          if (b.getType() == type.ID) {
            bvalue = readToken.nameTable.get(b.getIntegerValue());
          }
          stack.push(new Token(avalue * bvalue,type.INT));
          break;
        case DIV:
          a = stack.pop();
          b = stack.pop();          
          avalue = a.getIntegerValue();
          bvalue = b.getIntegerValue();
          if (a.getType() == type.ID) {
            avalue = readToken.nameTable.get(a.getIntegerValue());
          }
          if (b.getType() == type.ID) {
            bvalue = readToken.nameTable.get(b.getIntegerValue());
          }
          stack.push(new Token(bvalue / avalue,type.INT));
          break;
      }
    }    
    System.out.println(" => " + stack.pop().getIntegerValue());    
    tokenTree.clear();
  }  
}

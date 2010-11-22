package lexer.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
    expr();
    match(type.EOC);
  }  
  
  private void match(type t) throws IOException {
    if (look.getType() == t)
      look = readToken.getToken();
  }  
  
  private void factor() throws IOException {
     switch(look.getType()) {
    case OPEN_BRK:
      match(type.OPEN_BRK);
      expr();
      match (type.CLOSE_BRK);
      break;
    case INT:
      emit(look);
      match(type.INT);
      break;    
    }  
  }
  
  private void expr() throws IOException {    
    term();
    while(true)
      switch(look.getType()) {
        case MINUS: case PLUS:
          Token t = look;
          match(look.getType());
          term();   
          emit(t);
          break;
        default:
          return;
      }
    }
  
  private void term() throws IOException {    
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
    /*
    switch(t.getType()) {
      case NUM:        
        System.out.print(t.getValue());        
        break;
      case PLUS:
        System.out.print('+');
        break;
      case MINUS:
        System.out.print('-');
        break;
      case DIV:
        System.out.print('/');
        break;
      case MUL:
        System.out.print('*');
        break;
    }
    */    
  }  
  
  public void debug_calculate() {
    Stack<Integer> stack = new Stack<Integer>();    
    Integer a,b;
    for (Token t : tokenTree) {
      System.out.println(t.getType() + " " + t.getValue());
      switch(t.getType()) {
        case INT:
          stack.push(t.getValue());
          break;
        case PLUS:
          a = stack.pop();
          b = stack.pop();
          stack.push(a + b);
          break;
        case MINUS:
          a = stack.pop();
          b = stack.pop();
          stack.push(a - b);
          break;
        case MUL:
          a = stack.pop();
          b = stack.pop();
          stack.push(a * b);
          break;
        case DIV:
          a = stack.pop();
          b = stack.pop();
          stack.push(a / b);
          break;
      }
    }   
    System.out.println(stack.pop());
  }  
}

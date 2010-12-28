package lexer.parse;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Stack;

import lexer.datatype.AbstractValue;
import lexer.datatype.TypeMissmatchException;
import lexer.datatype.integer.Identifier;
import lexer.datatype.integer.Int;
import lexer.token.Token;
import lexer.token.TokenReader;
import lexer.token.TokenReader.type;

public class Parse {  
  private Token look;
  private TokenReader readToken;
  final protected ArrayList<Token> tokenTree = new ArrayList<Token>();
  
  public Parse(InputStream in) throws IOException, lValueException, UnknowTypeException, TypeMissmatchException {
    readToken = new TokenReader(in);    
    look = readToken.getToken();
    while(true) {
      statement();
      match(type.EOC);
      calculate();      
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
    case ABSTRACT_VALUE:
      emit(look);
      match(type.ABSTRACT_VALUE);
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
    for (Identifier Int : readToken.nameTable.keySet()) {
      AbstractValue abstractValue = readToken.nameTable.get(Int);      
      if (abstractValue != null) {        
        System.out.println(abstractValue.getClass() + " " + Int +" "  + abstractValue);
      } else {
        System.out.println(Int +" null");
      }
    }    
  }
  
  private void calculate() throws lValueException, UnknowTypeException, TypeMissmatchException {
    Token a,b;
    Stack<Token> stack = new Stack<Token>();
    for (Token t : tokenTree) {      
      switch(t.getType()) {
        case EQU:
          a = stack.pop();
          b = stack.pop();
          AbstractValue avalue;
          if (b.getType() == type.ID) {
            switch (a.getType()) {
              case ID:                
                avalue = readToken.nameTable.get((Identifier)a.getAbstractValue());
                break;
              case ABSTRACT_VALUE:
                avalue = a.getAbstractValue();
                break;          
              default:
                throw new UnknowTypeException();
            }            
            readToken.nameTable.put((Identifier)b.getAbstractValue(), avalue);
          } else {
            throw new lValueException();
          }
          break;
        case PLUS: case DIV: case MUL: case MINUS:
          a = stack.pop();
          b = stack.pop();
          AbstractValue one,two,res = null;
          switch (a.getType()) {
            case ID:
              one = readToken.nameTable.get((Identifier)a.getAbstractValue());
              break;
            case ABSTRACT_VALUE:
              one = a.getAbstractValue();
              break;          
            default:
              throw new UnknowTypeException();
          }
          switch (b.getType()) {
            case ID:
              two = readToken.nameTable.get((Identifier)b.getAbstractValue());
              break;
            case ABSTRACT_VALUE:
              two = b.getAbstractValue();
              break;          
            default:
              throw new UnknowTypeException();
          }
          switch (t.getType()) {
            case PLUS:
              res = one.add(two);              
              break;
            case MINUS:
              res = one.add(two);
              break;
            case MUL:
              res = one.add(two);
              break;
            case DIV:
              res = one.add(two);
              break;
          }
          stack.push(new Token(res.hashCode(),type.ABSTRACT_VALUE,res));
          break;
        default:
          stack.push(t);
      }
    }
    tokenTree.clear();    
  }
  
  /*
  public void debug_calculate() {
    Stack<Token> stack = new Stack<Token>();    
    Token a,b;
    Integer avalue,bvalue;
    for (Token t : tokenTree) {
      switch(t.getType()) {
        case EQU:
          a = stack.pop();
          b = stack.pop();
          avalue = a.getIntegerValue();
          if (b.getType() == type.ID) {            
            if (a.getType() == type.ID) {
              AbstractValue abstractValue = readToken.nameTable.get(a.getIntegerValue());
              readToken.nameTable.put(b.getIntegerValue(), abstractValue);
            }
          } else {
            System.out.println("lvalue need!");
          }
          stack.push(new Token(avalue,type.ABSTRACT_VALUE));
          break;
        case ID:
          stack.push(new Token(t));
          break;
        case ABSTRACT_VALUE:
          stack.push(new Token(t));
          break;
        case PLUS:
          a = stack.pop();
          b = stack.pop();      
          avalue = a.getIntegerValue();
          bvalue = b.getIntegerValue();
          AbstractValue abstractValueOne,abstractValueTwo;
          if (a.getType() == type.ID)
            abstractValueOne = readToken.nameTable.get(a.getIntegerValue());          
          if (b.getType() == type.ID) 
            abstractValueTwo = readToken.nameTable.get(b.getIntegerValue());          
          stack.push(new Token(abstractValueOne.add(abstractValue,type.ABSTRACT_VALUE));
          break;
        case MINUS:
          a = stack.pop();
          b = stack.pop();
          avalue = a.getIntegerValue();
          bvalue = b.getIntegerValue();
          if (a.getType() == type.ID)
            avalue = readToken.nameTable.get(a.getIntegerValue());          
          if (b.getType() == type.ID) 
            bvalue = readToken.nameTable.get(b.getIntegerValue());          
          stack.push(new Token(avalue - bvalue,type.ABSTRACT_VALUE));
          break;
        case MUL:
          a = stack.pop();
          b = stack.pop();
          avalue = a.getIntegerValue();
          bvalue = b.getIntegerValue();
          if (a.getType() == type.ID) 
            avalue = readToken.nameTable.get(a.getIntegerValue());          
          if (b.getType() == type.ID) 
            bvalue = readToken.nameTable.get(b.getIntegerValue());          
          stack.push(new Token(avalue * bvalue,type.ABSTRACT_VALUE));
          break;
        case DIV:
          a = stack.pop();
          b = stack.pop();          
          avalue = a.getIntegerValue();
          bvalue = b.getIntegerValue();
          if (a.getType() == type.ID) 
            avalue = readToken.nameTable.get(a.getIntegerValue());          
          if (b.getType() == type.ID) 
            bvalue = readToken.nameTable.get(b.getIntegerValue());          
          stack.push(new Token(bvalue / avalue,type.ABSTRACT_VALUE));
          break;
      }
    }        
    tokenTree.clear();
  }
  */  
}

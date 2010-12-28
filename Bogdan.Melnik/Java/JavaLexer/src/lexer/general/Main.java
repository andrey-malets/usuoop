package lexer.general;

import java.io.IOException;

import lexer.datatype.TypeMissmatchException;
import lexer.parse.Parse;
import lexer.parse.UnknowTypeException;
import lexer.parse.lValueException;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {    
    Main instance = new Main();
    try {
      instance.run();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void run() throws IOException, lValueException, UnknowTypeException, TypeMissmatchException {
    new Parse(System.in);    
  }
}

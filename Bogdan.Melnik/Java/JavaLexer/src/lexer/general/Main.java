package lexer.general;

import java.io.IOException;

import lexer.parse.Parse;

public class Main {

  /**
   * @param args
   */
  public static void main(String[] args) {    
    Main instance = new Main();
    try {
      instance.run();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void run() throws IOException {
    Parse parse = new Parse(System.in);    
    parse.debug_calculate();
  }
}

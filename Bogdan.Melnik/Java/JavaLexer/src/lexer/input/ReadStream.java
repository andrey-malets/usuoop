package lexer.input;


import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PushbackReader;


public class ReadStream {  
  private PushbackReader pushbackReader;
  public ReadStream(InputStream in) {  
    pushbackReader = new PushbackReader(new InputStreamReader(in));
  }  
  public char readChar() throws IOException {   
    char [] b = new char[1];
    pushbackReader.read(b, 0, 1);            
    return b[0];    
  }
  public void unreadChar(char i) throws IOException {    
    pushbackReader.unread(i);        
  }
}

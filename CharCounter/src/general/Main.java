package general;

import adapter.CharStream;
import counter.HashCounter;
import filter.InvalidRegexpException;
import functor.CharAllow;


public class Main {
  public static void main(String[] args) throws InvalidRegexpException {
    HashCounter<Character> hashCounter = new HashCounter<Character>();     
    //CharStream charStream = new CharStream("Hello",new CharAllow( new Character [] {'l'}));
    CharStream charStream = new CharStream("Hello,world!", new CharAllow("[ol]"));
    hashCounter.updateState(charStream);
    System.out.println(hashCounter.getCurrentState());
  }
}

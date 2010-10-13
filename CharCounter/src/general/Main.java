package general;

import adapter.CharStream;
import counter.HashCounter;
import filter.Filter;
import filter.InvalidRegexpException;


public class Main {
  public static void main(String[] args) throws InvalidRegexpException {
    HashCounter<Character> hashCounter = new HashCounter<Character>();     
    CharStream charStream = new CharStream("Hello",new Character [] {'l'});
    hashCounter.updateState(Filter.getRegexFilter("Hello,world!", "[o]"));
    hashCounter.updateState(charStream);
    System.out.println(hashCounter.getCurrentState());
  }
}

package general;

import counter.HashCounter;
import filter.InvalidRegexpException;
import filter.Filter;

public class Main {
  public static void main(String[] args) throws InvalidRegexpException {
    HashCounter<Character> hashCounter = new HashCounter<Character>();     
   
    System.out.println(hashCounter.getCurrentState());    
  }
}

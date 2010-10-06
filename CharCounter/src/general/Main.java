package general;

import separator.InvalidRegexpException;
import separator.Separator;
import counter.HashCounter;

public class Main {
  public static void main(String[] args) throws InvalidRegexpException {
    HashCounter<Character> hashCounter = new HashCounter<Character>();     
    hashCounter.updateState(Separator.getCharacterSeparator("Hello,world","[el]"));
    System.out.println(hashCounter.getCurrentState());    
  }
}

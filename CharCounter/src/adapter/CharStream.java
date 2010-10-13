package adapter;

import java.util.ArrayList;
import java.util.Iterator;

public class CharStream implements Iterable<Character> {
  private final String string;
  private final Iterable<Character> allowCharacters;
  
  public CharStream(String string, Iterable<Character> allowCharacters) {
    this.string = string;
    this.allowCharacters = allowCharacters;    
  }
  
  public CharStream(String string, Character[] allowCharacters) {    
    ArrayList<Character> arrayList = new ArrayList<Character>();
    for (Character character : allowCharacters) {
      arrayList.add(character);
    }
    this.string = string;
    this.allowCharacters = arrayList;    
  }
  
  public Iterator<Character> iterator() {    
    return new CharIterator(string,allowCharacters);
  } 

}

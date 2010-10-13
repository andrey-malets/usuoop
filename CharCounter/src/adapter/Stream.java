package adapter;

import java.util.ArrayList;
import java.util.Iterator;

public class Stream implements Iterable<Character> {
  private final String string;
  private final Iterable<Character> allowCharacters;
  
  public Stream(String string, Iterable<Character> allowCharacters) {
    this.string = string;
    this.allowCharacters = allowCharacters;
    /*
    final ArrayList<Character> matched = new ArrayList<Character>();
    for (Character character : allowCharacters) 
      for (int i = 0;i < string.length(); ++i) 
        if (character.equals(string.charAt(i))) {
          matched.add(character);
        }      
    return matched;
    */ 
  }
  
  public Stream(String string, Character[] allowCharacters) {    
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

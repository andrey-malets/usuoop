package adapter;

import java.util.Iterator;

public class CharIterator implements Iterator<Character> {
  private Character next;  
  private String string;
  private Iterable<Character> allowCharacters;
  
  public CharIterator(String string, Iterable<Character> allowCharacters) {
    this.string = string;
    this.allowCharacters = allowCharacters;    
  }

  public boolean hasNext() {
    final ArrayList<Character> matched = new ArrayList<Character>();
    for (Character character : allowCharacters) 
      for (int i = 0;i < string.length(); ++i) 
        if (character.equals(string.charAt(i))) {
          matched.add(character);
        }   
    return false;
  }
  
  public Character next() {
    // TODO Auto-generated method stub
    return null;
  }

  public void remove() {
    // TODO Auto-generated method stub
    
  }

}

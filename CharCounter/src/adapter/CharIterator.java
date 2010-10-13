package adapter;

import java.util.Iterator;

public class CharIterator implements Iterator<Character> {
  private String string;
  private int point = 0;
  private Character matched = null;
  private Iterable<Character> allowCharacters;

  public CharIterator(String string, Iterable<Character> allowCharacters) {
    this.string = string;
    this.allowCharacters = allowCharacters;    
  }

  public boolean hasNext() {
    matched = null;
    for (; point < string.length(); ++point)
      for (Character character : allowCharacters)               
        if (character.equals(string.charAt(point))) {
          matched = string.charAt(point);          
          point++;
          return true;
        }      
    return false;
  }

  public Character next() {
    return matched;
  }

  public void remove() {

  }

}

package adapter;

import java.util.Iterator;

import functor.Validate;

public class CharIterator implements Iterator<Character> {
  private String string;
  private int point = 0;
  private Character matched = null;
  private Validate<Character> validate;

  public CharIterator(String string, Validate<Character> validate) {
    this.string = string;
    this.validate = validate;
  }

  public boolean hasNext() {
    matched = null;
    for (; point < string.length(); ++point)
      if (validate.isValid(string.charAt(point))) {
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

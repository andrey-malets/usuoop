package adapter;

import java.util.Iterator;
import functor.Validate;

public class CharStream implements Iterable<Character> {
  private final String string;
  private final Validate<Character> validate;

  public CharStream(String string, Validate<Character> validate) {
    this.string = string;
    this.validate = validate;
  }

  public Iterator<Character> iterator() {
    return new CharIterator(string, validate);
  }

}

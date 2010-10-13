package functor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharAllow implements Validate<Character> {
  private Iterable<Character> allowCharacters;
  private boolean useRegex = false;
  private Pattern pattern;

  public CharAllow(Iterable<Character> allowCharacters) {
    this.allowCharacters = allowCharacters;
  }
  
  public CharAllow(Character[] allowCharacters) {
    ArrayList<Character> arrayList = new ArrayList<Character>();
    for (Character character : allowCharacters) {
      arrayList.add(character);
    }    
    this.allowCharacters = arrayList;
  }
  
  public CharAllow(String re) {
    this.useRegex  = true;
    this.pattern = Pattern.compile(re);
  }
  
  public boolean isValid(Character k) {    
    if (useRegex) {
      Matcher matcher = pattern.matcher(k.toString());
      if(matcher.find()) {
        if (matcher.group().equals(k.toString()))
          return true;
      }
    } else {
      for (Character c : allowCharacters) 
        if (c.equals(k))
          return true;        
    }
    return false;
  }

}

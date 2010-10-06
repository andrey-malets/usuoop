package separator;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
  
  public static Iterable<Character> getCharacterSeparator(String string, String re) throws InvalidRegexpException {
    Pattern pattern = Pattern.compile(re);
    Matcher matcher = pattern.matcher(string);
    ArrayList<Character> arrayList = new ArrayList<Character>();
    while (matcher.find()) {
      String matched = matcher.group();
      if (matched.length() != 1) {
        throw new InvalidRegexpException("Found match with length != 1");
      }
      char charAtZero = matched.charAt(0);      
      arrayList.add(charAtZero);
    }    
    return arrayList;
  }
  
  public static Iterable<Character> getCharacterSeparator(String string, Iterable<Character> allowCharacters) {    
    final ArrayList<Character> matched = new ArrayList<Character>();
    for (Character character : allowCharacters) 
      for (int i = 0;i < string.length(); ++i) 
        if (character.equals(string.charAt(i))) {
          matched.add(character);
        }      
    return matched; 
  }
  
  public static Iterable<Character> getCharacterSeparator(String string, Character[] allowCharacters) {
    ArrayList<Character> arrayList = new ArrayList<Character>();
    for (Character character : allowCharacters) {
      arrayList.add(character);
    }
    return getCharacterSeparator(string, arrayList);    
  } 
}

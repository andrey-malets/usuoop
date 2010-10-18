package filter;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Filter {

  public static Iterable<Character> getRegexFilter(String string, String re)
      throws InvalidRegexpException {
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

}

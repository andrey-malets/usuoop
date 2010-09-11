package general;

import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharWorker {
  private String regexp;
  private HashMap<String,Integer> charHash = null;
  public CharWorker() {    
    charHash = new HashMap<String, Integer>();
    this.setRegexp("[a-zA-Z]");
  }
  public CharWorker(String regexp) {
    charHash = new HashMap<String, Integer>();
    this.setRegexp(regexp);    
  }
  public String getRegexp() {
    return regexp;
  }
  public void setRegexp(String regexp) {
    this.regexp = regexp;
  }
  public HashMap<String,Integer> update(String inputString) {
    Matcher matcher = Pattern.compile(regexp).matcher(inputString);
    while (matcher.find()) {
      String matched = matcher.group();
      if (!charHash.containsKey(matched)) {
        charHash.put(matched, 1);
      } else {
        int prev = charHash.get(matched);
        charHash.put(matched, prev + 1);
      }
    }
    return charHash;
  }
  public void clear() {
    charHash = new HashMap<String, Integer>();
  }
  public String toString() {
    String result = "";
    Set<String> keySet = charHash.keySet();
    TreeSet<String> treeSet = new TreeSet<String>(keySet);    
    for (String key : treeSet) {
      result += (key + " - " + charHash.get(key) + "\n"); 
    }
    return result;
  }
}

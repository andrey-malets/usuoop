package model;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


/**
 * Класс предназначенный для подсчёта символов
 * @author ld
 *
 */
public class CharWorker {
  private String regexp;
  
  private final HashMap<Character,Integer> charHash;
  private final Pattern pattern;
  
  /**
   *  Конструктор по умолчанию, устанавливает регексп в [a-zA-Z]. 
   */
  public CharWorker() {    
    charHash = new HashMap<Character, Integer>();
    this.regexp = "[a-zA-Z]";
    pattern = Pattern.compile(regexp);
  }
  /**
   * Конструктор позволяющий использовать произвольный регексп.
   * При неудачной попытке скомпилить регексп выбрасывается PatternSyntaxException. 
   * @param regexp
   * @throws PatternSyntaxException
   */
  public CharWorker(String regexp) throws PatternSyntaxException {
    charHash = new HashMap<Character, Integer>();
    this.regexp = regexp;    
    pattern = Pattern.compile(regexp);
  }
  /**
   * Возвращает регексп используемый в воркере.
   * @return String regexp
   */
  public String getRegexp() {
    return regexp;
  }  
  /**
   * Подсчитывает символы в строке.
   * Если рекесп подходит к строке а не к отдельному символу, то берётся нулевой символ найденой строки.
   * @param inputString Строка в для которой будет происходить подсчёт
   * @return Текущее состояние хеша 
   */
  public HashMap<Character, Integer> update(String inputString) {
    Matcher matcher = pattern.matcher(inputString);
    while (matcher.find()) {
      String matched = matcher.group();
      char charAtZero = matched.charAt(0);
      
      Integer value = charHash.get(charAtZero);      
      charHash.put(charAtZero, (value == null) ? 1 : value + 1);      
      
    }
    return charHash;
  }
  /**
   * Очищает хеш
   */
  public void clear() {
    charHash.clear();    
  }  
  public HashMap<Character,Integer> getCurrentState() {
    return charHash;    
  }
  @Override
  public String toString() {    
    return charHash.toString();
  }
}

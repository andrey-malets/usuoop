package test;

import java.util.HashMap;
import java.util.Random;

import general.CharWorker;
import junit.framework.TestCase;



public class MyTestCase  extends TestCase {
  public static String getRandomString(int length,char ABC[]) {
    StringBuffer stringBuffer = new StringBuffer();
    Random random = new Random();
    for (int i = 0;i < length; ++i) {
      stringBuffer.append( ABC[ random.nextInt( ABC.length ) ] );
    }
    return stringBuffer.toString();
  }
  public void testSimple() {    
    final char c = 'a';
    final int howManyTimes = 100;    
    final CharWorker charWorker = new CharWorker();
    
    for (int i = 0; i < howManyTimes; ++i) {
      charWorker.update(new String(new char[] { c }));
    }
    assertEquals(charWorker.getCurrentState().get(c).intValue(),howManyTimes);
  }
  public void testProperty() {
    final int length = 100;
    final int howManyTimes = 100;    
    final char ABC[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};    
    final CharWorker charWorker = new CharWorker();
    
    for (int i = 0;i < howManyTimes; ++i) {
      String firstTestString = getRandomString(length, ABC);
      String secondTestString = getRandomString(length, ABC);      
      String thirdTestString = firstTestString + secondTestString;
      
      charWorker.update(firstTestString);      
      HashMap<Character, Integer> firstUpdate = charWorker.update(secondTestString);
      
      charWorker.clear();
      
      HashMap<Character, Integer> secondUpdate = charWorker.update(thirdTestString);
      
      for (char c : firstUpdate.keySet()) {
        assertEquals(firstUpdate.get(c).intValue(),secondUpdate.get(c).intValue());
      }
    }
  }  
}

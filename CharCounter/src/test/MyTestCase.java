package test;

import java.util.Random;

import map.ImmutableMap;

import counter.HashCounter;

import junit.framework.TestCase;


public class MyTestCase  extends TestCase {
  public static String getRandomString(int length,Character ABC[]) {
    StringBuffer stringBuffer = new StringBuffer();
    Random random = new Random();
    for (int i = 0;i < length; ++i) {
      stringBuffer.append( ABC[ random.nextInt( ABC.length ) ] );
    }
    return stringBuffer.toString();
  }
  public void testSimple() {    
     final Character c[] = { 'a' };
    final String string = "a";
    final int howManyTimes = 100;
    
    HashCounter<Character> hashCounter = new HashCounter<Character>();   
    
    for (int i = 0; i < howManyTimes; ++i) {
      hashCounter.updateState(separator.Separator.getCharacterSeparator(string, c));
    }
    assertEquals(hashCounter.getCurrentState().get(c[0]).intValue(),howManyTimes);
  }
  
  public void testConcatProperty() {
    final int length = 10000;
    final int howManyTimes = 100;    
    final Character ABC[] = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
    HashCounter<Character> hashCounter = new HashCounter<Character>();
    for (int i = 0;i<howManyTimes; ++i) {
      String one = getRandomString(length, ABC);
      String two = getRandomString(length, ABC);
      String three = one + two;      
      
      hashCounter.updateState(separator.Separator.getCharacterSeparator(one, ABC));
      hashCounter.updateState(separator.Separator.getCharacterSeparator(two, ABC));    
      ImmutableMap<Character, Integer> firstState = hashCounter.getCurrentState();      
      hashCounter.clearState();
      
      hashCounter.updateState(separator.Separator.getCharacterSeparator(three, ABC));      
      ImmutableMap<Character, Integer> secondState = hashCounter.getCurrentState();
      hashCounter.clearState();
      
      for (Character character : hashCounter.getCurrentState().keySet()) {
        System.out.println(firstState.get(character));
        System.out.println(secondState.get(character));
        assertEquals(firstState.get(character).intValue(),secondState.get(character).intValue());
      }
    }
  }    
}

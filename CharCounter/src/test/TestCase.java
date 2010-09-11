package test;

import static org.junit.Assert.assertEquals;
import general.CharWorker;

import org.junit.Test;

public class TestCase {
  @Test
  public void simpleTest() {
    CharWorker charWorker = new CharWorker();
    charWorker.update("abc");    
    assertEquals(charWorker.toString(),"a - 1\nb - 1\nc - 1\n");
  }
  @Test
  public void voidTest() {
    CharWorker charWorker = new CharWorker();
    charWorker.update("");
    assertEquals(charWorker.toString(),"");
  }  
  @Test
  public void myRegexpTest() {
    CharWorker charWorker = new CharWorker("[A1a]");
    charWorker.update("ABCabc123");
    assertEquals(charWorker.toString(),"1 - 1\nA - 1\na - 1\n");
  }
  @Test
  public void largeTest() {
    CharWorker charWorker = new CharWorker("[a-zA-Z0-9]");
    charWorker.update("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789");
    String expected = "0 - 2\n" +
                      "1 - 2\n" +
                      "2 - 2\n" +
                      "3 - 2\n" +
                      "4 - 2\n" +
                      "5 - 2\n" +
                      "6 - 2\n" +
                      "7 - 2\n" +
                      "8 - 2\n" +
                      "9 - 2\n" +
                      "A - 2\n" +
                      "B - 2\n" +
                      "C - 2\n" +
                      "D - 2\n" +
                      "E - 2\n" +
                      "F - 2\n" +
                      "G - 2\n" +
                      "H - 2\n" +
                      "I - 2\n" + 
                      "J - 2\n" +
                      "K - 2\n" +
                      "L - 2\n" +
                      "M - 2\n" +
                      "N - 2\n" +
                      "O - 2\n" +
                      "P - 2\n" +
                      "Q - 2\n" +
                      "R - 2\n" +
                      "S - 2\n" +
                      "T - 2\n" +
                      "U - 2\n" +
                      "V - 2\n" +
                      "W - 2\n" +
                      "X - 2\n" +
                      "Y - 2\n" +
                      "Z - 2\n" +
                      "a - 2\n" +
    		              "b - 2\n" +
    		              "c - 2\n" +
    		              "d - 2\n" +
    		              "e - 2\n" +
    		              "f - 2\n" +
    		              "g - 2\n" +
    		              "h - 2\n" +
    		              "i - 2\n" + 
    		              "j - 2\n" +
    		              "k - 2\n" +
    		              "l - 2\n" +
    		              "m - 2\n" +
    		              "n - 2\n" +
    		              "o - 2\n" +
    		              "p - 2\n" +
    		              "q - 2\n" +
    		              "r - 2\n" +
    		              "s - 2\n" +
    		              "t - 2\n" +
    		              "u - 2\n" +
    		              "v - 2\n" +
    		              "w - 2\n" +
    		              "x - 2\n" +
    		              "y - 2\n" +
    		              "z - 2\n";
    assertEquals(charWorker.toString(), expected);
  }
  @Test
  public void multiStringTest() {
    CharWorker charWorker = new CharWorker();
    charWorker.update("abc\nefg");
    String expected = "a - 1\n" +
                      "b - 1\n" +
                      "c - 1\n" +                      
                      "e - 1\n" +
                      "f - 1\n" +
                      "g - 1\n";
    assertEquals(charWorker.toString(),expected);
  }
}

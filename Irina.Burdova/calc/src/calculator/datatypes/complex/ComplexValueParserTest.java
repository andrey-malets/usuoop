package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.OperationNotSupportedException;

import java.util.Random;
import calculator.ParseValueException;
import junit.framework.TestCase;

public class ComplexValueParserTest extends TestCase {
       public void testSimpleNumbers() throws ParseValueException
       {
               ComplexValueParser p = new ComplexValueParser();
               AbstractValue v1 = p.parse("1+1*i"), v2 = p.parse("1-1*i");
               assertTrue(v1 instanceof ComplexValue);
               assertTrue(v2 instanceof ComplexValue);
               
              ComplexValue c1 = (ComplexValue)v1, c2 = (ComplexValue)v2;
              assertEquals(new ComplexValue(1, 1), c1);
              assertEquals(new ComplexValue(1, -1), c2);
       }
      public void testnew() throws ParseValueException, OperationNotSupportedException{
    	 for  (int  i = 0; i < 500000; i++){
	    	   ComplexValueParser p = new ComplexValueParser();
	    	   ComplexValueParser q = new ComplexValueParser();
	    	   Random random = new Random();
	    	   double x = random.nextInt() + 1;
	    	   double y = Math.abs( random.nextInt() + 1);
	    	   double k = random.nextInt() + 1;
	    	   double l = Math.abs(random.nextInt() + 1);
	    	   String string1 = x + "+" + y +"*i";
	    	   String string2 = k + "+" + l +"*i";
	    	   assertEquals(new ComplexValue(x + k, y + l), p.parse(string1).add(q.parse(string2)));
	    	   assertEquals(new ComplexValue(x - k, y - l), p.parse(string1).sub(q.parse(string2)));
    	  }
       }
}
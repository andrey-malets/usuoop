package calculator.datatypes.vector;

import java.util.Random;

import calculator.AbstractValue;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import junit.framework.TestCase;

public class VectorValueParserTest extends TestCase {
	public void simpleNumbers(String val1, VectorValue vec) throws ParseValueException {
		VectorValueParser p = new VectorValueParser();
		AbstractValue v1 = p.parse(val1);
		assertTrue(v1 instanceof VectorValue);
		assertEquals(v1, vec);

		
	}
	public void testSimple() throws ParseValueException {
		simpleNumbers("(1,2)", new VectorValue(1, 2));
		simpleNumbers("(1.,2.)", new VectorValue(1, 2));
		simpleNumbers("(1.5,2)", new VectorValue(1.5, 2));
		simpleNumbers("(-1,.2)", new VectorValue(-1, 0.2));
		simpleNumbers("(1,-.2)", new VectorValue(1, -0.2));
		
	}
	public void testnew() throws ParseValueException, OperationNotSupportedException{
   	 for  (int  i = 0; i < 5000; i++){
	    	   VectorValueParser p = new VectorValueParser();
	    	   VectorValueParser q = new VectorValueParser();
	    	   Random random = new Random();
	    	   double x = random.nextDouble() + 1;
	    	   double y = random.nextDouble() + 1;
	    	   double k = random.nextDouble() + 1;
	    	   double l = random.nextDouble() + 1;
	    	   String string1 = "(" + x + "," + y +")";
	    	   String string2 = "(" + k + "," + l +")";
	    	   assertEquals(new VectorValue(x + k, y + l), p.parse(string1).add(q.parse(string2)));
	    	   assertEquals(new VectorValue(x - k, y - l), p.parse(string1).sub(q.parse(string2)));
   	  }
      }

}

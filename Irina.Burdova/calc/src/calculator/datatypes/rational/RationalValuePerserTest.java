package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.ParseValueException;
import junit.framework.TestCase;


public class RationalValuePerserTest extends TestCase {
	public void simpleNumbers(String val1, RationalValue vec) throws ParseValueException {
		RationalValueParser p = new RationalValueParser();
		AbstractValue v1 = p.parse(val1);
		assertTrue(v1 instanceof RationalValue);
		assertEquals(v1, vec);

		
	}
	public void testSimple() throws ParseValueException {
		simpleNumbers("1/2", new RationalValue(1, 2));
		simpleNumbers("100/10", new RationalValue(100, 10));
		simpleNumbers("3/7", new RationalValue(3, 7));
		simpleNumbers("0", new RationalValue(0, 1));
		//simpleNumbers("3/7", new RationalValue(3, 7));
		
	}
}

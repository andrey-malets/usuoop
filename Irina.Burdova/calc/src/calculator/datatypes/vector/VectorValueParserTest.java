package calculator.datatypes.vector;

import calculator.AbstractValue;
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
	

}

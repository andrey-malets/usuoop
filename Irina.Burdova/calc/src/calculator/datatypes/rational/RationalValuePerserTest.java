package calculator.datatypes.rational;


import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.ParseValueException;
import calculator.datatypes.rational.RationalValue.Natural;
import junit.framework.TestCase;


public class RationalValuePerserTest extends TestCase {
	public void simpleNumbers(String val1, RationalValue vec) throws ParseValueException {
		RationalValueParser p = new RationalValueParser();
		AbstractValue v1 = p.parse(val1);
		assertTrue(v1 instanceof RationalValue);
		assertEquals(v1, vec);

		
	}
	public void testSimple() throws ParseValueException {
		try{
		simpleNumbers("1/2", RationalValue.get(new Natural(1), new Natural(2)));
		simpleNumbers("100/10", RationalValue.get(new Natural(10), new Natural(1)));
		simpleNumbers("3/7", RationalValue.get(new Natural(3), new Natural(7)));
		}
		catch(DivisionByZeroException e){
			System.out.println("DivisionByZero: "+e.getMessage());
		}
	}

}

package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.ParseValueException;
import junit.framework.TestCase;

public class ComplexValueParserTest extends TestCase {
       public void testSimpleNumbers() throws ParseValueException
       {
               ComplexValueParser p = new ComplexValueParser();
               AbstractValue v1 = p.parse("1.0+1.0*i"), v2 = p.parse("1.0-1.0*i");
               assertTrue(v1 instanceof ComplexValue);
               assertTrue(v2 instanceof ComplexValue);
               
              ComplexValue c1 = (ComplexValue)v1, c2 = (ComplexValue)v2;
              assertEquals(new ComplexValue(1, 1), c1);
              assertEquals(new ComplexValue(1, -1), c2);
       }
}
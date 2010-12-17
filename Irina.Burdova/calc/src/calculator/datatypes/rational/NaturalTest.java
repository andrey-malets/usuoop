package calculator.datatypes.rational;

import junit.framework.TestCase;
import calculator.datatypes.rational.Natural;
import calculator.DivisionByZeroException;

public class NaturalTest extends TestCase{
	public void testS(){
		try{
			Natural a = new Natural(17843);
			Natural b = new Natural(17896);
			assertEquals(b.sub(a), new Natural(53));
			assertEquals(b.add(a), new Natural(35739));
			assertEquals(b.mul(a), new Natural(319318328));
		}
		catch (DivisionByZeroException e) {
			System.out.println("DivisionByZero: "+e.getMessage());
		}
	}
	public void testnod(){
		try{
			Natural a = new Natural(8);
			Natural b = new Natural(6);
			assertEquals(b.nod(a), new Natural(2));
			
		}
		catch (DivisionByZeroException e) {
			System.out.println("DivisionByZero: "+e.getMessage());
		}
	}
	
}

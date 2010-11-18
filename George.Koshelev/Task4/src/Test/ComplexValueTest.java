package Test;

import java.util.Random;

import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Fields.ComplexValue;


import junit.framework.TestCase;

public class ComplexValueTest extends TestCase {

	public void testAdd2() throws OperationNotSupportedException{
		Random rn = new Random();
		ComplexValue a = new ComplexValue(rn.nextDouble(),rn.nextDouble());
		ComplexValue b = new ComplexValue(rn.nextInt(),rn.nextInt());		
		assertEquals(((ComplexValue)a.add(b)).getReElem(), ((ComplexValue)b.add(a)).getReElem());
		assertEquals(((ComplexValue)a.add(b)).getImElem(), ((ComplexValue)b.add(a)).getImElem());
	}
	public void testMul1() throws OperationNotSupportedException{
		Random rn = new Random();
		ComplexValue a = new ComplexValue(rn.nextDouble(),rn.nextDouble());
		ComplexValue b = new ComplexValue(rn.nextDouble(),rn.nextDouble());		
		assertEquals(((ComplexValue)a.mul(b)).getReElem(), ((ComplexValue)b.mul(a)).getReElem());
		assertEquals(((ComplexValue)a.mul(b)).getImElem(), ((ComplexValue)b.mul(a)).getImElem());	
	}
	public void testSub1() throws OperationNotSupportedException{
		Random rn = new Random();
		ComplexValue a = new ComplexValue(rn.nextDouble(),rn.nextDouble());
		ComplexValue b = new ComplexValue(rn.nextInt(),rn.nextInt());		
		assertEquals(Math.abs(((ComplexValue)a.sub(b)).getReElem()), Math.abs(((ComplexValue)b.sub(a)).getReElem()));
		assertEquals(Math.abs(((ComplexValue)a.sub(b)).getImElem()), Math.abs(((ComplexValue)b.sub(a)).getImElem()));
	}
	public void testDiv1() throws DivisionByZeroException, OperationNotSupportedException{
		Random rn = new Random();
		ComplexValue a = new ComplexValue(rn.nextDouble(),rn.nextDouble());
		assertEquals(((ComplexValue)a.div(a)).getReElem(),1.);
		assertEquals(((ComplexValue)a.div(a)).getImElem(),0.);	
	}
}

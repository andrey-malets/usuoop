package testFields;

import java.util.Random;

import exceptions.MyException;
import field.RealNumbField;

import junit.framework.TestCase;

public class TestRealNumbField extends TestCase {
	public void testAdd() {
		Random rn = new Random();
		RealNumbField a = new RealNumbField(rn.nextInt());
		RealNumbField b = new RealNumbField(rn.nextDouble());
		assertEquals(a.add(b).getElem(), b.add(a).getElem());
	}

	public void testAdd1() {
		Random rn = new Random();
		RealNumbField a = new RealNumbField(rn.nextInt());
		RealNumbField b = new RealNumbField(rn.nextDouble());
		RealNumbField c = new RealNumbField(rn.nextDouble());
		assertEquals(a.add(b.add(c)).getElem(), c.add(b.add(a)).getElem(),
				0.00001);
	}

	public void testAdd2() {
		Random rn = new Random();
		RealNumbField a = new RealNumbField(rn.nextInt());
		RealNumbField b = new RealNumbField();
		assertEquals(a.add(b).getElem(), a.getElem());
	}

	public void testAddNeg() {
		Random rn = new Random();
		RealNumbField a = new RealNumbField(rn.nextDouble());
		assertEquals(-a.getElem(), a.negativeNumb().getElem());
	}

	public void testMul() {
		Random rn = new Random();
		RealNumbField a = new RealNumbField(rn.nextDouble());
		RealNumbField b = new RealNumbField(rn.nextDouble());
		assertEquals(a.mul(b).getElem(), b.mul(a).getElem());
	}

	public void testMul2() {
		Random rn = new Random();
		RealNumbField a = new RealNumbField(rn.nextInt());
		RealNumbField b = new RealNumbField(rn.nextDouble());
		RealNumbField c = new RealNumbField(rn.nextDouble());
		assertEquals(a.mul(b.mul(c)).getElem(), c.mul(b.mul(a)).getElem(),
				0.00001);
	}

	public void testMul3() {
		Random rn = new Random();
		RealNumbField a = new RealNumbField(rn.nextInt());
		RealNumbField b = new RealNumbField(1);
		assertEquals(a.mul(b).getElem(), a.getElem());
	}
	public void testMulRev() throws MyException{
		Random rn = new Random();
		RealNumbField a = new RealNumbField(rn.nextDouble());
		assertEquals(a.mul(a.oppositeNumb()).getElem(), 1.);
	}
}

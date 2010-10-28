package testFields;

import exceptions.MyException;
import field.BinField;
import junit.framework.TestCase;

public class TestBinField extends TestCase {
public void testAdd() throws MyException{
	BinField a = new BinField(1);
	assertEquals(a.add(a).getElem(), new Integer(0));
					}
public void testAdd1() throws MyException{
	BinField a = new BinField(0);
	BinField b = new BinField(1);
	assertEquals(a.add(b).getElem(), b.add(a).getElem());
}
public void testMul() throws MyException {
	BinField a = new BinField(0);
	BinField b = new BinField(1);
	assertEquals(a.mul(b).getElem(), b.mul(a).getElem());
}
public void testDivide() throws MyException{
	BinField a = new BinField(1);
	assertEquals(a.divide(1.).intValue(),1);
}
}

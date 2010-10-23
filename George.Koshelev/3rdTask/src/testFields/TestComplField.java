package testFields;

import java.util.Random;

import field.ComplField;
import junit.framework.TestCase;

public class TestComplField extends TestCase {
public void testConstr1(){
	ComplField a = new ComplField();
	assertEquals(a.getImElem(),a.getReElem());
}
public void testConstr2(){
		Random rn = new Random();
		Integer in = rn.nextInt(100);
		ComplField a = new ComplField(in,in);
		assertEquals(a.getImElem(), a.getReElem());
}
public void testConstr3(){
	Random rn = new Random();
	Integer in = rn.nextInt(100);
	Double dou = in.doubleValue();
	ComplField a = new ComplField(in,dou);
	assertEquals(a.getImElem(), a.getReElem());
}
public void testConstr4(){
	Random rn = new Random();
	Double dou = rn.nextDouble();
	ComplField a = new ComplField(dou,dou);
	assertEquals(a.getImElem(), a.getReElem());
}

public void testAdd2(){
	Random rn = new Random();
	ComplField a = new ComplField(rn.nextInt(),rn.nextInt());
	ComplField b = new ComplField(rn.nextInt(),rn.nextInt());		
	assertEquals(a.add(b).getReElem(), b.add(a).getReElem());
	assertEquals(a.add(b).getImElem(), b.add(a).getImElem());	
}
public void testMul1(){
	Random rn = new Random();
	ComplField a = new ComplField(rn.nextDouble(),rn.nextDouble());
	ComplField b = new ComplField(rn.nextDouble(),rn.nextDouble());		
	assertEquals(a.mul(b).getReElem(), b.mul(a).getReElem());
	assertEquals(a.mul(b).getImElem(), b.mul(a).getImElem());	
}
public void testMul2(){
	Random rn = new Random();
	ComplField a = new ComplField(rn.nextInt(),rn.nextInt());
	ComplField b = new ComplField(rn.nextDouble(),rn.nextDouble());		
	assertEquals(a.mul(b).getReElem(), b.mul(a).getReElem());
	assertEquals(a.mul(b).getImElem(), b.mul(a).getImElem());	
}
public void testNegat(){
	Random rn = new Random();
	ComplField a = new ComplField(rn.nextInt(),rn.nextInt());
	assertEquals(-a.getReElem(), a.negativeNumb().getReElem());
}
}
package Test;

import java.util.Random;

import Exceptions.DivisionByZeroException;
import Fields.RealValue;
import junit.framework.TestCase;

public class RealValueTest extends TestCase {
public static void testCheckZero(){
	RealValue a = new RealValue(0);
	assertEquals(a.checkZero(), true);
	a = new RealValue(1);
	assertEquals(a.checkZero(), false);
}
public static void testAdd1(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue int2 = new RealValue(rn.nextDouble());
	assertEquals(((RealValue)int1.add(int2)).getReal(),((RealValue)int2.add(int1)).getReal(),0001);
}
public static void testAdd2(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue int2 = new RealValue(rn.nextDouble());
	RealValue int3 = new RealValue(rn.nextDouble());
	assertEquals(((RealValue)int3.add(int1.add(int2))).getReal(),((RealValue)int1.add(int2.add(int3))).getReal(),0.0001);
}
public static void testAdd3(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue nul = new RealValue(0);
	assertEquals(((RealValue)int1.add(nul)).getReal(), int1.getReal(),0.00001);
}
public static void testAdd4(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue int2 = new RealValue(-int1.getReal());
	assertEquals(((RealValue)int1.add(int2)).getReal(),0.);
	}
public static void testSub1(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue int2 = new RealValue(rn.nextDouble());
	assertEquals(Math.abs(((RealValue)int1.sub(int2)).getReal()),Math.abs(((RealValue)int2.sub(int1)).getReal()));
}
public static void testSub2(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue nul = new RealValue(0);
	assertEquals(((RealValue)int1.sub(nul)).getReal(), int1.getReal());
}
public static void testSub3(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue int2 = new RealValue(int1.getReal());
	assertEquals(((RealValue)int1.sub(int2)).getReal(),0.);
	}
public static void testMul1(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue int2 = new RealValue(rn.nextDouble());
	assertEquals(((RealValue)int1.mul(int2)).getReal(),((RealValue)int2.mul(int1)).getReal());
}
public static void testMul2(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue int2 = new RealValue(rn.nextDouble());
	RealValue int3 = new RealValue(rn.nextDouble());
	assertEquals(((RealValue)int3.mul(int1.mul(int2))).getReal(),((RealValue)int1.mul(int2.mul(int3))).getReal(),00001);
}
public static void testMul3(){
	Random rn = new Random();
	RealValue int1 = new RealValue(rn.nextDouble());
	RealValue nul = new RealValue(0.);
	assertEquals(((RealValue)int1.mul(nul)).getReal(), 0.);
}
public static void testDiv1() throws DivisionByZeroException{
	Random rn = new Random();
	RealValue a = new RealValue(rn.nextDouble());
	assertEquals(((RealValue)a.div(a)).getReal(), 1.);
}
}

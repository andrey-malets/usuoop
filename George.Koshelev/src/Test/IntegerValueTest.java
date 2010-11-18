package Test;

import java.util.Random;

import Exceptions.DivisionByZeroException;
import Fields.IntegerValue;
import junit.framework.TestCase;

public class IntegerValueTest extends TestCase {
public static void testCheckZero(){
	IntegerValue a = new IntegerValue(0);
	assertEquals(a.checkZero(), true);
	a = new IntegerValue(1);
	assertEquals(a.checkZero(), false);
}
public static void testAdd1(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue int2 = new IntegerValue(rn.nextInt());
	assertEquals(((IntegerValue)int1.add(int2)).getInt(),((IntegerValue)int2.add(int1)).getInt());
}
public static void testAdd2(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue int2 = new IntegerValue(rn.nextInt());
	IntegerValue int3 = new IntegerValue(rn.nextInt());
	assertEquals(((IntegerValue)int3.add(int1.add(int2))).getInt(),((IntegerValue)int1.add(int2.add(int3))).getInt());
}
public static void testAdd3(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue nul = new IntegerValue(0);
	assertEquals(((IntegerValue)int1.add(nul)).getInt(), int1.getInt());
}
public static void testAdd4(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue int2 = new IntegerValue(-int1.getInt());
	assertEquals(((IntegerValue)int1.add(int2)).getInt(),0);
	}
public static void testSub1(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue int2 = new IntegerValue(rn.nextInt());
	assertEquals(Math.abs(((IntegerValue)int1.sub(int2)).getInt()),Math.abs(((IntegerValue)int2.sub(int1)).getInt()));
}
public static void testSub2(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue nul = new IntegerValue(0);
	assertEquals(((IntegerValue)int1.sub(nul)).getInt(), int1.getInt());
}
public static void testSub3(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue int2 = new IntegerValue(int1.getInt());
	assertEquals(((IntegerValue)int1.sub(int2)).getInt(),0);
	}
public static void testMul1(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue int2 = new IntegerValue(rn.nextInt());
	assertEquals(((IntegerValue)int1.mul(int2)).getInt(),((IntegerValue)int2.mul(int1)).getInt());
}
public static void testMul2(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue int2 = new IntegerValue(rn.nextInt());
	IntegerValue int3 = new IntegerValue(rn.nextInt());
	assertEquals(((IntegerValue)int3.mul(int1.mul(int2))).getInt(),((IntegerValue)int1.mul(int2.mul(int3))).getInt());
}
public static void testMul3(){
	Random rn = new Random();
	IntegerValue int1 = new IntegerValue(rn.nextInt());
	IntegerValue nul = new IntegerValue(0);
	assertEquals(((IntegerValue)int1.mul(nul)).getInt(), 0);
}
public static void testDiv1() throws DivisionByZeroException{
	Random rn = new Random();
	IntegerValue a = new IntegerValue(rn.nextInt());
	assertEquals(((IntegerValue)a.div(a)).getInt(), 1);
}
}

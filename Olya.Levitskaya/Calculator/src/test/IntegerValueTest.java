package test;

import java.util.Random;
import junit.framework.TestCase;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;

public class IntegerValueTest extends TestCase{
	
	public static int generingNum(int range)
	{
		Random random = new Random();
	    int res = random.nextInt(range);
	    return res;
	 }
	public static String convertIntToString() {
		final int range = 100; 
	    int aInt = generingNum(range);
	    
	    //String aString = Integer.toString(aInt);
	    String aString = String.format("%s", aInt);
		return aString;
	      
	  }
	
public void testKommutAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertIntToString();
	String b = convertIntToString();
	Calculator calculator = new Calculator(new IntegerValueParser());
	
	assertEquals(calculator.calculate(a, "+", b),calculator.calculate(b, "+", a));
	}
public void testAssotAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertIntToString();
	String b = convertIntToString();
	String c = convertIntToString();
	Calculator calculator = new Calculator(new IntegerValueParser());
	
	assertEquals(calculator.calculate(calculator.calculate(a, "+", b), "+", c),calculator.calculate(a, "+", calculator.calculate(b, "+", c)));
	}
public void testNeitralElAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertIntToString();
	int neitral = 0;
    String neitralS = Integer.toString(neitral);
	Calculator calculator = new Calculator(new IntegerValueParser());
	
	assertEquals(calculator.calculate(a, "+", neitralS),a);
	}
public void testSub() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertIntToString();
	String b = convertIntToString();
	Calculator calculator = new Calculator(new IntegerValueParser());
	String c = calculator.calculate(a, "-", b);
	assertEquals(calculator.calculate(b, "+", c),a);
}
public void testNeitralElSub() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertIntToString();
	int neitral = 0;
    String neitralS = Integer.toString(neitral);
	Calculator calculator = new Calculator(new IntegerValueParser());
	
	assertEquals(calculator.calculate(a, "-", neitralS),a);
	}
public void testKommutMul() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertIntToString();
	String b = convertIntToString();
	Calculator calculator = new Calculator(new IntegerValueParser());
	
	assertEquals(calculator.calculate(a, "*", b),calculator.calculate(b, "*", a));
	}
public void testAssotMul() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertIntToString();
	String b = convertIntToString();
	String c = convertIntToString();
	Calculator calculator = new Calculator(new IntegerValueParser());
	
	assertEquals(calculator.calculate(calculator.calculate(a, "*", b), "*", c),calculator.calculate(a, "*", calculator.calculate(b, "*", c)));
	}
public void testNeitralElMul() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertIntToString();
	int neitral = 1;
    String neitralS = Integer.toString(neitral);
	Calculator calculator = new Calculator(new IntegerValueParser());
	
	assertEquals(calculator.calculate(a, "*", neitralS),a);
	}
//public void testDiv() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
//	String a = convertIntToString();
//	String b = convertIntToString();
//	Calculator calculator = new Calculator(new IntegerValueParser());
//	String c = calculator.calculate(a, "/", b);
//	String d = calculator.calculate(b, "*", c);
//	assertEquals(d,a);
//	}
public void testNeitralElDiv() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertIntToString();
	int neitral = 1;
    String neitralS = Integer.toString(neitral);
	Calculator calculator = new Calculator(new IntegerValueParser());
	
	assertEquals(calculator.calculate(a, "/", neitralS),a);
	}
}

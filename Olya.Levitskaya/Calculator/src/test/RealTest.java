package test;

import java.util.Random;

import junit.framework.TestCase;
import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import calculator.datatypes.real.RealValueParser;


public class RealTest extends TestCase{
	
	public static double generingNum(int range)
	{
		Random random = new Random();
	    double res = random.nextInt(range);
	    return res;
	 }
	public static String convertDoubleToString() {
		final int range = 100; 
	    double a = generingNum(range);
	    //String aString = Double.toString(a);
	    String aString = String.format("%s", a);
	    return aString;
	      
	  }
	
public void testKommutAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	String b = convertDoubleToString();
	Calculator calculator = new Calculator(new RealValueParser());
	
	assertEquals(calculator.calculate(a, "+", b),calculator.calculate(b, "+", a));
	}
public void testAssotAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	String b = convertDoubleToString();
	String c = convertDoubleToString();
	Calculator calculator = new Calculator(new RealValueParser());
	
	assertEquals(calculator.calculate(calculator.calculate(a, "+", b), "+", c),calculator.calculate(a, "+", calculator.calculate(b, "+", c)));
	}
public void testNeitralElAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	int neitral = 0;
    String neitralS = Double.toString(neitral);
	Calculator calculator = new Calculator(new RealValueParser());
	
	assertEquals(calculator.calculate(a, "+", neitralS),a);
	}
public void testSub() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	String b = convertDoubleToString();
	Calculator calculator = new Calculator(new RealValueParser());
	String c = calculator.calculate(a, "-", b);
	assertEquals(calculator.calculate(b, "+", c),a);
}
public void testNeitralElSub() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	int neitral = 0;
    String neitralS = Double.toString(neitral);
	Calculator calculator = new Calculator(new RealValueParser());
	
	assertEquals(calculator.calculate(a, "-", neitralS),a);
	}
public void testKommutMul() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	String b = convertDoubleToString();
	Calculator calculator = new Calculator(new RealValueParser());
	
	assertEquals(calculator.calculate(a, "*", b),calculator.calculate(b, "*", a));
	}
public void testAssotMul() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	String b = convertDoubleToString() ;
	String c = convertDoubleToString();
	Calculator calculator = new Calculator(new RealValueParser());
	
	assertEquals(calculator.calculate(calculator.calculate(a, "*", b), "*", c),calculator.calculate(a, "*", calculator.calculate(b, "*", c)));
	}
public void testNeitralElMul() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	int neitral = 1;
    String neitralS = Double.toString(neitral);
	Calculator calculator = new Calculator(new RealValueParser());
	
	assertEquals(calculator.calculate(a, "*", neitralS),a);
	}
public void testDiv() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	String b = convertDoubleToString();
	Calculator calculator = new Calculator(new RealValueParser());
	String c = calculator.calculate(a, "/", b);
	String d = calculator.calculate(b, "*", c);
	assertEquals(d,a);
	}
public void testNeitralElDiv() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = convertDoubleToString();
	int neitral = 1;
    String neitralS = Double.toString(neitral);
	Calculator calculator = new Calculator(new RealValueParser());
	
	assertEquals(calculator.calculate(a, "/", neitralS),a);
	}
}

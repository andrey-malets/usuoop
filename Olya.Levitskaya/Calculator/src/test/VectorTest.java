package test;

import java.util.Random;

import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import junit.framework.TestCase;
import calculator.datatypes.vector.VectorValueParser;


public class VectorTest extends TestCase{
	public static int generingNum(int range)
	{
		Random random = new Random();
	    int res = random.nextInt(range);
	    return res;
	 }
	public static String generingVector(){
		final int range = 100;		
	    double aInt = generingNum(range);
	    double bInt = generingNum(range);
	    double cInt = generingNum(range);
	    String vector = String.format("(%1s,%2s,%3s)", aInt, bInt, cInt);
		
		return vector;
	      
	  }
	
public void testKommutAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = generingVector();
	String b = generingVector();
	Calculator calculator = new Calculator(new VectorValueParser());
	
	assertEquals(calculator.calculate(a, "+", b),calculator.calculate(b, "+", a));
	}
public void testAssotAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = generingVector();
	String b = generingVector();
	String c = generingVector();
	Calculator calculator = new Calculator(new VectorValueParser());
	
	assertEquals(calculator.calculate(calculator.calculate(a, "+", b), "+", c),calculator.calculate(a, "+", calculator.calculate(b, "+", c)));
	}
public void testNeitralElAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = generingVector();
	double neitral = 0;
    
	String neitralS = String.format("(%s,%s,%s)", neitral, neitral, neitral);
	Calculator calculator = new Calculator(new VectorValueParser());
	
	assertEquals(calculator.calculate(a, "+", neitralS),a);
	}
public void testSub() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
	String a = generingVector();
	String b = generingVector();
	Calculator calculator = new Calculator(new VectorValueParser());
	String c = calculator.calculate(a, "-", b);
	assertEquals(calculator.calculate(b, "+", c),a);
}

}

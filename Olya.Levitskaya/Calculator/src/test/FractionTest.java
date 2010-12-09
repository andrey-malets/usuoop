package test;

import junit.framework.TestCase;
import java.util.Random;
import calculator.datatypes.fraction.FractionValueParser;
import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;

public class FractionTest extends TestCase{
	public static int generingNum(int range)
	{
		Random random = new Random();
	    int res = random.nextInt(range);
	    return res;
	 }
	
	public static int NOD(int a,int b) 
	{
		while (b !=0) 
		{
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		return a;
	}
	
	public static String generingFraction() {
		final int range = 100; 
	    int aInt = generingNum(range);
	    int bInt = generingNum(range);
	    int nod = NOD(aInt,bInt);
	    if (nod != 1) {
	    	aInt /= nod;
	    	bInt /= nod;
	    }
	    String fraction = String.format("%s/%s", aInt, bInt);
		return fraction;
	}
		
	public void testKommutAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
			String a = generingFraction();
			String b = generingFraction();
			Calculator calculator = new Calculator(new FractionValueParser());
			
			assertEquals(calculator.calculate(a, "+", b),calculator.calculate(b, "+", a));
			}
	public void testAssotAdd() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
			String a = generingFraction();
			String b = generingFraction();
			String c = generingFraction();
			Calculator calculator = new Calculator(new FractionValueParser());
			
			assertEquals(calculator.calculate(calculator.calculate(a, "+", b), "+", c),calculator.calculate(a, "+", calculator.calculate(b, "+", c)));
			}
	
	public void testSub() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
			String a = generingFraction();
			String b = generingFraction();
			Calculator calculator = new Calculator(new FractionValueParser());
			String c = calculator.calculate(a, "-", b);
			String d = calculator.calculate(b, "+", c);
			assertEquals(d,a);
		}
	
	public void testKommutMul() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
			String a = generingFraction();
			String b = generingFraction();
			Calculator calculator = new Calculator(new FractionValueParser());			
			assertEquals(calculator.calculate(a, "*", b),calculator.calculate(b, "*", a));
			}
	public void testAssotMul() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
			String a = generingFraction();
			String b = generingFraction();
			String c = generingFraction();
			Calculator calculator = new Calculator(new FractionValueParser());
			
			assertEquals(calculator.calculate(calculator.calculate(a, "*", b), "*", c),calculator.calculate(a, "*", calculator.calculate(b, "*", c)));
			}
	
	public void testNeitralElDiv() throws ParseValueException, DivisionByZeroException, OperationNotSupportedException{
			String a = generingFraction();
			
			int neitral = 1;
		    String neitralS = String.format("%s/%s", neitral, neitral);
		    Calculator calculator = new Calculator(new FractionValueParser());
			String res = calculator.calculate(a, "/", neitralS);
			assertEquals(res,a);
			}	      
	  
}

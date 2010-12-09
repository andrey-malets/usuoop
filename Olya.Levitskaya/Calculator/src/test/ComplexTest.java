package test;

import java.util.Random;

import junit.framework.TestCase;
import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import calculator.datatypes.complex.ComplexValueParser;

public class ComplexTest extends TestCase {
	public static int generingNum(int range) {
		Random random = new Random();
		int res = random.nextInt(range);
		return res;
	}

	public static String generingComplex() {
		final int range = 100;
		double aInt = generingNum(range);
		double bInt = generingNum(range);
		String complex = String.format("%s+%si", aInt, bInt);
		return complex;

	}

	public void testKommutAdd() throws ParseValueException,
			DivisionByZeroException, OperationNotSupportedException {
		String a = generingComplex();
		String b = generingComplex();
		Calculator calculator = new Calculator(new ComplexValueParser());

		assertEquals(calculator.calculate(a, "+", b),
				calculator.calculate(b, "+", a));
	}

	public void testAssotAdd() throws ParseValueException,
			DivisionByZeroException, OperationNotSupportedException {
		String a = generingComplex();
		String b = generingComplex();
		String c = generingComplex();
		Calculator calculator = new Calculator(new ComplexValueParser());

		assertEquals(
				calculator.calculate(calculator.calculate(a, "+", b), "+", c),
				calculator.calculate(a, "+", calculator.calculate(b, "+", c)));
	}

	public void testNeitralElAdd() throws ParseValueException,
			DivisionByZeroException, OperationNotSupportedException {
		String a = generingComplex();
		String neitralS = String.format("%s+%si", 0, 0);
		Calculator calculator = new Calculator(new ComplexValueParser());

		assertEquals(calculator.calculate(a, "+", neitralS), a);
	}

	public void testSub() throws ParseValueException, DivisionByZeroException,
			OperationNotSupportedException {
		String a = generingComplex();
		String b = generingComplex();
		Calculator calculator = new Calculator(new ComplexValueParser());
		String c = calculator.calculate(a, "-", b);
		assertEquals(calculator.calculate(b, "+", c), a);
	}

	public void testNeitralElSub() throws ParseValueException,
			DivisionByZeroException, OperationNotSupportedException {
		String a = generingComplex();		
		String neitralS = String.format("%s+%si", 0, 0);
		Calculator calculator = new Calculator(new ComplexValueParser());

		assertEquals(calculator.calculate(a, "-", neitralS), a);
	}

	public void testKommutMul() throws ParseValueException,
			DivisionByZeroException, OperationNotSupportedException {
		String a = generingComplex();
		String b = generingComplex();
		Calculator calculator = new Calculator(new ComplexValueParser());

		assertEquals(calculator.calculate(a, "*", b),
				calculator.calculate(b, "*", a));
	}

	public void testAssotMul() throws ParseValueException,
			DivisionByZeroException, OperationNotSupportedException {
		String a = generingComplex();
		String b = generingComplex();
		String c = generingComplex();
		Calculator calculator = new Calculator(new ComplexValueParser());

		assertEquals(
				calculator.calculate(calculator.calculate(a, "*", b), "*", c),
				calculator.calculate(a, "*", calculator.calculate(b, "*", c)));
	}

	public void testNeitralElMul() throws ParseValueException,
			DivisionByZeroException, OperationNotSupportedException {
		String a = generingComplex();
		String neitralS = String.format("%s+%si", 1, 0);
		Calculator calculator = new Calculator(new ComplexValueParser());

		assertEquals(calculator.calculate(a, "*", neitralS), a);
	}

	public void testNeitralElDiv() throws ParseValueException,
			DivisionByZeroException, OperationNotSupportedException {
		String a = generingComplex();
		String neitralS = String.format("%s+%si", 1, 0);
		Calculator calculator = new Calculator(new ComplexValueParser());

		assertEquals(calculator.calculate(a, "/", neitralS), a);
	}
}

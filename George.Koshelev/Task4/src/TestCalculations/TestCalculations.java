
package TestCalculations;

import Calculator.Calculator;
import Calculator.Program;
import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Exceptions.ParseValueException;
import Exceptions.ZeroDiscr;
import junit.framework.TestCase;

public class TestCalculations extends TestCase {
public void testIntegerField() throws ParseValueException, OperationNotSupportedException, DifferentDimensions, DivisionByZeroException, ZeroDiscr, Exception{
	Program pr = new Program();
	Calculator calc = new Calculator();
	String a = calc.calculate(calc.prepare(calc.run("5+(3-2)*9/3+1-8/(2+2)")),
			pr.chooseParser(1));
	assertEquals(a, "7");
}
public void testRealField() throws ParseValueException, OperationNotSupportedException, DifferentDimensions, DivisionByZeroException, ZeroDiscr, Exception{
	Program pr = new Program();
	Calculator calc = new Calculator();
	String a = calc.calculate(calc.prepare(calc.run("5.+(3.1-2.1)*9./(2.5+0.5)-8./(1.7+2.3)")),
			pr.chooseParser(2));
	assertEquals(a, "6.0");
}
public void testComplexField() throws ParseValueException, OperationNotSupportedException, DifferentDimensions, DivisionByZeroException, ZeroDiscr, Exception{
	Program pr = new Program();
	Calculator calc = new Calculator();
	String a = calc.calculate(calc.prepare(calc.run("((<1.;0.>+<0.;1.>)/<1.;1.>)*<2.;2.>+<0.;1.>")),
			pr.chooseParser(4));
	assertEquals(a, "<2.0;3.0>");
}
public void testFractionsField() throws ParseValueException, OperationNotSupportedException, DifferentDimensions, DivisionByZeroException, ZeroDiscr, Exception{
	Program pr = new Program();
	Calculator calc = new Calculator();
	String a = calc.calculate(calc.prepare(calc.run("(2:3+3:2)+1:2+9:6*2:3+1:3/1:3")),
			pr.chooseParser(3));
	assertEquals(a, "14:3");
}
public void testVectorFieldInteger() throws ParseValueException, OperationNotSupportedException, DifferentDimensions, DivisionByZeroException, ZeroDiscr, Exception{
	Program pr = new Program();
	Calculator calc = new Calculator();
	String a = calc.calculate(calc.prepare(calc.run("(<1.;2.;3.;4.>+<1.;2.;3.;4.>)-<2.;4.;6.;8.>")),
			pr.chooseParser(6));
	assertEquals(a,"<0.0;0.0;0.0;0.0>");
}
public void testVectorFieldReal() throws ParseValueException, OperationNotSupportedException, DifferentDimensions, DivisionByZeroException, ZeroDiscr, Exception{
	Program pr = new Program();
	Calculator calc = new Calculator();
	String a = calc.calculate(calc.prepare(calc.run("(<1;2;3;4>+<1;2;3;4>)-<2;4;6;8>")),
			pr.chooseParser(5));
	assertEquals(a,"<0;0;0;0>");

}
}

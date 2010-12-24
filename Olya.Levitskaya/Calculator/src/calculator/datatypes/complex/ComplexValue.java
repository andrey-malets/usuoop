package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
public class ComplexValue extends AbstractValue
{
	private final double value_real;
	private final double value_imag;


public ComplexValue(double value_real, double value_imag) 
{	super();
	this.value_real= value_real;
	this.value_imag = value_imag;
}

public String toString() {
  if ( value_imag >= 0) { 
    return Double.toString(value_real)+"+"+Double.toString(value_imag)+"i";
  } else {
    return Double.toString(value_real) + Double.toString(value_imag)+"i";
  }
}
public AbstractValue add(AbstractValue operand) {
	return new ComplexValue(value_real + ((ComplexValue) operand).value_real, value_imag + ((ComplexValue) operand).value_imag);
}

public AbstractValue sub(AbstractValue operand) {
	return new ComplexValue(value_real - ((ComplexValue) operand).value_real, value_imag - ((ComplexValue) operand).value_imag);
}

public AbstractValue mul(AbstractValue operand) {
	return new ComplexValue(value_real * ((ComplexValue) operand).value_real - value_imag * ((ComplexValue) operand).value_imag, value_real * ((ComplexValue) operand).value_imag + value_imag * ((ComplexValue) operand).value_real);
}

public AbstractValue div(AbstractValue operand)
		throws DivisionByZeroException {
	double ComplexValue = ((ComplexValue) operand).value_real * ((ComplexValue) operand).value_real + ((ComplexValue) operand).value_imag * ((ComplexValue) operand).value_imag ;
	if (ComplexValue == 0.0)  
		throw new DivisionByZeroException();
	double ComplexValue1 = value_real * ((ComplexValue) operand).value_real + value_imag * ((ComplexValue) operand).value_imag;
	double ComplexValue2 =value_imag * ((ComplexValue) operand).value_real - value_real * ((ComplexValue) operand).value_imag;
	return new ComplexValue(ComplexValue1/ComplexValue,ComplexValue2/ComplexValue);
}

public boolean equals(Object obj) {
	if (! (obj instanceof ComplexValue) ) {
		return false;
	}
	ComplexValue rhs = (ComplexValue) obj;
	if ( this.value_real == rhs.value_real && this.value_imag == rhs.value_imag)
		return true;
	return false;	
}

}
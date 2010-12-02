package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import java.lang.Math;

public class ComplexValue extends AbstractValue {
	private final double real, imaginary;

	public ComplexValue(double real, double imaginary) {
		super();
		this.real = real;
		this.imaginary = imaginary;
	}

	public String toString() {
		if (imaginary == 0.0){
			return real+"";
		}
		else{
			return real + "+" + imaginary + "*i";
		}
	}

	public AbstractValue add(AbstractValue operand) {
		return new ComplexValue(real + ((ComplexValue) operand).real, imaginary
				+ ((ComplexValue) operand).imaginary);
	}

	public AbstractValue sub(AbstractValue operand) {
		return new ComplexValue(real - ((ComplexValue) operand).real, imaginary
				- ((ComplexValue) operand).imaginary);
	}

	public AbstractValue mul(AbstractValue operand) {
		return new ComplexValue(real * ((ComplexValue) operand).real
				- imaginary * ((ComplexValue) operand).imaginary, imaginary
				* ((ComplexValue) operand).real + real
				* ((ComplexValue) operand).imaginary);
	}

	public AbstractValue div(AbstractValue operand) throws DivisionByZeroException {
		if (((ComplexValue) operand).real == 0.0 && ((ComplexValue) operand).imaginary == 0.0){
			throw new DivisionByZeroException();
		}
		double im = ((ComplexValue) operand).imaginary;
		double re = ((ComplexValue) operand).real;
		return new ComplexValue((real * ((ComplexValue) operand).real + imaginary * ((ComplexValue) operand).imaginary)/(Math.pow(re, 2) + Math.pow(im, 2)),(imaginary * ((ComplexValue) operand).real - real * ((ComplexValue) operand).imaginary)/(Math.pow(re, 2) + Math.pow(im, 2)));
	}
	
	public boolean equals(Object operand){
		if(operand != null && operand instanceof ComplexValue)
		{
			if (( Math.abs(real - ((ComplexValue) operand).real) <= 0.1) &&  (Math.abs((imaginary - ((ComplexValue) operand).imaginary)) <= 0.1)){
				return true;
			}
			if ((real  == ((ComplexValue) operand).real) &&  (imaginary == ((ComplexValue) operand).imaginary)){
				return true;
			}
			else{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
}

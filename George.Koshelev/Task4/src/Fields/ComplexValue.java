package Fields;

import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Fields.AbstractField;

public class ComplexValue extends AbstractField {
	private final double re;
	private final double im;

	public ComplexValue(double real, double image) {
		this.re = real;
		this.im = image;
	}
	public double getImElem(){
		return this.im;
	}
	public double getReElem(){
		return this.re;
	}
	public boolean checkZero(){
		if (Math.pow(this.re,2)+Math.pow(this.im,2)==0.){
			return true;
		}
		return false;
	}
	public AbstractField add(AbstractField operand)
			throws OperationNotSupportedException {
		return new ComplexValue(this.re + ((ComplexValue) operand).re, this.im
				+ ((ComplexValue) operand).im);
	}

	public AbstractField div(AbstractField operand)
			throws DivisionByZeroException, OperationNotSupportedException {
		double val_re = ((ComplexValue) operand).re;
		double val_im = ((ComplexValue) operand).im;
		if (val_re == 0 && val_im == 0) {
			throw new DivisionByZeroException();
		}
		double znam = Math.pow(val_im, 2) + Math.pow(val_re, 2);
		return new ComplexValue((this.re * val_re + this.im * val_im) / znam,
				(this.im * val_re - this.re * val_im) / znam);
	}

	public AbstractField mul(AbstractField operand)
			throws OperationNotSupportedException {
		double val_re = ((ComplexValue) operand).re;
		double val_im = ((ComplexValue) operand).im;
		return new ComplexValue((this.re * val_re - this.im * val_im), (this.im
				* val_re + this.re * val_im));
	}

	public AbstractField sub(AbstractField operand)
			throws OperationNotSupportedException {
		return new ComplexValue(this.re - ((ComplexValue) operand).re, this.im
				- ((ComplexValue) operand).im);
	}

	public String toString() {
		StringBuffer buff = new StringBuffer();
		buff.append('<');
		buff.append(this.re);
		buff.append(';');
		buff.append(this.im);
		buff.append('>');
		return buff.toString();
	}

}

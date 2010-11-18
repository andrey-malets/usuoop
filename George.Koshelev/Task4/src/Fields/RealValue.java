package Fields;

import Fields.AbstractField;
import Exceptions.DivisionByZeroException;

public class RealValue extends AbstractField {

	private final double value;

	public RealValue(double value) {
		super();
		this.value = value;
	}
	public double getReal(){
		return this.value;
	}
	public boolean checkZero(){
		if (this.value ==0.){
			return true;
		}
		return false;
	}
	public String toString() {
		return Double.toString(value);
	}

	public AbstractField add(AbstractField operand) {
		return new RealValue(value + ((RealValue) operand).value);
	}

	public AbstractField sub(AbstractField operand) {
		return new RealValue(value - ((RealValue) operand).value);
	}

	public AbstractField mul(AbstractField operand) {
		return new RealValue(value * ((RealValue) operand).value);
	}

	public AbstractField div(AbstractField operand)
			throws DivisionByZeroException {
		double realValue = ((RealValue) operand).value;
		if (realValue == 0.0)
			throw new DivisionByZeroException();
		return new RealValue(value / realValue);
	}

}

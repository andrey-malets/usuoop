package Fields;

import Exceptions.DivisionByZeroException;
import Fields.AbstractField;

public class IntegerValue extends AbstractField {
	private final int value;

	public IntegerValue(int value) {
		super();
		this.value = value;
	}
	public boolean checkZero(){
		if (this.value==0){
			return true;
		}
		return false;
	}
	public int getInt(){
		return this.value;
	}
	public String toString() {
		return Integer.toString(value);
	}

	public AbstractField add(AbstractField operand) {
		return new IntegerValue(value + ((IntegerValue) operand).value);
	}

	public AbstractField sub(AbstractField operand) {
		return new IntegerValue(value - ((IntegerValue) operand).value);
	}

	public AbstractField mul(AbstractField operand) {
		return new IntegerValue(value * ((IntegerValue) operand).value);
	}

	public AbstractField div(AbstractField operand)
			throws DivisionByZeroException {
		int intValue = ((IntegerValue) operand).value;
		if (intValue == 0)
			throw new DivisionByZeroException();
		return new IntegerValue(value / intValue);
	}

}

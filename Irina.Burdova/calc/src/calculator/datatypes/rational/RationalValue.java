package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class RationalValue extends AbstractValue {

	private final Integer numerator, denominator;
	
	public static final RationalValue ZERO = new RationalValue(0, 1);

	public RationalValue(int num, int denom) {
		super();
		int n = Math.abs(num);
		int d = Math.abs(denom);
		while (n != 0 && d != 0) {
			if (n >= d) {
				n = n % d;
			} else {
				d = d % n;
			}
		}
		int nod = n + d;
		numerator = num / nod;
		denominator = denom / nod;
	}

	public String toString() {
		if (numerator != 0) {
			return numerator + "/" + denominator;
		} else {
			return "0";
		}
	}

	public AbstractValue add(AbstractValue operand) {
		return new RationalValue(numerator
				* ((RationalValue) operand).denominator
				+ ((RationalValue) operand).numerator * denominator,
				denominator * ((RationalValue) operand).denominator);
	}

	public AbstractValue sub(AbstractValue operand) {
		return new RationalValue(numerator
				* ((RationalValue) operand).denominator
				- ((RationalValue) operand).numerator * denominator,
				denominator * ((RationalValue) operand).denominator);
	}

	public AbstractValue mul(AbstractValue operand) {
		return new RationalValue(numerator
				* ((RationalValue) operand).numerator, denominator
				* ((RationalValue) operand).denominator);
	}

	public AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException {
		int intValue = ((RationalValue) operand).numerator;
		if (intValue == 0)
			throw new DivisionByZeroException();
		return new RationalValue(numerator
				* ((RationalValue) operand).denominator, denominator
				* ((RationalValue) operand).numerator);
	}

	public boolean equals(Object operand) {
		if (operand != null && operand instanceof RationalValue) {
			if ((Math.abs(numerator - ((RationalValue) operand).numerator) <= 0.1)
					&& (Math.abs((denominator - ((RationalValue) operand).denominator)) <= 0.1)) {
				return true;
			}
			if ((numerator == ((RationalValue) operand).numerator)
					&& (denominator == ((RationalValue) operand).denominator)) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}

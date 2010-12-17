package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.datatypes.rational.Natural;

public class RationalValue extends AbstractValue {

	private Natural numerator, denominator;

	public RationalValue  (Natural num, Natural denom){
		super();
		Natural n = num;
		Natural d = denom;
		Natural nod = n.nod(d);
		numerator = num.div(nod);
		denominator = denom.div(nod);
	}

	public String toString() {
		return numerator + "/" + denominator;
	}

	public AbstractValue add(AbstractValue operand) {
		return new RationalValue(numerator.mul(((RationalValue) operand).denominator).add(((RationalValue) operand).numerator.mul(denominator)),
				denominator.mul(((RationalValue) operand).denominator));
	}

	public AbstractValue sub(AbstractValue operand) {
		return new RationalValue(numerator.mul(((RationalValue) operand).denominator).sub(((RationalValue) operand).numerator.mul(denominator)),
				denominator .mul(((RationalValue) operand).denominator));
	}

	public AbstractValue mul(AbstractValue operand) {
		return new RationalValue(numerator.mul(((RationalValue) operand).numerator), denominator.mul(((RationalValue) operand).denominator));
	}

	public AbstractValue div(AbstractValue operand){
		return new RationalValue(numerator.mul(((RationalValue) operand).denominator), denominator.mul(((RationalValue) operand).numerator));
	}

	public boolean equals(Object operand) {
		if (operand != null && operand instanceof RationalValue) {
			if ((numerator.equals(((RationalValue) operand).numerator))&& (denominator.equals(((RationalValue) operand).denominator))) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}

package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class RationalValue extends AbstractValue {

	public static class Natural{
		private final long value;
		public Natural(long value) throws DivisionByZeroException
		{
			if(value < 1)
				throw new DivisionByZeroException();
			this.value = value;
		}
		
		private Natural(long value, long unused)
		{
			this.value = value;
		}
		
		public Natural add(Natural another)
		{
			return new Natural(value + another.value, 0);
		}
		public Natural sub(Natural another) throws DivisionByZeroException
		{
			return new Natural(value - another.value);
		}
		public Natural mul(Natural another)
		{
			return new Natural(value * another.value, 0);
		}
		public Natural div(Natural another) throws DivisionByZeroException{
			return new Natural(value / another.value) ;
		}
		public boolean equals(Object operand) {
			if (operand != null && operand instanceof Natural) {
				if (value == ((Natural) operand).value) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
		@Deprecated
		public boolean large(Object operand) {
			if (operand != null && operand instanceof Natural) {
				if (value - ((Natural) operand).value > 0){
					return true;
				}
				else {
					return false;
				}
			} else {
				return false;
			}
		}
		
		public Natural nod (Natural d){
			long num = value;
			long den = d.value;
			if (num == 0) {return d;}
			while (den != 0) {
				long t = den;
				den = num % den;
				num = t;
			}
			Natural nod = new Natural(num, 0);
			return nod;
		}
		
		public static RationalValue get(Natural num, Natural denom)
		{
			Natural nod = num.nod(denom);
			return new RationalValue(new Natural(num.value / nod.value, 0), new Natural(denom.value / nod.value, 0));
		}
	}
	
	public static RationalValue get(Natural num, Natural denom) { return Natural.get(num, denom); }
	
	private final Natural numerator, denominator;

	private RationalValue (Natural num, Natural denom){
		numerator = num;
		denominator = denom;
	}

	public String toString() {
		return numerator + "/" + denominator;
	}

	public AbstractValue add(AbstractValue operand) {
		return get(numerator.mul(((RationalValue) operand).denominator).add(((RationalValue) operand).numerator.mul(denominator)),
				denominator.mul(((RationalValue) operand).denominator));
	}

	public AbstractValue sub(AbstractValue operand) throws DivisionByZeroException {
		return get(numerator.mul(((RationalValue) operand).denominator).sub(((RationalValue) operand).numerator.mul(denominator)),
				denominator .mul(((RationalValue) operand).denominator));
	}

	public AbstractValue mul(AbstractValue operand) {
		return get(numerator.mul(((RationalValue) operand).numerator), denominator.mul(((RationalValue) operand).denominator));
	}

	public AbstractValue div(AbstractValue operand){
		return get(numerator.mul(((RationalValue) operand).denominator), denominator.mul(((RationalValue) operand).numerator));
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

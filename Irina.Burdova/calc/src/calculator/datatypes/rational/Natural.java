package calculator.datatypes.rational;


import calculator.DivisionByZeroException;

public class Natural{
	private final long value;
	public Natural(long value) throws DivisionByZeroException
	{
		if(value < 1)
			throw new DivisionByZeroException();
		this.value = value;
	}
	
	public Natural(long value, long unused)
	{
		this.value = value;
	}
	
	public Natural add(Natural another)
	{
		return new Natural(value + another.value, 0);
	}
	public Natural sub(Natural another)
	{
		return new Natural(value - another.value, 0);
	}
	public Natural mul(Natural another)
	{
		return new Natural(value * another.value, 0);
	}
	public Natural div(Natural another){
		return new Natural(value / another.value, 0) ;
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
	public Natural remainder(Natural another)
	{
		return new Natural(value - (value / another.value), 0);
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

}

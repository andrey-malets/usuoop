package calculator.datatypes.rational;

import calculator.DivisionByZeroException;

public class Natural {
	private final long value;
	public Natural(long value) throws DivisionByZeroException
	{
		if(value < 1)
			throw new DivisionByZeroException();
		this.value = value;
	}
	
	private Natural(long value, int unused)
	{
		this.value = value;
	}
	
	public Natural add(Natural another)
	{
		return new Natural(value + another.value, 0);
	}
}

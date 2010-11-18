package Fields;

import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Exceptions.ZeroDiscr;

public abstract class AbstractField {
	public abstract AbstractField add(AbstractField operand)
			throws OperationNotSupportedException, DifferentDimensions, ZeroDiscr;

	public abstract AbstractField sub(AbstractField operand)
			throws OperationNotSupportedException, DifferentDimensions, ZeroDiscr;

	public abstract AbstractField mul(AbstractField operand)
			throws OperationNotSupportedException, ZeroDiscr;

	public abstract AbstractField div(AbstractField operand)
			throws DivisionByZeroException, OperationNotSupportedException, ZeroDiscr;

	public abstract String toString();
	
	public abstract boolean checkZero();
	
}

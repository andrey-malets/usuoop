package Fields;

import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;

public abstract class AbstractField {
	public abstract AbstractField add(AbstractField operand)
			throws OperationNotSupportedException, DifferentDimensions;

	public abstract AbstractField sub(AbstractField operand)
			throws OperationNotSupportedException, DifferentDimensions;

	public abstract AbstractField mul(AbstractField operand)
			throws OperationNotSupportedException;

	public abstract AbstractField div(AbstractField operand)
			throws DivisionByZeroException, OperationNotSupportedException;

	public abstract String toString();
	
	public abstract boolean checkZero();
	
}

package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;

public class VectorValue extends AbstractValue {

	private final double x, y;

	public VectorValue(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "(" + x + "," + y + ")";
	}

	public AbstractValue add(AbstractValue operand) {
		return new VectorValue(x + ((VectorValue) operand).x, y
				+ ((VectorValue) operand).y);
	}

	public AbstractValue sub(AbstractValue operand) {
		return new VectorValue(x - ((VectorValue) operand).x, y
				- ((VectorValue) operand).y);
	}

	public AbstractValue mul(AbstractValue operand) {
		return new VectorValue(x * ((VectorValue) operand).x, y
				* ((VectorValue) operand).y);
	}

	public AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException {
		if (((VectorValue) operand).x == 0.0 && ((VectorValue) operand).y == 0)
			throw new DivisionByZeroException();
		return new VectorValue(x / ((VectorValue) operand).x, y
				/ ((VectorValue) operand).y);
	}
	public boolean equals(Object operand){
		if(operand != null && operand instanceof VectorValue)
		{
			if (( Math.abs(x - ((VectorValue) operand).x) <= 0.1) &&  (Math.abs((y - ((VectorValue) operand).y)) <= 0.1)){
				return true;
			}
			if ((x  == ((VectorValue) operand).x) &&  (y == ((VectorValue) operand).y)){
				return true;
			}
			else{
				return false;
			}
		}
		else
		{
			return false;
		}
	}

}

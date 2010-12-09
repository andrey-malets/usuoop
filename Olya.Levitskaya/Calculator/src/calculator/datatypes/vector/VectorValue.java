package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;

public class VectorValue extends AbstractValue {
	final private double x;
	final private double y;
	final private double z;

	double getX() {
		return x;
	}
	
	double getY() {
		return y;
	}
	
	double getZ() {
		return z;
	}
	
	public VectorValue(double x,double y,double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public AbstractValue add(AbstractValue operand)
			throws OperationNotSupportedException {		
		return new VectorValue(x + ((VectorValue)operand).getX(),y + ((VectorValue)operand).getY(),z + ((VectorValue)operand).getZ());
	}

	public AbstractValue sub(AbstractValue operand)
			throws OperationNotSupportedException {
		return new VectorValue(x - ((VectorValue)operand).getX(),y - ((VectorValue)operand).getY(),z - ((VectorValue)operand).getZ());
	}

	public AbstractValue mul(AbstractValue operand)
			throws OperationNotSupportedException {
		throw new OperationNotSupportedException("mul vector");
		
	}

	public AbstractValue div(AbstractValue operand)
			throws DivisionByZeroException, OperationNotSupportedException {
		throw new OperationNotSupportedException("mul vector");
		
	}

	public String toString() {
		return "("+x+","+y+","+z+")";
	}

}

package Fields;

import java.util.ArrayList;

import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Fields.AbstractField;

public class Vector<T extends AbstractField> extends AbstractField{
	
	private final ArrayList<T> comp;
	private final int dimension;
	
	public Vector(ArrayList<T> a){
		this.dimension = a.size();
		this.comp = new ArrayList<T>(a);
	}
	public int getDimension(){
		return this.dimension;
	}
	public ArrayList<T> getAllComp(){
		return new ArrayList<T>(this.comp);
	}
	public boolean checkZero(){
		int a = 0;
		for (int i=0;i<this.dimension;i++){
			if (!this.comp.get(i).checkZero()){
				a = 1;
				break;
			}
		}
		if (a == 0){
			return true;
		}
		return false;
	}
	@SuppressWarnings("unchecked")
	public AbstractField add(AbstractField operand)
			throws OperationNotSupportedException,DifferentDimensions {
			ArrayList<T> op_list = ((Vector<T>)operand).getAllComp();
			if (this.dimension!=op_list.size()){
				throw new DifferentDimensions();
			}
			ArrayList<T> list = new ArrayList<T>();
			for (int i=0;i<this.dimension;i++){
				list.add(i,(T)this.comp.get(i).add(op_list.get(i)));
			}
		return new Vector<T>(list);
	}

	@SuppressWarnings("unchecked")
	public AbstractField div(AbstractField operand)
			throws DivisionByZeroException, OperationNotSupportedException {
		if (operand.checkZero()){
			throw new DivisionByZeroException();
		}
		ArrayList<T> list = new ArrayList<T>();
		for (int i=0;i<this.dimension;i++){
			list.add(i, (T) this.comp.get(i).div(operand));
		}
		return new Vector<T>(list);
	}

	@SuppressWarnings("unchecked")
	public AbstractField mul(AbstractField operand)
			throws OperationNotSupportedException {
		ArrayList<T> list = new ArrayList<T>();
		for (int i=0;i<this.dimension;i++){
			list.add(i, (T) this.comp.get(i).mul(operand));
		}
		return new Vector<T>(list);
	}

	@SuppressWarnings("unchecked")
	public AbstractField sub(AbstractField operand)
			throws OperationNotSupportedException, DifferentDimensions {
		ArrayList<T> op_list = ((Vector<T>)operand).getAllComp();
		if (this.dimension!=op_list.size()){
			throw new DifferentDimensions();
		}
		ArrayList<T> list = new ArrayList<T>();
		for (int i=0;i<this.dimension;i++){
			list.add(i,(T)this.comp.get(i).sub(op_list.get(i)));
		}
	return new Vector<T>(list);
	}

	@Override
	public String toString() {
		StringBuffer a = new StringBuffer();
		a.append('<');
		for (int i=0;i<this.dimension-1;i++){
			a.append(this.comp.get(i));
			a.append(';');
		}
		a.append(this.comp.get(this.comp.size()-1));
		a.append('>');
		return a.toString();
	}

}

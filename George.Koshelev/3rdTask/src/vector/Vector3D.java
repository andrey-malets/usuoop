package vector;

import java.util.ArrayList;

import exceptions.MyException;
import fieldsInterfaces.MyField;

public class Vector3D<K> implements Vector<K> {
	private final int dimension;
	private ArrayList<MyField<K>> comp;

	public Vector3D(MyField<K>[] it) throws MyException {
		if (it.length == 0) {
			throw new MyException("The dimension should be more than zero");
		}
		this.comp = new ArrayList<MyField<K>>();
		for (MyField<K> j : it) {
			this.comp.add(j);
		}
		this.dimension = this.comp.size();
	}

	public Vector3D(ArrayList<MyField<K>> it) throws MyException {
		if (it.size() == 0) {
			throw new MyException("The dimension should be more than zero");
		}
		this.comp = new ArrayList<MyField<K>>();
		for (MyField<K> j : it) {
			this.comp.add(j);
		}
		this.dimension = this.comp.size();
	}

	/**
	 * Get dimension of space
	 */
	public int dimension() {
		return this.dimension;
	}

	/**
	 * Get component of vector
	 */
	public MyField<K> getComponent(int i) {
		return this.comp.get(i);
	}

	/**
	 * Scalar multiply of vectors
	 */
	public MyField<K> scalar(Vector<K> v) throws MyException {
		MyField<K> dlin = null;
		if (this.dimension != v.dimension()) {
			throw new MyException("Dimensions should be equal");
		}
		dlin = this.comp.get(0).mul(v.getComponent(0));
		for (int i = 1; i < this.dimension; i++) {
			dlin = dlin.add(this.comp.get(i).mul(v.getComponent(i)));
		}
		return dlin;
	}

	/**
	 * Get length of vector
	 */
	public Double len() throws MyException {
		MyField<K> leng = null;
		leng = this.comp.get(0).mul(this.comp.get(0));
		for (int i = 1; i < this.dimension; i++) {
			leng = leng.add(this.comp.get(i).mul(this.getComponent(i)));
		}
		return Math.sqrt(Double.valueOf(leng.toString()));
	}

	/**
	 * Multiply by value
	 */
	public Vector3D<K> multiply(MyField<K> factor) throws MyException {
		ArrayList<MyField<K>> list = new ArrayList<MyField<K>>();
		for (int i = 0; i < this.dimension; i++) {
			list.add(i, this.comp.get(i).mul(factor));
		}
		return new Vector3D<K>(list);
	}

	/**
	 * Sum of vectors
	 */
	public Vector3D<K> add(Vector<K> v) throws MyException {
		if (this.dimension != v.dimension()) {
			throw new MyException("Dimensions should be equal");
		}
		ArrayList<MyField<K>> list = new ArrayList<MyField<K>>();
		for (int i = 0; i < this.dimension; i++) {
			list.add(i, this.comp.get(i).add(v.getComponent(i)));
		}
		return new Vector3D<K>(list);
	}

	/**
	 * Subtraction of vectors
	 */
	public Vector3D<K> sub(Vector<K> v) throws MyException {
		return this.add(v.getNegVec());
	}

	/**
	 * Get vector to string
	 */
	public String getVecToString() {
		StringBuffer a = new StringBuffer();
		a.append('<');
		for (int i = 0; i < this.dimension; i++) {
			a.append(this.comp.get(i));
			if (i != this.dimension - 1) {
				a.append(';');
			}
		}
		a.append('>');
		return a.toString();
	}

	/**
	 * Get vector with negative components
	 */
	public Vector3D<K> getNegVec() throws MyException {
		ArrayList<MyField<K>> list = new ArrayList<MyField<K>>();
		for (int i = 0; i < this.dimension; i++) {
			list.add(this.comp.get(i).negativeNumb());
		}
		return new Vector3D<K>(list);
	}
}

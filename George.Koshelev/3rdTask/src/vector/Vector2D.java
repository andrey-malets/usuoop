package vector;

import java.util.ArrayList;

import exceptions.MyException;
import fieldsInterfaces.MyField;

public class Vector2D<K> implements Vector<K> {
	private final int dimension = 2;
	private ArrayList<MyField<K>> comp;

	public Vector2D(MyField<K>[] it) throws MyException {
		if (it.length == 0||it.length != this.dimension) {
			throw new MyException("Not correct dimension");
		}
		this.comp = new ArrayList<MyField<K>>();
		for (MyField<K> j : it) {
			this.comp.add(j);
		}
	}

	public Vector2D(ArrayList<MyField<K>> it) throws MyException {
		if (it.size() == 0||it.size() != this.dimension) {
			throw new MyException("Not correct dimension");
		}
		this.comp = new ArrayList<MyField<K>>();
		for (MyField<K> j : it) {
			this.comp.add(j);
		}
	}

	/**
	 * Get dimension of space
	 */
	public int dimension() {
		return this.dimension;
	}

	/**
	 * get component of vector
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
	public Vector2D<K> multiply(MyField<K> factor) throws MyException {
		ArrayList<MyField<K>> list = new ArrayList<MyField<K>>();
		for (int i = 0; i < this.dimension; i++) {
			list.add(i, this.comp.get(i).mul(factor));
		}
		return new Vector2D<K>(list);
	}

	/**
	 * Get sum of vectors
	 */
	public Vector2D<K> add(Vector<K> v) throws MyException {
		if (this.dimension != v.dimension()) {
			throw new MyException("Dimensions should be equal");
		}
		ArrayList<MyField<K>> list = new ArrayList<MyField<K>>();
		for (int i = 0; i < this.dimension; i++) {
			list.add(i, this.comp.get(i).add(v.getComponent(i)));
		}
		return new Vector2D<K>(list);
	}

	/**
	 * Get subtraction of values
	 */
	public Vector2D<K> sub(Vector<K> v) throws MyException {
		return this.add(v.getNegVec());
	}

	/**
	 * Get vector parameters to string
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
	public Vector2D<K> getNegVec() throws MyException {
		ArrayList<MyField<K>> list = new ArrayList<MyField<K>>();
		for (int i = 0; i < this.dimension; i++) {
			list.add(this.comp.get(i).negativeNumb());
		}
		return new Vector2D<K>(list);
	}
}

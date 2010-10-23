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

	public int dimension() {
		return this.dimension;
	}

	public MyField<K> getComponent(int i) {
		return this.comp.get(i);
	}

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

	public Double len() throws MyException {
		MyField<K> leng = null;
		leng = this.comp.get(0).mul(this.comp.get(0));
		for (int i = 1; i < this.dimension; i++) {
			leng = leng.add(this.comp.get(i).mul(this.getComponent(i)));
		}
		return Math.sqrt(Double.valueOf(leng.toString()));
	}

	public Vector3D<K> multiply(MyField<K> factor) throws MyException {
		ArrayList<MyField<K>> list = new ArrayList<MyField<K>>();
		for (int i = 0; i < this.dimension; i++) {
			list.add(i, this.comp.get(i).mul(factor));
		}
		return new Vector3D<K>(list);
	}

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

	public Vector3D<K> sub(Vector<K> v) throws MyException {
		if (this.dimension != v.dimension()) {
			throw new MyException("Dimensions should be equal");
		}
		ArrayList<MyField<K>> list = new ArrayList<MyField<K>>();
		for (int i = 0; i < this.dimension; i++) {
			list.add(i, this.comp.get(i).add(v.getComponent(i).negativeNumb()));
		}
		return new Vector3D<K>(list);
	}
}

package vectors;

import java.util.ArrayList;
import java.util.List;

import calc.Calc;

public class Vector3D<K> implements Vector<K> {

	private List<K> param;
	private final int dimension;

	public Vector3D() {
		this.dimension = 0;
		this.param = new ArrayList<K>();
	}

	public Vector3D(K[] a) {
		this.dimension = a.length;
		this.param = new ArrayList<K>();
		for (K x : a) {
			this.param.add(x);
		}
	}

	public double getX() {
		return (Double) this.param.get(0);
	}

	public double getY() {
		return (Double) this.param.get(1);
	}

	public double getZ() {
		return (Double) this.param.get(2);
	}

	public int dimension() {
		return this.dimension;
	}

	public K getComponent(int i) {
		return this.param.get(i);
	}

	public Double[] getComponents() {
		return (Double[]) this.param.toArray();
	}

	public <Integer> double scalar(Vector3D<K> v) throws VectorException {
		if (v.dimension() != this.dimension) {
			throw new VectorException("Mismatch of dimensions");
		}
		double scalar = 0.0;
		for (int i = 0; i < this.dimension; i++) {
			scalar += (Double)this.getComponent(i)*(Double)v.getComponent(i);
		}
		return scalar;
	}
	public double len() {
		double len = 0.0;
		for (int i = 0; i < this.dimension; i++) {
			len += Math.pow((Double) this.param.get(i), 2.0);
		}
		return Math.sqrt(len);
	}

	public Vector3D<K> multiply(K factor) {
		List<Double> newList = new ArrayList<Double>();
		for (int i = 0; i < this.dimension; i++) {
			newList.add((Double) this.param.get(i) * (Double) factor);
		}
		this.param = (List<K>) newList;
		return new Vector3D((K[]) newList.toArray());
	}

	public Vector3D<K> add(Vector3D<K> v) {
		List<Double> newList = new ArrayList<Double>();
		Calc calc = new Calc();
		for (int i = 0; i < this.dimension; i++) {
			newList.add(calc.add(v.getComponent(i),this.param.get(i)));
		}
		this.param = new ArrayList<K>((List<K>) newList);
		return new Vector3D((K[])newList.toArray());
	}

	public Vector3D<K> sub(Vector<K> v) {
		List<Double> newList = new ArrayList<Double>();
		for (int i = 0; i < this.dimension; i++) {
			newList.add((Double) this.param.get(i) - (Double) v.getComponent(i));
		}
		this.param = new ArrayList<K>((List<K>) newList);
		return new Vector3D<K>((K[])newList.toArray());
	}

	public String getVectorToString() {
		StringBuffer a = new StringBuffer();
		a.append('<');
		for (K d : this.param) {
			a.append(d);
		}
		a.append('>');
		return a.toString();
	}
}

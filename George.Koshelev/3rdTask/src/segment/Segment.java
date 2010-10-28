package segment;

import exceptions.MyException;
import vector.Vector;

public class Segment<K> implements iSegment<K> {
	private Vector<K> ivec1;
	private Vector<K> ivec2;

	public Segment(Vector<K> vec1, Vector<K> vec2) throws MyException {
		if (vec1.dimension()!=vec2.dimension()){
			throw new MyException("The dimensions must be equal");
		}
		this.ivec1 = vec1;
		this.ivec2 = vec2;
	}

	/**
	 * Get start point
	 */
	public Vector<K> getStart() {
		return this.ivec1;
	}

	/**
	 * Get end point
	 */
	public Vector<K> getEnd() {
		return this.ivec2;
	}

	/**
	 * Get length of segment
	 */
	public double len() throws MyException {
		Vector<K> vec3 = ivec1.sub(ivec2);
		return vec3.len();
	}

	/**
	 * Get Distance to point
	 */
	public double distanceTo(Vector<K> point) throws MyException {
		Vector<K> vec3 = ivec2.sub(ivec1);
		Vector<K> a = this.ivec1.sub(point);
		Vector<K> b = this.ivec2.sub(point);
		if (vec3.len() == 0.) {
			return point.sub(this.ivec1).len();
		}
		return Math.sin(Math.acos(a.scalar(b).divide(a.len() * b.len())))
				* a.len() * b.len() / vec3.len();
	}

}

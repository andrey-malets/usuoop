package vectors;

public class Vector3D implements Vector {
	private double[] param;
	private final int dimension;

	public Vector3D() {
		this.dimension = 0;
	}

	public Vector3D(int[] a) {
		this.dimension = a.length;
		this.param = new double[a.length];
		int i = 0;
		for (int x : a) {
			this.param[i++] = (double) x;
		}
	}

	public Vector3D(double[] a) {
		this.dimension = a.length;
		this.param = a.clone();
	}

	public double getX() {
		return this.param[0];
	}

	public double getY() {
		return this.param[1];
	}

	public double getZ() {
		return this.param[2];
	}

	public int dimension() {
		return this.dimension;
	}

	public double getComponent(int i) {
		return this.param[i];
	}
	public double[] getComponents(){
		return this.param;
	}

	public double scalar(Vector v) throws VectorException {
		if (v.dimension() != this.dimension) {
			throw new VectorException("Mismatch of dimensions");
		}
		double scalar = 0.0;
		for (int i = 0; i < this.dimension; i++) {
			scalar += this.param[i] * v.getComponent(i);
		}
		return scalar;
	}

	public double len() {
		double len = 0.0;
		for (int i = 0; i < this.dimension; i++) {
			len += Math.pow(this.param[i], 2.0);
		}
		return Math.sqrt(len);
	}

	public Vector3D multiply(double factor) {
		for (int i = 0; i < this.dimension; i++) {
			this.param[i] *= factor;
		}
		return new Vector3D(this.param);
	}

	public Vector3D add(Vector v) {
		for (int i = 0; i < this.dimension; i++) {
			this.param[i] += v.getComponent(i);
		}
		return new Vector3D(this.param);
	}

	public Vector3D sub(Vector v) {
		for (int i = 0; i < this.dimension; i++) {
			this.param[i] -= v.getComponent(i);
		}
		return new Vector3D(this.param);
	}
	public String getVectorToString(){
		StringBuffer a = new StringBuffer();
		for(double d:this.param){
				a.append(d);
		}
	return a.toString();
	}
}

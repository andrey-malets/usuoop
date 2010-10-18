package main;

interface Vector {
	public int dimension();
	public double getComponent(int i);
	public double scalar (Vector v);
	public double len();
	public Vector multiply(double factor);
	public Vector add(Vector v);
	public Vector sub(Vector v);
}

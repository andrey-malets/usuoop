package vectors;


public interface Vector<K> {
	public int dimension();
	public K getComponent(int i);
	public double scalar (Vector<K> v) throws VectorException;
	public double len();
	public Vector<K> multiply(K factor);
	public Vector<K> add(Vector<K> v);
	public Vector<K> sub(Vector<K> v);
	public Double[] getComponents();
}

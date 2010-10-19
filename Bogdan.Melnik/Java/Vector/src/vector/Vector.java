package vector;

import java.util.ArrayList;

import field.IField;

public class Vector<K extends IField<V>, V> implements IVector<K,V> {
  private final ArrayList<K> _components;
  private final int _dimension;
  public Vector(int dimension,Iterable<K> init) {
    _components = new ArrayList<K>();
    _dimension = dimension;
    for (K k : init) {
      _components.add(k);
    }
  }
  
  public K getComponent(int i) {   
    return _components.get(i);
  }

  public int getDimension() {
    return _dimension;
  }

  public IVector<K,V> add(IVector<K,V> rhs) throws MissmatchDimensionException, OutOfComponentIndexException {
    ArrayList<K> arrayList = null;
    if (this.getDimension() != rhs.getDimension())
      throw new MissmatchDimensionException("Dimension must be equals");
    arrayList = new ArrayList<K>();
    for (int i = 0;i < this.getDimension(); ++i) {
      rhs.getComponent(0).add(this.getComponent(0));
    }
    return new Vector<K,V>(_dimension,arrayList);
  }

  public double scalar(IVector<K,V> rhs) {
    // TODO Auto-generated method stub
    return 0;
  }
}

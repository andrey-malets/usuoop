package vector;

import java.util.ArrayList;

import field.IField;


public class Vector<V> implements IVector<V> {
  private final ArrayList< IField<V> > _components;
  private final int _dimension;

  public Vector(int dimension, Iterable< IField<V> > init) {
    _components = new ArrayList< IField<V> >();
    _dimension = dimension;
    for (IField<V> k : init) {
      _components.add(k);
    }
  }

  public Vector(int dimension, IField<V>[] init) {
    _components = new ArrayList< IField<V> >();
    _dimension = dimension;
    for (IField<V> k : init) {
      _components.add(k);
    }
  }

  public IField<V> getComponent(int i) {
    return _components.get(i);
  }

  public int getDimension() {
    return _dimension;
  }

  public Vector<V> add(IVector<V> rhs)
      throws MissmatchDimensionException, OutOfComponentIndexException {
    ArrayList< IField<V> > arrayList = null;
    if (this.getDimension() != rhs.getDimension())
      throw new MissmatchDimensionException("Dimension must be equals");
    arrayList = new ArrayList< IField<V> >();
    for (int i = 0; i < this.getDimension(); ++i) {
      arrayList.add(this.getComponent(i).add(rhs.getComponent(i)));
    }
    return new Vector<V>(_dimension, arrayList);
  }

  public double scalar(IVector<V> rhs) {
    // TODO Auto-generated method stub
    return 0;
  }
  public String toString() {
    StringBuffer buffer = new StringBuffer("<");
    for (IField<V> k : _components) {
      buffer.append(" " + k.toString() + " ");
    }
    buffer.append(">");
    return buffer.toString();
  }
}


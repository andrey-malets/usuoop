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

  public IField<V> scalar(IVector<V> rhs) throws MissmatchDimensionException, OutOfComponentIndexException {
        if (this.getDimension() != rhs.getDimension())
      throw new MissmatchDimensionException("Dimension must be equals");
    IField<V> sum = this.getComponent(0).mul(rhs.getComponent(0));    
    for (int i = 1; i < this.getDimension(); ++i) {
      sum = sum.add(this.getComponent(i).mul(rhs.getComponent(i)));      
    }
    return sum;
  }

  public IVector<V> mul(IField<V> factor) throws OutOfComponentIndexException {
    ArrayList< IField<V> > arrayList = null;    
    arrayList = new ArrayList< IField<V> >();
    for (int i = 0; i < this.getDimension(); ++i) {
      arrayList.add(this.getComponent(i).mul(factor));
    }
    return new Vector<V>(_dimension, arrayList);
  }

  public IVector<V> sub(IVector<V> rhs) {
    
    return null;
  }
  
  public String toString() {
    StringBuffer buffer = new StringBuffer("<");
    for (IField<V> k : _components) {
      buffer.append(" " + k.toString() + " ");
    }
    buffer.append(">");
    return buffer.toString();
  }
  
  public IField<V> getLength() {   
    return null;
  } 
  
  public boolean equals(Object rhs) {
    if (rhs instanceof Vector<?>) {
      Vector<V> vector = (Vector<V>) rhs;
      if (vector.getDimension() != this.getDimension())
        return false;
      for (int i = 0; i < this.getDimension(); ++i)
        if (! (this.getComponent(i).equals(vector.getComponent(i))) )
          return false;
    }
    return true;
  }
}


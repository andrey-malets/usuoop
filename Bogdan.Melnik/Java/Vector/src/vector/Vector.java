package vector;

import java.util.ArrayList;

import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import exceptions.OutOfComponentIndexException;
import field.IField;


public class Vector implements IVector<IField> {
  private final ArrayList< IField > _components;
  private final int _dimension;

  public Vector(int dimension, Iterable< IField > init) {
    _components = new ArrayList< IField >();
    _dimension = dimension;
    for (IField k : init) {
      _components.add(k);
    }
  }

  public Vector(int dimension, IField[] init) {
    _components = new ArrayList< IField >();
    _dimension = dimension;
    for (IField k : init) {
      _components.add(k);
    }
  }

  public IField getComponent(int i) {
    return _components.get(i);
  }

  public int getDimension() {
    return _dimension;
  }

  public Vector add(IVector<IField> rhs)
      throws MissmatchDimensionException, OutOfComponentIndexException, InvalidValueException {
    ArrayList< IField > arrayList = null;
    if (this.getDimension() != rhs.getDimension())
      throw new MissmatchDimensionException("Dimension must be equals");
    arrayList = new ArrayList< IField >();
    for (int i = 0; i < this.getDimension(); ++i) {
      arrayList.add(this.getComponent(i).add(rhs.getComponent(i)));
    }
    return new Vector(_dimension, arrayList);
  }

  public IField scalar(IVector<IField> rhs) throws MissmatchDimensionException, OutOfComponentIndexException, InvalidValueException {
        if (this.getDimension() != rhs.getDimension())
      throw new MissmatchDimensionException("Dimension must be equals");
    IField sum = this.getComponent(0).mul(rhs.getComponent(0));    
    for (int i = 1; i < this.getDimension(); ++i) {
      sum = sum.add(this.getComponent(i).mul(rhs.getComponent(i)));      
    }
    return sum;
  }

  public Vector mul(IField factor) throws OutOfComponentIndexException, InvalidValueException {
    ArrayList< IField > arrayList = null;    
    arrayList = new ArrayList< IField >();
    for (int i = 0; i < this.getDimension(); ++i) {
      arrayList.add(this.getComponent(i).mul(factor));
    }
    return new Vector(_dimension, arrayList);
  }

  public Vector sub(IVector<IField> rhs) {
    
    return null;
  }
  
  public String toString() {
    StringBuffer buffer = new StringBuffer("<");
    for (IField k : _components) {
      buffer.append(" " + k.toString() + " ");
    }
    buffer.append(">");
    return buffer.toString();
  }
  
  public IField getLength() {   
    return null;
  } 
  
  public boolean equals(Object rhs) {
    if (rhs instanceof Vector) {
      Vector vector = (Vector) rhs;
      if (vector.getDimension() != this.getDimension())
        return false;
      for (int i = 0; i < this.getDimension(); ++i)
        if (! (this.getComponent(i).equals(vector.getComponent(i))) )
          return false;
    }
    return true;
  }
  
}


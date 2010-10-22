package vector;

import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import exceptions.OutOfComponentIndexException;
import field.IField;

public interface IVector<V extends IField> {
  public V getComponent(int i);

  public int getDimension();

  public IVector<V> add(IVector<V> rhs)
      throws MissmatchDimensionException, OutOfComponentIndexException, InvalidValueException;

  public V scalar(IVector<V> rhs) throws MissmatchDimensionException,
      OutOfComponentIndexException, InvalidValueException;
  
  public V getLength();
  public IVector<V> mul(V factor) throws OutOfComponentIndexException, InvalidValueException;  
  public IVector<V> sub(IVector<V> rhs) throws InvalidValueException; 
}

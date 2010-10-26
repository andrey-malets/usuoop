package vector;

import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import field.IField;

public interface IVector<V extends IField> {
  public V getComponent(int i);

  public int getDimension();

  public IVector<V> add(IVector<V> rhs)
      throws MissmatchDimensionException, InvalidValueException;

  public V scalar(IVector<V> rhs) throws MissmatchDimensionException, InvalidValueException;
  
  public double getLength() throws InvalidValueException;
  public IVector<V> mul(V factor) throws InvalidValueException;  
  public IVector<V> sub(IVector<V> rhs) throws InvalidValueException, MissmatchDimensionException; 
}

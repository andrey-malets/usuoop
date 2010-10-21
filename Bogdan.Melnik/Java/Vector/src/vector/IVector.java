package vector;

import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import exceptions.OutOfComponentIndexException;
import field.IField;

public interface IVector<V> {
  public IField<V> getComponent(int i);

  public int getDimension();

  public IVector<V> add(IVector<V> rhs)
      throws MissmatchDimensionException, OutOfComponentIndexException, InvalidValueException;

  public IField<V> scalar(IVector<V> rhs) throws MissmatchDimensionException,
      OutOfComponentIndexException, InvalidValueException;
  
  public IField<V> getLength();
  public IVector<V> mul(IField<V> factor) throws OutOfComponentIndexException, InvalidValueException;  
  public IVector<V> sub(IVector<V> rhs) throws InvalidValueException; 
}

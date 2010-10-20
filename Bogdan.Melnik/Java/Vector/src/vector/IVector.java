package vector;

import field.IField;

public interface IVector<V> {
  public IField<V> getComponent(int i);

  public int getDimension();

  public IVector<V> add(IVector<V> rhs)
      throws MissmatchDimensionException, OutOfComponentIndexException;

  public IField<V> scalar(IVector<V> rhs) throws MissmatchDimensionException,
      OutOfComponentIndexException;
  
  public IField<V> getLength();
  public IVector<V> mul(IField<V> factor) throws OutOfComponentIndexException;  
  public IVector<V> sub(IVector<V> rhs); 
}

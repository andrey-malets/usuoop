package vector;

import field.IField;

public interface IVector<V> {
  public IField<V> getComponent(int i);

  public int getDimension();

  public IVector<V> add(IVector<V> rhs)
      throws MissmatchDimensionException, OutOfComponentIndexException;

  double scalar(IVector<V> rhs) throws MissmatchDimensionException,
      OutOfComponentIndexException;
}

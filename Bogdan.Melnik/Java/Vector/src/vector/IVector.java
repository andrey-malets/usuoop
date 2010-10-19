package vector;

import field.IField;

public interface IVector<K extends IField<V>, V> {
  public K getComponent(int i);
  public int getDimension();
  public IVector<K,V> add(IVector<K,V> rhs) throws MissmatchDimensionException,OutOfComponentIndexException;
  double scalar(IVector<K,V> rhs) throws MissmatchDimensionException,OutOfComponentIndexException;
}

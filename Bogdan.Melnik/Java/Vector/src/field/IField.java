package field;

import vector.OutOfComponentIndexException;

public interface IField<K> {
  public K getComponent(int i) throws OutOfComponentIndexException;
  public IField<K> reverseForAdd();
  public IField<K> reverseForMul() throws ArithmeticException;
  public IField<K> add(IField<K> rhs) throws OutOfComponentIndexException;   
  public IField<K> mul(IField<K> rhs) throws OutOfComponentIndexException;      
}

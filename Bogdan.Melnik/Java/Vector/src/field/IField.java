package field;

import exceptions.InvalidValueException;
import exceptions.OutOfComponentIndexException;

public interface IField<K> {
  public K getComponent(int i) throws OutOfComponentIndexException, InvalidValueException;

  public IField<K> reverseForAdd() throws InvalidValueException;

  public IField<K> reverseForMul() throws ArithmeticException, InvalidValueException;

  public IField<K> add(IField<K> rhs) throws OutOfComponentIndexException, InvalidValueException;

  public IField<K> mul(IField<K> rhs) throws OutOfComponentIndexException, InvalidValueException;
}

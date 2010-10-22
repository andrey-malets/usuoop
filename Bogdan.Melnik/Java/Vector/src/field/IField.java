package field;

import exceptions.InvalidValueException;
import exceptions.OutOfComponentIndexException;

public interface IField {
  public IField reverseForAdd() throws InvalidValueException;

  public IField reverseForMul() throws ArithmeticException, InvalidValueException;

  public IField add(IField rhs) throws OutOfComponentIndexException, InvalidValueException;

  public IField mul(IField rhs) throws OutOfComponentIndexException, InvalidValueException;
}

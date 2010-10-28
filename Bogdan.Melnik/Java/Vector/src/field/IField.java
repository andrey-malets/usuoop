package field;

import exceptions.InvalidValueException;

public interface IField {
  
  public double getValue();
  public IField getZero();
  public IField getUnit();
  public IField reverseForAdd() throws InvalidValueException;

  public IField reverseForMul() throws ArithmeticException, InvalidValueException;

  public IField add(IField rhs) throws InvalidValueException;

  public IField mul(IField rhs) throws InvalidValueException;
}

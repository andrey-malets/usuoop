package field;

import exceptions.InvalidValueException;

public class ComplexField implements IField {

  private double _re;
  private double _im;

  public ComplexField(double re,double im) {
    _re = re;
    _im = im;
  }
  
  private double getRe() {
    return _re;
  }
  
  private double getIm() {
    return _im;
  }
  
  public IField getZero() {
    return new ComplexField(0., 0.);
  }

  public IField getUnit() {
    return new ComplexField(1.,1.);
  }

  public IField reverseForAdd() throws InvalidValueException {
    return new ComplexField( -getRe(), -getIm());
  }

  public IField reverseForMul() throws ArithmeticException,
      InvalidValueException {    
    return new ComplexField(getRe() / ( getRe()*getRe() + getIm()*getIm() ) , -getIm() / ( getRe()*getRe() + getIm()*getIm()  ));
  }

  public IField add(IField rhs) throws InvalidValueException {   
    if (! (rhs instanceof ComplexField) ) {
      throw new InvalidValueException("Argument must be ComplexField type.");      
    }
    ComplexField valid = (ComplexField) rhs;
    return new ComplexField( getRe() + valid.getRe(), getIm() + valid.getIm());
  }

  public IField mul(IField rhs) throws InvalidValueException {
    if (! (rhs instanceof ComplexField) ) {
      throw new InvalidValueException("Argument must be ComplexField type.");      
    }
    ComplexField valid = (ComplexField) rhs;
    return new ComplexField( getRe()*valid.getRe() - getIm()*valid.getIm(), getRe()*valid.getIm() + getIm()*valid.getRe());   
    
  }
  
  public String toString() {
    return "( " + getRe() +" , " + getIm() + " )";
  }
  
  public boolean equals(Object rhs) {
    if (this == rhs)
      return true;
    if (rhs instanceof ComplexField) {
      ComplexField realRhs = (ComplexField) rhs;
      return ( ((realRhs.getRe() - this.getRe()) < 0.1) && ( (realRhs.getIm() - this.getIm()) < 0.1 ) );    
    }  
    return false;
  }

  public double getValue() {
    return _re;
  }
}

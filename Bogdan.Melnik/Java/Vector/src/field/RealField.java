package field;

import vector.OutOfComponentIndexException;

public class RealField implements IField<Double> {
  Double _elem;
  
  public RealField(Double i) {
    _elem = i;
  }
  
  public Double getComponent(int i) throws OutOfComponentIndexException {
    if (i != 0) {
      throw new OutOfComponentIndexException("Index must be zero");
    }   
    return _elem;
  }
  
  public IField<Double> reverseForAdd() { 
    return new RealField(-_elem.doubleValue());
  }

  public IField<Double> reverseForMul() {
    return new RealField(1/_elem.doubleValue());
  }

  public IField<Double> add(IField<Double> rhs) throws OutOfComponentIndexException {
    return new RealField(_elem.doubleValue() + rhs.getComponent(0).doubleValue());
  }

  public IField<Double> mul(IField<Double> rhs) throws OutOfComponentIndexException {
    return new RealField(_elem.doubleValue() + rhs.getComponent(0).doubleValue());    
  }  
}

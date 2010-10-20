package general;

import vector.MissmatchDimensionException;
import vector.OutOfComponentIndexException;
import vector.Vector;
import field.RealField;

public class Main {

  public static void main(String[] args) throws OutOfComponentIndexException,
      MissmatchDimensionException {
    RealField one[] = new RealField[] { new RealField(5.), new RealField(1.) };
    RealField two[] = new RealField[] { new RealField(2.), new RealField(7.) };
    Vector<Double> firstVector = new Vector<Double>(
        2, one);
    Vector<Double> secondVector = new Vector<Double>(
        2, two);
    Vector<Double> add = firstVector.add(secondVector);
    System.out.println(add);
  }
}

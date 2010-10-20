package general;

import vector.MissmatchDimensionException;
import vector.OutOfComponentIndexException;
import vector.Vector;
import field.RealField;

public class Main {

  public static void main(String[] args) throws OutOfComponentIndexException,
      MissmatchDimensionException {
    RealField one[] = new RealField[] { new RealField(3.), new RealField(2.) };
    RealField two[] = new RealField[] { new RealField(1.), new RealField(2.) };
    Vector<Double> firstVector = new Vector<Double>(
        2, one);
    Vector<Double> secondVector = new Vector<Double>(
        2, two);
    RealField realField = new RealField(2.);
    System.out.println(firstVector.mul(realField));
    System.out.println(secondVector.mul(realField));
  }
}

package general;

import vector.Vector;
import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import exceptions.OutOfComponentIndexException;
import field.BinaryField;

public class Main {

  public static void main(String[] args) throws OutOfComponentIndexException,
      MissmatchDimensionException, InvalidValueException {
    BinaryField one[] = new BinaryField[] { new BinaryField(1), new BinaryField(0) };
    BinaryField two[] = new BinaryField[] { new BinaryField(1), new BinaryField(1) };
    Vector<Integer> firstVector = new Vector<Integer>(
        2, one);
    Vector<Integer> secondVector = new Vector<Integer>(
        2, two);
    BinaryField realField = new BinaryField(1);
    System.out.println(firstVector.mul(realField));
    System.out.println(secondVector.mul(realField));
    System.out.println(firstVector.add(secondVector));
    /*
    RealField one[] = new RealField[] { new RealField(3.), new RealField(2.) };
    RealField two[] = new RealField[] { new RealField(1.), new RealField(2.) };
    Vector<Double> firstVector = new Vector<Double>(
        2, one);
    Vector<Double> secondVector = new Vector<Double>(
        2, two);
    RealField realField = new RealField(2.);
    System.out.println(firstVector.mul(realField));
    System.out.println(secondVector.mul(realField));
    */
  }
}

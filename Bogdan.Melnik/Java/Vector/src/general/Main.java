package general;

import vector.MissmatchDimensionException;
import vector.OutOfComponentIndexException;
import vector.Vector;
import field.IField;
import field.RealField;

public class Main {

  public static void main(String[] args) throws OutOfComponentIndexException,
      MissmatchDimensionException {
    RealField one[] = new RealField[] { new RealField(5.), new RealField(1.) };
    RealField two[] = new RealField[] { new RealField(2.), new RealField(7.) };
    Vector<IField<Double>, Double> firstVector = new Vector<IField<Double>, Double>(
        2, one);
    Vector<IField<Double>, Double> secondVector = new Vector<IField<Double>, Double>(
        2, two);
    Vector<IField<Double>, Double> add = firstVector.add(secondVector);
    System.out.println(add.getComponent(0).getComponent(0).doubleValue());
  }
}

package general;

import segment.Segment;
import vector.Vector;
import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import field.RealField;

public class Main {

  public static void main(String[] args) throws MissmatchDimensionException, InvalidValueException {
    /*
    BinaryField one[] = new BinaryField[] { new BinaryField(1), new BinaryField(0) };
    BinaryField two[] = new BinaryField[] { new BinaryField(1), new BinaryField(1) };
    Vector firstVector = new Vector(
        2, one);
    Vector secondVector = new Vector(
        2, two);
    BinaryField realField = new BinaryField(1);
    System.out.println(firstVector.mul(realField));
    System.out.println(secondVector.mul(realField));
    System.out.println(firstVector.add(secondVector));
    */   
    RealField one[] = new RealField[] { new RealField(-1.), new RealField(0.) };
    RealField two[] = new RealField[] { new RealField(1.), new RealField(0.) };
    RealField three[] = new RealField[] { new RealField(0.), new RealField(0.00001) };
    Vector firstVector = new Vector(
        2, one);
    Vector secondVector = new Vector(
        2, two);    
    Vector thirdVector = new Vector(
        2, three);
    Segment segment = new Segment(firstVector,secondVector);
    System.out.println(segment.distanceTo(thirdVector));
    /*
    System.out.println(firstVector.mul(realField));
    System.out.println(secondVector.mul(realField));    
    System.out.println(firstVector.mul(realField).add(secondVector.mul(realField)));
    System.out.println(firstVector.getLength());
    */
    /*
    ComplexField one = new ComplexField(5.,1.);
    IField two = one.reverseForMul();
    System.out.println(two);
    System.out.println(one.mul(two));
    */
    /*
    IField one = new RealField(4.);
    IField two = one.reverseForAdd();
    System.out.println(one.add(two));
    */
  }
}

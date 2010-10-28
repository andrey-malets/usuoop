package test;

import java.util.ArrayList;
import java.util.Random;

import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import field.BinaryField;
import field.IField;
import vector.Vector;
import junit.framework.TestCase;

public class TestForVectorOnBinaryField extends TestCase {
  public static int _defaultDimension = 50;
  
  public static BinaryField getRandomBinaryField() throws InvalidValueException {
    Random random = new Random();    
    return new BinaryField( random.nextInt(2) );   
  }
  
  public static Vector getRandomVector(int dimension) throws InvalidValueException {
    ArrayList<IField> arrayList = new ArrayList<IField>();    
    for (int i = 0;i < dimension; ++i)
      arrayList.add( getRandomBinaryField() );
    return new Vector(dimension,arrayList);    
  }
  
  public void testSelfEquals() throws InvalidValueException {
    Vector randomVector = getRandomVector(_defaultDimension);
    assertEquals(randomVector, randomVector);
  }
  
  public void testCommutativity() throws MissmatchDimensionException, InvalidValueException {
    Vector one = getRandomVector(_defaultDimension);
    Vector two = getRandomVector(_defaultDimension);
    assertEquals(one.add(two), two.add(one));
  }
  
  public void testDistributivity() throws MissmatchDimensionException, InvalidValueException {
    Vector one = getRandomVector(_defaultDimension);
    Vector two = getRandomVector(_defaultDimension);
    BinaryField randomRealField = getRandomBinaryField();
    Vector x = one.mul(randomRealField);
    Vector y = two.mul(randomRealField);
    for (int i = 0; i < _defaultDimension; ++i) {      
      assertEquals(one.add(two).mul(randomRealField),x.add(y));
    }    
  }
}

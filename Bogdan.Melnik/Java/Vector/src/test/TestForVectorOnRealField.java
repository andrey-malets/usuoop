package test;

import java.util.ArrayList;
import java.util.Random;

import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import field.IField;
import field.RealField;
import vector.Vector;
import junit.framework.TestCase;

public class TestForVectorOnRealField extends TestCase {
  public static int _defaultDimension = 50;
  
  public static RealField getRandomRealField() {
    Random random = new Random();    
    return new RealField(random.nextDouble() * 0xFFFFFF);   
  }
  
  public static Vector getRandomVector(int dimension) {
    ArrayList<IField> arrayList = new ArrayList<IField>();    
    for (int i = 0;i < dimension; ++i)
      arrayList.add( getRandomRealField() );
    return new Vector(dimension,arrayList);    
  }
  
  public void testSelfEquals() {
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
    RealField randomRealField = getRandomRealField();
    Vector x = one.mul(randomRealField);
    Vector y = two.mul(randomRealField);
    for (int i = 0; i < _defaultDimension; ++i) {      
      assertEquals(one.add(two).mul(randomRealField),x.add(y));
    }    
  }
}

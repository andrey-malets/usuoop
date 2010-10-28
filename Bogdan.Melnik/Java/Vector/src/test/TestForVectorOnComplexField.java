package test;

import java.util.ArrayList;
import java.util.Random;

import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import field.ComplexField;
import field.IField;
import vector.Vector;
import junit.framework.TestCase;

public class TestForVectorOnComplexField extends TestCase {
  public static int _defaultDimension = 50;
  
  public static ComplexField getRandomComplexField() {
    Random random = new Random();    
    return new ComplexField(random.nextDouble() * 0xFFFFFF,random.nextDouble() * 0xFFFFFF);   
  }
  
  public static Vector getRandomVector(int dimension) {
    ArrayList<IField> arrayList = new ArrayList<IField>();    
    for (int i = 0;i < dimension; ++i)
      arrayList.add( getRandomComplexField() );
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
    ComplexField randomComplexField = getRandomComplexField();
    Vector x = one.mul(randomComplexField);
    Vector y = two.mul(randomComplexField);
    for (int i = 0; i < _defaultDimension; ++i) {      
      assertEquals(one.add(two).mul(randomComplexField),x.add(y));
    }    
  }
}

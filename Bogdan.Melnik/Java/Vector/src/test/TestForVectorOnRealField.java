package test;

import java.util.ArrayList;
import java.util.Random;

import field.IField;
import field.RealField;
import vector.IVector;
import vector.MissmatchDimensionException;
import vector.OutOfComponentIndexException;
import vector.Vector;
import junit.framework.TestCase;

public class TestForVectorOnRealField extends TestCase {
  public static int _defaultDimension = 50;
  
  public static RealField getRandomRealField() {
    Random random = new Random();    
    return new RealField((double)random.nextInt(10000));   
  }
  
  public static Vector<Double> getRandomVector(int dimension) {
    ArrayList<IField<Double>> arrayList = new ArrayList<IField<Double>>();    
    for (int i = 0;i < dimension; ++i)
      arrayList.add( getRandomRealField() );
    return new Vector<Double>(dimension,arrayList);    
  }
  
  public void testSelfEquals() {
    Vector<Double> randomVector = getRandomVector(_defaultDimension);
    assertEquals(randomVector, randomVector);
  }
  
  public void testCommutativity() throws MissmatchDimensionException, OutOfComponentIndexException {
    Vector<Double> one = getRandomVector(_defaultDimension);
    Vector<Double> two = getRandomVector(_defaultDimension);
    assertEquals(one.add(two), two.add(one));
  }
  
  public void testDistributivity() throws OutOfComponentIndexException, MissmatchDimensionException {
    Vector<Double> one = getRandomVector(_defaultDimension);
    Vector<Double> two = getRandomVector(_defaultDimension);
    RealField randomRealField = getRandomRealField();
    IVector<Double> x = one.mul(randomRealField);
    IVector<Double> y = two.mul(randomRealField);
    assertEquals(one.add(two).mul(randomRealField),x.add(y));        
    
  }
}

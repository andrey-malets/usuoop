package test;

import java.util.ArrayList;
import java.util.Random;

import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import exceptions.OutOfComponentIndexException;
import field.IField;
import field.RealField;
import vector.IVector;
import vector.Vector;
import junit.framework.TestCase;

public class TestForVectorOnRealField extends TestCase {
  public static int _defaultDimension = 50;
  
  public static RealField getRandomRealField() {
    Random random = new Random();    
    return new RealField(random.nextDouble() * 0xFFFFFF);   
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
  
  public void testCommutativity() throws MissmatchDimensionException, OutOfComponentIndexException, InvalidValueException {
    Vector<Double> one = getRandomVector(_defaultDimension);
    Vector<Double> two = getRandomVector(_defaultDimension);
    assertEquals(one.add(two), two.add(one));
  }
  
  public void testDistributivity() throws OutOfComponentIndexException, MissmatchDimensionException, InvalidValueException {
    Vector<Double> one = getRandomVector(_defaultDimension);
    Vector<Double> two = getRandomVector(_defaultDimension);
    RealField randomRealField = getRandomRealField();
    IVector<Double> x = one.mul(randomRealField);
    IVector<Double> y = two.mul(randomRealField);
    for (int i = 0; i < _defaultDimension; ++i) {      
      assertEquals(one.add(two).mul(randomRealField).getComponent(i).getComponent(0).doubleValue(),x.add(y).getComponent(i).getComponent(0).doubleValue(),(double)0.1);
    }    
  }
}

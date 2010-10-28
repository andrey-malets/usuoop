package test;

import java.util.ArrayList;
import java.util.Random;

import vector.Vector;
import exceptions.InvalidValueException;
import field.IField;
import field.RealField;
import junit.framework.TestCase;

public class TestForSegment extends TestCase {
  private static final int _defaultDimension = 50;
  public static RealField getRandomRealField() {
    Random random = new Random();    
    return new RealField(random.nextDouble() * 0xFFFF);   
  }
  
  public static Vector getRandomVector(int dimension) {
    ArrayList<IField> arrayList = new ArrayList<IField>();    
    for (int i = 0;i < dimension; ++i)
      arrayList.add( getRandomRealField() );
    return new Vector(dimension,arrayList);    
  }
  
  public void testTriangleRule() throws InvalidValueException {    
    double a = getRandomVector(_defaultDimension).getLength();
    double b = getRandomVector(_defaultDimension).getLength();
    double c = getRandomVector(_defaultDimension).getLength();
    
    assertTrue( a + b > c);
    assertTrue( b + c > a);
    assertTrue( c + a > b);
  } 
}

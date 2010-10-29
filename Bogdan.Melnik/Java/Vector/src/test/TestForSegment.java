package test;

import java.util.ArrayList;
import java.util.Random;

import segment.Segment;
import vector.Vector;
import exceptions.InvalidValueException;
import exceptions.MissmatchDimensionException;
import field.IField;
import field.RealField;
import junit.framework.TestCase;

public class TestForSegment extends TestCase {
  private static final int _defaultDimension = 50;
  public static RealField getRandomRealField() {
    Random random = new Random();    
    return new RealField(random.nextDouble() * 0xFF);   
  }
  
  public static Vector getRandomVector(int dimension) {
    ArrayList<IField> arrayList = new ArrayList<IField>();    
    for (int i = 0;i < dimension; ++i)
      arrayList.add( getRandomRealField() );
    return new Vector(dimension,arrayList);    
  }
  
  public static Segment getRandomSegment(int dimension) {
    Vector one = getRandomVector(dimension);
    Vector two = getRandomVector(dimension);
    return new Segment(one,two);
  }
  
  public void testTriangleRule() throws InvalidValueException {    
    double a = getRandomVector(_defaultDimension).getLength();
    double b = getRandomVector(_defaultDimension).getLength();
    double c = getRandomVector(_defaultDimension).getLength();
    
    assertTrue( a + b > c);
    assertTrue( b + c > a);
    assertTrue( c + a > b);
  } 
  
  public void testSegment2D() throws MissmatchDimensionException, InvalidValueException {
    RealField a = getRandomRealField();
    RealField b = getRandomRealField();
    Vector begin = new Vector(2, new RealField[] { a, b  });
    Vector end = new Vector(2, new RealField[] { a.reverseForAdd() , b.reverseForAdd()  });
    
    Segment randomSegment = new Segment(begin,end);
    
    Vector one = getRandomVector(2);    
    Vector two = new Vector(2, new RealField[] { (RealField) one.getComponent(0).reverseForAdd(), (RealField) one.getComponent(1).reverseForAdd() });        
    assertEquals(randomSegment.distanceTo(one),randomSegment.distanceTo(two));
  }
  
}

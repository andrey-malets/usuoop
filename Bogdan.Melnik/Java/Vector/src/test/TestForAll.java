package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class TestForAll extends TestSuite {
  
  public static Test suite() {
    TestSuite suite = new TestSuite();
    suite.addTestSuite(TestForSegment.class);
    suite.addTestSuite(TestForVectorOnRealField.class);
    suite.addTestSuite(TestForVectorOnBinaryField.class);
    suite.addTestSuite(TestForVectorOnComplexField.class);
    return suite;    
  }
  
}

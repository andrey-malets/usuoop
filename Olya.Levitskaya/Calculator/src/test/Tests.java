package test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class Tests extends TestSuite {
	public static Test suite()
	{
		TestSuite result = new TestSuite();
		result.addTestSuite(ComplexTest.class);
		result.addTestSuite(FractionTest.class);
		result.addTestSuite(IntegerValueTest.class);
		result.addTestSuite(VectorTest.class);
		return result;
	}
}

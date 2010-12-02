package calculator.datatypes.complex;

import junit.framework.TestCase;
import java.util.Random;


public class ComplexValueTest extends TestCase {
	public void testsimple(){
		ComplexValue cv1 = new ComplexValue(1.0, 2.0);
		ComplexValue cv2 = new ComplexValue(3.0, 4.0);
		assertEquals(cv1.add(cv2),(new ComplexValue(4.0,6.0)));
		assertEquals(cv2.sub(cv1),(new ComplexValue(2.0,2.0)));
		assertEquals(cv1.mul(cv2),(new ComplexValue(-5.0,10.0)));
		
	}
	public void testcommutative(){
		for (int i = 0; i < 5000; i++){
			Random random = new Random();
			double r1 = random.nextDouble();
			double i1 = random.nextDouble();
			double r2 = random.nextDouble();
			double i2 = random.nextDouble();
			ComplexValue cv1 = new ComplexValue(r1, i1);
			ComplexValue cv2 = new ComplexValue(r2, i2);
			ComplexValue cv2n = new ComplexValue(-r2, -i2);
			assertEquals(cv1.add(cv2), (cv2.add(cv1)));
			assertEquals(cv1.sub(cv2),(cv2n.add(cv1)));
			assertEquals(cv1.mul(cv2),(cv2.mul(cv1)));
		}
	}
	public void testassociativity(){
		for (int i = 0; i < 5000; i++){
			Random random = new Random();
			double r1 = random.nextDouble();
			double i1 = random.nextDouble();
			double r2 = random.nextDouble();
			double i2 = random.nextDouble();
			double r3 = random.nextDouble();
			double i3 = random.nextDouble();
			ComplexValue cv1 = new ComplexValue(r1, i1);
			ComplexValue cv2 = new ComplexValue(r2, i2);
			ComplexValue cv3 = new ComplexValue(r3, i3);
			assertEquals(cv1.add(cv2.add(cv3)), cv3.add(cv1.add(cv2)));
			assertEquals(cv1.mul(cv2.mul(cv3)), cv2.mul(cv1.mul(cv3)));
			
		}
	}
}

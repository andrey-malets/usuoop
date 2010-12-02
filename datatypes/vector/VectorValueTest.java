package calculator.datatypes.vector;

import java.util.Random;
import junit.framework.TestCase;


public class VectorValueTest extends TestCase{
	public void testsimple(){
		VectorValue cv1 = new VectorValue(1.0, 2.0);
		VectorValue cv2 = new VectorValue(3.0, 4.0);
		assertEquals(cv1.add(cv2),(new VectorValue(4.0,6.0)));
		assertEquals(cv2.sub(cv1),(new VectorValue(2.0,2.0)));
		assertEquals(cv1.mul(cv2),(new VectorValue(3.0,8.0)));
		
	}
	public void testcommutative(){
		for (int i = 0; i < 5000; i++){
			Random random = new Random();
			double r1 = random.nextDouble();
			double i1 = random.nextDouble();
			double r2 = random.nextDouble();
			double i2 = random.nextDouble();
			VectorValue cv1 = new VectorValue(r1, i1);
			VectorValue cv2 = new VectorValue(r2, i2);
			VectorValue cv2n = new VectorValue(-r2, -i2);
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
			VectorValue cv1 = new VectorValue(r1, i1);
			VectorValue cv2 = new VectorValue(r2, i2);
			VectorValue cv3 = new VectorValue(r3, i3);
			assertEquals(cv1.add(cv2.add(cv3)), cv3.add(cv1.add(cv2)));
			assertEquals(cv1.mul(cv2.mul(cv3)), cv2.mul(cv1.mul(cv3)));
			
		}
	}
}

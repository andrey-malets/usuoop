package calculator.datatypes.rational;

import java.util.Random;
import junit.framework.TestCase;


public class RationalValueTest extends TestCase{
	
	private static int MAX_INT = 1000;
	
	public void testsimple(){
		RationalValue cv1 = new RationalValue(1, 2);
		RationalValue cv2 = new RationalValue(3, 4);
		assertEquals(cv1.add(cv2),(new RationalValue(5,4)));
		assertEquals(cv2.sub(cv1),(new RationalValue(1,4)));
		assertEquals(cv1.mul(cv2),(new RationalValue(3,8)));
		
	}
	public void testcommutative(){
		for (int i = 0; i < 5; i++){
			Random random = new Random();
			Integer r1 = random.nextInt(MAX_INT);
			Integer i1 = Math.abs(random.nextInt(MAX_INT));
			Integer r2 = random.nextInt(MAX_INT);
			Integer i2 = Math.abs(random.nextInt(MAX_INT));
			RationalValue cv1 = new RationalValue(r1, i1);
			RationalValue cv2 = new RationalValue(r2, i2);
			RationalValue cv2n = new RationalValue(-r2, i2);
			assertEquals(cv1.sub(cv2),(cv2n.add(cv1)));
			assertEquals(cv1.mul(cv2),(cv2.mul(cv1)));
		}
	}
	public void testassociativity(){
		for (int i = 0; i < 5; i++){
			Random random = new Random();
			Integer r1 = random.nextInt(MAX_INT);
			Integer i1 = Math.abs(random.nextInt(MAX_INT));
			Integer r2 = random.nextInt(MAX_INT);
			Integer i2 = Math.abs(random.nextInt(MAX_INT));
			Integer r3 = random.nextInt(MAX_INT);
			Integer i3 = Math.abs(random.nextInt(MAX_INT));
			RationalValue cv1 = new RationalValue(r1, i1);
			RationalValue cv2 = new RationalValue(r2, i2);
			RationalValue cv3 = new RationalValue(r3, i3);
			
			assertEquals(cv1.add(cv2.add(cv3)), cv3.add(cv1.add(cv2)));
			assertEquals(cv1.mul(cv2.mul(cv3)), cv2.mul(cv1.mul(cv3)));
		}
	}
	public void testnul(){
		for (int i = 0; i < 5; i++){
			Random random = new Random();
			Integer r1 = random.nextInt(MAX_INT);
			Integer i1 = Math.abs(random.nextInt(MAX_INT));
			Integer r2 = random.nextInt(MAX_INT);
			Integer i2 = Math.abs(random.nextInt(MAX_INT));
			RationalValue cv1 = new RationalValue(r1, i1);
			RationalValue cv2 = new RationalValue(r2, i2);
			RationalValue cv2n = new RationalValue(0, 1);
			assertEquals(cv1.sub(cv2n), cv1.nod());
			assertEquals(cv1.mul(cv2n), cv2n.nod());
			assertEquals(cv2.add(cv2n), cv2.nod());
			
		}
	}
}

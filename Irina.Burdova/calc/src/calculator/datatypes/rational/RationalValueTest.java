package calculator.datatypes.rational;


//import java.util.Random;

import calculator.DivisionByZeroException;
import junit.framework.TestCase;


public class RationalValueTest extends TestCase{
	
	
	public void testsimple(){
		try{
			RationalValue cv1 = new RationalValue(new Natural(1),new Natural(4) );
			RationalValue cv2 = new RationalValue(new Natural(2), new Natural(4));
			assertEquals(cv1.add(cv2),(new RationalValue(new Natural(3), new Natural(4))));
			assertEquals(cv2.sub(cv1),(new RationalValue(new Natural(1), new Natural(4))));
			assertEquals(cv1.mul(cv2),(new RationalValue(new Natural(1), new Natural(8))));
		}
		catch(DivisionByZeroException e){
			System.out.println("DivisionByZero: "+e.getMessage());
		}
	}
/*	public void testcommutative(){
		for (int i = 0; i < 500; i++){
			Random random = new Random();
			Natural r1 = random.nextLong(MAX_LONG);
			Integer i1 = Math.abs(random.nextInt(MAX_LONG));
			Integer r2 = random.nextInt(MAX_LONG);
			Integer i2 = Math.abs(random.nextInt(MAX_LONG));
			RationalValue cv1 = new RationalValue(r1, i1);
			RationalValue cv2 = new RationalValue(r2, i2);
			RationalValue cv2n = new RationalValue(-r2, i2);
			assertEquals(cv1.sub(cv2),(cv2n.add(cv1)));
			assertEquals(cv1.mul(cv2),(cv2.mul(cv1)));
		}
	}
	public void testassociativity(){
		for (int i = 0; i < 500; i++){
			Random random = new Random();
			Integer r1 = random.nextInt(MAX_LONG);
			Integer i1 = Math.abs(random.nextInt(MAX_LONG));
			Integer r2 = random.nextInt(MAX_LONG);
			Integer i2 = Math.abs(random.nextInt(MAX_LONG));
			Integer r3 = random.nextInt(MAX_LONG);
			Integer i3 = Math.abs(random.nextInt(MAX_LONG));
			RationalValue cv1 = new RationalValue(r1, i1);
			RationalValue cv2 = new RationalValue(r2, i2);
			RationalValue cv3 = new RationalValue(r3, i3);
			
			assertEquals(cv1.add(cv2.add(cv3)), cv3.add(cv1.add(cv2)));
			assertEquals(cv1.mul(cv2.mul(cv3)), cv2.mul(cv1.mul(cv3)));
		}
	}
	public void testnul(){
		for (int i = 0; i < 500; i++){
			Random random = new Random();
			long r1 = random.nextLong();
			Integer i1 = Math.abs(random.nextInt(MAX_LONG));
			Integer r2 = random.nextInt(MAX_LONG);
			Integer i2 = Math.abs(random.nextInt(MAX_LONG));
			RationalValue cv1 = new RationalValue(r1, i1);
			RationalValue cv2 = new RationalValue(r2, i2);
		;
		}
	}
	*/
}

package Test;

import java.util.ArrayList;
import java.util.Random;

import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Fields.RealValue;
import Fields.Vector;


import junit.framework.TestCase;

public class VectorTest extends TestCase {

	@SuppressWarnings("unchecked")
	public void testAdd() throws OperationNotSupportedException, DifferentDimensions {
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		ArrayList<RealValue> a = new ArrayList<RealValue>();
		ArrayList<RealValue> b = new ArrayList<RealValue>();

		for (int i = 0; i < lim; i++) {
			a.add(i,new RealValue(rn.nextDouble()));
		}
		for (int i = 0; i < lim; i++) {
			b.add(i,new RealValue(rn.nextDouble()));
		}
		Vector<RealValue> vec1 = new Vector<RealValue>(a);
		Vector<RealValue> vec2 = new Vector<RealValue>(b);
		assertEquals(((Vector<RealValue>)vec1.add(vec2)).toString(), ((Vector<RealValue>)vec2.add(vec1)).toString());
	}
	public void testMul() throws OperationNotSupportedException{
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		ArrayList<RealValue> a = new ArrayList<RealValue>();
		ArrayList<RealValue> b = new ArrayList<RealValue>();
		for (int i = 0; i < lim; i++) {
			a.add(i,new RealValue(rn.nextDouble()));
		}
		RealValue qwe = new RealValue(rn.nextDouble());
		for (int i=0;i<a.size();i++){
			b.add((RealValue) a.get(i).mul(qwe));
		}
		Vector<RealValue> vec = new Vector<RealValue>(a);
		assertEquals(vec.mul(qwe).toString(), new Vector<RealValue>(b).toString());
	}
	public void testDiv() throws OperationNotSupportedException, DivisionByZeroException{
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		ArrayList<RealValue> a = new ArrayList<RealValue>();
		ArrayList<RealValue> b = new ArrayList<RealValue>();
		for (int i = 0; i < lim; i++) {
			a.add(i,new RealValue(rn.nextDouble()));
		}
		RealValue qwe = new RealValue(rn.nextDouble());
		for (int i=0;i<a.size();i++){
			b.add((RealValue) a.get(i).div(qwe));
		}
		Vector<RealValue> vec = new Vector<RealValue>(a);
		assertEquals(vec.div(qwe).toString(), new Vector<RealValue>(b).toString());
	}
}

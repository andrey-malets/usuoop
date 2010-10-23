package testVector;

import java.util.Random;

import vector.Vector3D;
import exceptions.MyException;
import field.BinField;
import junit.framework.TestCase;

public class TestVector3DBinField extends TestCase {
	public void testDim() throws MyException {
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		BinField comp1[] = new BinField[lim];
		for (int i = 0; i < lim; i++) {
			comp1[i] = new BinField(rn.nextInt(1));
		}
		Vector3D<Integer> vec = new Vector3D<Integer>(comp1);
		assertEquals(vec.dimension(), lim);
	}
	public void testScalar() throws MyException{
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		BinField comp1[] = new BinField[lim];
		for (int i =0 ;i<lim;i++){
			Integer a = rn.nextInt(1);
			comp1[i] = new BinField(a);
		}
		Vector3D<Integer> vec1 = new Vector3D<Integer>(comp1);
		Vector3D<Integer> vec2 = new Vector3D<Integer>(comp1);
		BinField qwe = new BinField(1);
		Vector3D<Integer> vec3 = vec1.multiply(qwe);
	for (int i=0;i<lim;i++){
		assertEquals(vec2.getComponent(i).getElem(), vec3.getComponent(i).getElem());
	}
}
	public void testAdd() throws MyException{
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		BinField comp1[] = new BinField[lim];
		BinField comp2[] = new BinField[lim];
		for (int i =0 ;i<lim;i++){
			comp1[i] = new BinField(rn.nextInt(1));
			comp2[i] = new BinField(rn.nextInt(1));
		}
		Vector3D<Integer> vec1 = new Vector3D<Integer>(comp1);
		Vector3D<Integer> vec2 = new Vector3D<Integer>(comp2);
		Vector3D<Integer> vec3 = vec1.add(vec2);
		Vector3D<Integer> vec4 = vec2.add(vec1);
		for (int i=0;i<lim;i++){
			assertEquals(vec3.getComponent(i).getElem(), vec4.getComponent(i).getElem());
		}
	}
	
}

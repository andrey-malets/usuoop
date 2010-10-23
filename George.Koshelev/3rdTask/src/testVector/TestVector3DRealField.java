package testVector;

import java.util.Random;
import exceptions.MyException;
import field.RealNumbField;
import vector.Vector3D;

import junit.framework.TestCase;

public class TestVector3DRealField extends TestCase {
	public void testDim() throws MyException {
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		RealNumbField comp1[] = new RealNumbField[lim];
		for (int i = 0; i < lim; i++) {
			comp1[i] = new RealNumbField(rn.nextDouble());
		}
		Vector3D<Double> vec = new Vector3D<Double>(comp1);
		assertEquals(vec.dimension(), lim);
	}

	public void testScalar() throws MyException {
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		RealNumbField comp1[] = new RealNumbField[lim];
		RealNumbField comp2[] = new RealNumbField[lim];
		Double a[] = new Double[lim];
		Double b[] = new Double[lim];
		for (int i = 0; i < lim; i++) {
			Double qwe = rn.nextDouble();
			comp1[i] = new RealNumbField(qwe);
			a[i] = qwe;
		}
		for (int i = 0; i < lim; i++) {
			Double qwe = rn.nextDouble();
			comp2[i] = new RealNumbField(qwe);
			b[i] = qwe;
		}
		Double c = 0.;
		for (int i = 0; i<lim;i++){
			c+=a[i]*b[i];
		}
		Vector3D<Double> vec1 = new Vector3D<Double>(comp1);
		Vector3D<Double> vec2 = new Vector3D<Double>(comp2);
		assertEquals(c.toString(), vec1.scalar(vec2).toString());
	}
	public void testScalar1() throws MyException {
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		RealNumbField comp1[] = new RealNumbField[lim];
		RealNumbField comp2[] = new RealNumbField[lim];
		for (int i = 0; i < lim; i++) {
			Double qwe = rn.nextDouble();
			comp1[i] = new RealNumbField(qwe);
		}
		for (int i = 0; i < lim; i++) {
			Double qwe = rn.nextDouble();
			comp2[i] = new RealNumbField(qwe);
		}
		Vector3D<Double> vec1 = new Vector3D<Double>(comp1);
		Vector3D<Double> vec2 = new Vector3D<Double>(comp2);
		assertEquals(vec2.scalar(vec1).toString(), vec1.scalar(vec2).toString());
	}
	public void testLen() throws MyException {
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		RealNumbField comp1[] = new RealNumbField[lim];
		Double c = 0.;
		for (int i = 0; i < lim; i++) {
			Double qwe = rn.nextDouble();
			c+=Math.pow(qwe, 2);
			comp1[i] = new RealNumbField(qwe);
		}
		Vector3D<Double> vec1 = new Vector3D<Double>(comp1);
		assertEquals(Math.sqrt(c), vec1.len());
	}
	public void testMult(){
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		RealNumbField comp1[] = new RealNumbField[lim];
		Double a[] = new Double[lim];
		Double fact =rn.nextDouble();
		for (int i =0 ;i<lim;i++){
			a[i] = rn.nextDouble();
			comp1[i] = new RealNumbField(a[i]*fact);
			a[i]*=fact;
		}
		for (int i=0;i<lim;i++){
			assertEquals(a[i].toString(), comp1[i].toString());
		}
	}
	public void testAdd() throws MyException{
		Random rn = new Random();
		int lim = rn.nextInt(100)+1;
		RealNumbField comp1[] = new RealNumbField[lim];
		RealNumbField comp2[] = new RealNumbField[lim];
		for (int i =0 ;i<lim;i++){
			comp1[i] = new RealNumbField(rn.nextDouble());
			comp2[i] = new RealNumbField(rn.nextDouble());
		}
	Vector3D<Double> vec1 = new Vector3D<Double>(comp1);
	Vector3D<Double> vec2 = new Vector3D<Double>(comp2);
	Vector3D<Double> vec3 = vec1.add(vec2);
	Vector3D<Double> vec4 = vec2.add(vec1);
	for (int i=0;i<lim;i++){
		assertEquals(vec3.getComponent(i).toString(), vec4.getComponent(i).toString());
	}
	}
	public void testNegat(){
		Random rn = new Random();
		Double rand = rn.nextDouble();
		RealNumbField a = new RealNumbField(rand);
		RealNumbField b = new RealNumbField(-rand);
		assertEquals(a.negativeNumb().toString(),b.toString());
	}
}
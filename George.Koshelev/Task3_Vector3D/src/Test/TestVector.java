package Test;

import java.util.Random;

import vectors.Vector3D;
import vectors.VectorException;

import junit.framework.TestCase;

public class TestVector extends TestCase {
public void testGetDimension(){
	Random rn = new Random();
	int razm = rn.nextInt(100);
	double[] a = new double[razm];
	for(int i=0;i<razm;i++){
			a[i] = rn.nextDouble();
	}
	Vector3D vec = new Vector3D(a);
	assertEquals(vec.dimension(), razm);
}
public void testGetComponent(){
	Random rn = new Random();
	int razm = rn.nextInt(100);
	double[] a = new double[razm];
	double[] b = new double[razm];	
	for(int i=0;i<razm;i++){
			b[i] = a[i] = rn.nextDouble();
	}
	Vector3D vec = new Vector3D(a);
	int ind = rn.nextInt(razm);
	assertEquals(vec.getComponent(ind), b[ind]);
}
public void testScalar() throws VectorException{
	Random rn = new Random();
	int razm = rn.nextInt(100);
	double[] a = new double[razm];
	for(int i=0;i<razm;i++){
		a[i] = rn.nextDouble();
	}
	double[] b = new double[razm];
	for(int i=0;i<razm;i++){
		b[i] = rn.nextDouble();
	}
	double sc = 0.0;
	for(int i=0;i<razm;i++){
			sc+=a[i]*b[i];
	}
	Vector3D vec1 = new Vector3D(a);
	Vector3D vec2 = new Vector3D(b);
	assertEquals(vec1.scalar(vec2), sc);
}
public void testLen(){
	double[] a = {1,0,0,0};
	Vector3D vec =new Vector3D(a);
	assertEquals(vec.len(),1.);
}
public void testAdd(){
	Random rn = new Random();
	int razm = rn.nextInt(100);
	double[] a = new double[razm];
	for(int i=0;i<razm;i++){
		a[i] = rn.nextDouble();
	}
	double[] b = new double[razm];
	for(int i=0;i<razm;i++){
		b[i] = rn.nextDouble();
	}
	double[] c = new double[razm];
	for(int i=0;i<razm;i++){
		c[i]=a[i]+b[i];
	}
	Vector3D vec1 = new Vector3D(a);
	Vector3D vec2 = new Vector3D(b);	
	assertEquals(vec1.add(vec2).getVectorToString(), new Vector3D(c).getVectorToString());
}
public void testSub(){
	Random rn = new Random();
	int razm = rn.nextInt(100);
	double[] a = new double[razm];
	for(int i=0;i<razm;i++){
		a[i] = rn.nextDouble();
	}
	double[] b = new double[razm];
	for(int i=0;i<razm;i++){
		b[i] = rn.nextDouble();
	}
	double[] c = new double[razm];
	for(int i=0;i<razm;i++){
		c[i]=a[i]-b[i];
	}
	Vector3D vec1 = new Vector3D(a);
	Vector3D vec2 = new Vector3D(b);	
	assertEquals(vec1.sub(vec2).getVectorToString(), new Vector3D(c).getVectorToString());
}
public void testMult(){
	Random rn = new Random();
	int razm = rn.nextInt(100);
	double factor = rn.nextDouble();
	double[] a = new double[razm];
	for(int i=0;i<razm;i++){
		a[i] = rn.nextDouble();
	}
	Vector3D vec = new Vector3D(a);
	StringBuffer str = new StringBuffer();
	for (int i=0;i<razm;i++){
		str.append(a[i]*factor);
	}
	assertEquals(vec.multiply(factor).getVectorToString(), str.toString());
}
}

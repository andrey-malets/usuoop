package Test;

import java.util.Random;

import main.Vector3D;
import junit.framework.TestCase;

public class TestVector3D extends TestCase {
	public void test1Axiom() {
		Random rn = new Random(100);
		double x = rn.nextDouble();
		double y = rn.nextDouble();
		double z = rn.nextDouble();
		Vector3D vec1 = new Vector3D(x, y, z);
		x = rn.nextDouble();
		y = rn.nextDouble();
		z = rn.nextDouble();
		Vector3D vec2 = new Vector3D(x, y, z);
		assertEquals(vec1.add(vec2).getX(), vec2.add(vec1).getX(), 0.0001);
		assertEquals(vec1.add(vec2).getY(), vec2.add(vec1).getY(), 0.0001);
		assertEquals(vec1.add(vec2).getZ(), vec2.add(vec1).getZ(), 0.0001);
	}

	public void test2Axiom() {
		Random rn = new Random(100);
		double x = rn.nextDouble();
		double y = rn.nextDouble();
		double z = rn.nextDouble();
		Vector3D vec1 = new Vector3D(x, y, z);
		x = rn.nextDouble();
		y = rn.nextDouble();
		z = rn.nextDouble();
		Vector3D vec2 = new Vector3D(x, y, z);
		x = rn.nextDouble();
		y = rn.nextDouble();
		z = rn.nextDouble();
		Vector3D vec3 = new Vector3D(x, y, z);
		double delta = 0.0001;
		assertEquals(vec1.add(vec2.add(vec3)).getX(), vec3.add(vec2.add(vec1))
				.getX(), delta);
		assertEquals(vec1.add(vec2.add(vec3)).getY(), vec3.add(vec2.add(vec1))
				.getY(), delta);
		assertEquals(vec1.add(vec2.add(vec3)).getZ(), vec3.add(vec2.add(vec1))
				.getZ(), delta);
	}

	public void test3Axiom() {
		Vector3D empty = new Vector3D();
		Random rn = new Random(100);
		double x = rn.nextDouble();
		double y = rn.nextDouble();
		double z = rn.nextDouble();
		Vector3D vec = new Vector3D(x, y, z);
		assertEquals(vec.add(empty).getX(), vec.getX(), 0.0001);
		assertEquals(vec.add(empty).getY(), vec.getY(), 0.0001);
		assertEquals(vec.add(empty).getZ(), vec.getZ(), 0.0001);
	}

	public void test4Axiom() {
		Random rn = new Random(100);
		double x = rn.nextDouble();
		double y = rn.nextDouble();
		double z = rn.nextDouble();
		Vector3D vec = new Vector3D(x, y, z);
		assertEquals(vec.sub(vec).getX(), 0, 0);
		assertEquals(vec.sub(vec).getY(), 0, 0);
		assertEquals(vec.sub(vec).getZ(), 0, 0);
	}

	public void test5Axiom() {
		Random rn = new Random(100);
		double x = rn.nextDouble();
		double y = rn.nextDouble();
		double z = rn.nextDouble();
		Vector3D vec = new Vector3D(x, y, z);
		double alf = rn.nextDouble();
		double bet = rn.nextDouble();
		assertEquals((vec.multiply(alf)).multiply(bet).getX(), (vec
				.multiply(bet)).multiply(alf).getX(), 0.0001);
		assertEquals((vec.multiply(alf)).multiply(bet).getY(), (vec
				.multiply(bet)).multiply(alf).getY(), 0.0001);
		assertEquals((vec.multiply(alf)).multiply(bet).getZ(), (vec
				.multiply(bet)).multiply(alf).getZ(), 0.0001);
	}
	public void test6Axiom(){
		
	}
}

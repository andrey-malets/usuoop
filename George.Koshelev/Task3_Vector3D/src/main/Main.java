package main;

import vectors.Vector3D;
import vectors.VectorException;

public class Main {
public static void main(String[] arg) throws VectorException{
		double[] a = {1.2,2.,3.};
		int[] b = {1,2,3};
		Vector3D vec1  = new Vector3D(a);
		a[1]  =1.;
		Vector3D vec2 = new Vector3D(b);
		b[1] = 1;
		System.out.println(vec2.getComponent(1));
}
}

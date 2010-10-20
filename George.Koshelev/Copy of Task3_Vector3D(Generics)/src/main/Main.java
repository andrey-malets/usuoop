package main;

import vectors.Vector3D;
import vectors.VectorException;

public class Main {
public static void main(String[] arg) throws VectorException{
		Double[] a = {1.2,2.1,3.};
		Double[] b = {1.0,2.,3.2};
		Integer[] a1 = {1,2,3};
		Integer[] b1 = {1,2,3};
		Vector3D<Double> vec1 = new Vector3D<Double>(a);
		Vector3D<Double> vec2 = new Vector3D<Double>(b);		
		Vector3D<Integer> vec1int = new Vector3D<Integer>(a1);		
		Vector3D<Integer> vec2int = new Vector3D<Integer>(b1);		
		//System.out.println(vec1int.scalar(vec2int));
		Integer q = 1;
		Double w =2.; 
		System.out.println(vec1.sub(vec2).getVectorToString());
}
}

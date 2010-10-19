package main;

public class Main {
public static void main(String[] arg) throws VectorException{
		double[] a = {1.2,2.0,3.0};
		int[] b = {1,2,3};
		Vector3D vec1  = new Vector3D(a);
		Vector3D vec2 = new Vector3D(b);
		System.out.println(vec2.sub(vec1).getComponent(0));
}
}

package main;

public class Main {
public static void main(String[] arg){
		Vector3D vec1  = new Vector3D(-1,2,1);
		Vector3D vec2 = vec1.multiply(2);
		System.out.println((int)vec2.getX());
		System.out.println((int)vec2.getY());
		System.out.println((int)vec2.getZ());
}
}

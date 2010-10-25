package main;

import vector.Vector3D;

import exceptions.MyException;
import field.BinField;
import field.RealNumbField;

public class Main {
	public static void main(String[] arg) throws MyException {
		RealNumbField[] a = new RealNumbField[3];
		a[0] = new RealNumbField(1.);
		a[1] = new RealNumbField(1.);
		a[2] = new RealNumbField(1.);
		Vector3D<Double> vec = new Vector3D<Double>(a);
		System.out.println(vec.getNegVec().getVecToString());
	}
}

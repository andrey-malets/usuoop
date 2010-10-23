package main;

import vector.Vector3D;

import exceptions.MyException;
import field.BinField;
import field.RealNumbField;

public class Main {
	public static void main(String[] arg) throws MyException {
		BinField comp[] = new BinField[] { new BinField(1),
				new BinField(0), new BinField(1) };
		Vector3D<Integer> vec = new Vector3D<Integer>(comp);
		System.out
				.println(vec.getComponent(1).getElem());
	}
}

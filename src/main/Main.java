package main;

import java.util.ArrayList;

import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Fields.IntegerValue;
//import Fields.Vector;

public class Main {
public static void main(String[] arg) throws OperationNotSupportedException, DifferentDimensions, DivisionByZeroException{
	ArrayList<IntegerValue> list = new ArrayList<IntegerValue>();
	list.add(new IntegerValue(2));
	list.add(new IntegerValue(1));
	IntegerValue a = new IntegerValue(1);
	IntegerValue b = new IntegerValue(2);
	//Vector<IntegerValue> vec = new Vector<IntegerValue>(list);
	System.out.println(a.add(b));
}
}

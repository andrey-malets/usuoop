package main;

import java.util.ArrayList;
import java.util.List;

import field.RealNumbField;

public class Main {
public static void main(String[] arg){
	List<RealNumbField> v = new ArrayList<RealNumbField>();
	RealNumbField a = new RealNumbField(1.);
	RealNumbField b = new RealNumbField(1.);
	v.add(0,a);
	System.out.println(a.add(b).getElem());
}
}

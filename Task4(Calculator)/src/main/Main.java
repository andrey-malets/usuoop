package main;

import Exceptions.ParseValueException;
import Fields.ComplexValue;
import Fields.IntegerValue;
import Fields.RealValue;
import Fields.Vector;
import Parser.ComplexValueParser;
import Parser.VectorIntegerValueParser;
import Parser.VectorRealValueParser;

public class Main {
public static void 	main(String[] arg) throws ParseValueException{
	IntegerValue a = new IntegerValue(1);
	RealValue b = new RealValue(1.);
	ComplexValueParser par = new ComplexValueParser();
	ComplexValue qwe = new ComplexValue(1.,2.);
	System.out.println(((ComplexValue)par.parse("<1.;2.>")).getReElem());
}
}

package Parser;

import Parser.AbstractValueParser;
import Exceptions.ParseValueException;
import Fields.AbstractField;
import Fields.ComplexValue;

public class ComplexValueParser implements AbstractValueParser{

	public String getDatatypeName() {
		return "Complex value";
	}

	public AbstractField parse(String value) throws ParseValueException {
		try{
		value = value.replaceFirst("<", "");
		value = value.replaceFirst(">", "");
		String[] a = value.split(";");
		return new ComplexValue(Double.parseDouble(a[0]),Double.parseDouble(a[1]));
		}
		catch(NumberFormatException e){
				throw new ParseValueException(); 
		}

}
}

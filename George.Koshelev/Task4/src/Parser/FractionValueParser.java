package Parser;

import Exceptions.ParseValueException;
import Exceptions.ZeroDiscr;
import Fields.AbstractField;
import Fields.FractionValue;

public class FractionValueParser implements AbstractValueParser{

	public String getDatatypeName() {
		return "Fraction Value";
	}

	public AbstractField parse(String value) throws ParseValueException, ZeroDiscr {
		try{
			String[] ar = value.split(":");
			return new FractionValue(Integer.parseInt(ar[0]),Integer.parseInt(ar[1]));
		}
		catch(NumberFormatException e){
			throw new ParseValueException();
		}
	}

}

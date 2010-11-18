package Parser;

import Exceptions.ParseValueException;
import Parser.AbstractValueParser;
import Fields.AbstractField;
import Fields.RealValue;

public class RealValueParser implements AbstractValueParser {

	public String getDatatypeName() {
		return "Real value";
	}

	public AbstractField parse(String value) throws ParseValueException {
		try {
			return new RealValue(Double.parseDouble(value));
		} catch (NumberFormatException e) {
			throw new ParseValueException();
		}
	}

}

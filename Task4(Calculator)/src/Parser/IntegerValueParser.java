package Parser;

import Parser.AbstractValueParser;
import Exceptions.ParseValueException;
import Fields.AbstractField;
import Fields.IntegerValue;

public class IntegerValueParser implements AbstractValueParser {

	public String getDatatypeName() {
		return "Integer Value";
	}

	public AbstractField parse(String value) throws ParseValueException {
		try {
			return new IntegerValue(Integer.parseInt(value));
		} catch (NumberFormatException e) {
			throw new ParseValueException();
		}

	}
}

package Parser;

import java.util.ArrayList;

import Fields.AbstractField;
import Fields.Vector;
import Exceptions.ParseValueException;
import Parser.AbstractValueParser;
import Fields.IntegerValue;

public class VectorIntegerValueParser implements AbstractValueParser {

	public String getDatatypeName() {
		return "Vector value";
	}

	public AbstractField parse(String value) throws ParseValueException {
		try {
			value = value.replaceAll("<", "");
			value = value.replaceAll(">", "");
			String[] a = value.split(";");
			ArrayList<IntegerValue> list = new ArrayList<IntegerValue>();
			for (int i = 0; i < a.length; i++) {
				list.add(new IntegerValue(Integer.parseInt(a[i])));
			}
			return new Vector<IntegerValue>(list);
		} catch (NumberFormatException e) {
			throw new ParseValueException();
		}
	}
}

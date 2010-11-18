package Parser;

import java.util.ArrayList;

import Fields.AbstractField;
import Fields.Vector;
import Exceptions.ParseValueException;
import Parser.AbstractValueParser;
import Fields.RealValue;

public class VectorRealValueParser implements AbstractValueParser {

	public String getDatatypeName() {
		return "Vector value";
	}

	public AbstractField parse(String value) throws ParseValueException {
		try {
			value = value.replaceAll("<", "");
			value = value.replaceAll(">", "");
			String[] a = value.split(";");
			ArrayList<RealValue> list = new ArrayList<RealValue>();
			for (int i = 0; i < a.length; i++) {
				list.add(new RealValue(Double.parseDouble(a[i])));
			}
			return new Vector<RealValue>(list);
		} catch (NumberFormatException e) {
			throw new ParseValueException();
		}
	}
}
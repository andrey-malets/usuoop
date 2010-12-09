package calculator.datatypes.vector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class VectorValueParser implements AbstractValueParser {

	public AbstractValue parse(String value) throws ParseValueException {
		Pattern pattern = Pattern.compile("^\\x28(.+?),(.+?),(.+?)\\x29$");
		Matcher matcher = pattern.matcher(value);
		double a = 0,b = 0, c = 0;
		if (matcher.find()) {
			a = Double.parseDouble(matcher.group(1));
			b = Double.parseDouble(matcher.group(2));
			c = Double.parseDouble(matcher.group(3));
		} 
		else {
			throw new ParseValueException();
		}
		return new VectorValue(a,b,c);		
	
	}

	public String getDatatypeName() {
		return "Трёхмерный вектор";
	}

}

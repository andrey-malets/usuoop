package calculator.datatypes.vector;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;



import java.util.regex.*;

public class VectorValueParser  implements AbstractValueParser {
	private static Pattern pattern = Pattern.compile("\\((-?([0-9]+)?(\\.([0-9]+)?)?),(-?([0-9]+)?(\\.([0-9]+)?)?)\\)");
	public AbstractValue parse(String value) throws ParseValueException {
		try {
			Matcher matcher = pattern.matcher(value);
			VectorValue VecVal;
			
			if (matcher.matches()){
				VecVal =  new VectorValue(Double.parseDouble(matcher.group(1)),
						Double.parseDouble(matcher.group(5))) ;
			}
			else{
				throw new ParseValueException();
			}
			return VecVal;
		} catch (NumberFormatException exception) {
			throw new ParseValueException();
		}
	}

	public String getDatatypeName() {
		return "векторы";
	}
}

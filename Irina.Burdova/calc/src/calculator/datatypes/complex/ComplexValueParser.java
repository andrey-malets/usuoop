package calculator.datatypes.complex;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

import java.util.regex.*;

public class ComplexValueParser implements AbstractValueParser {
	public AbstractValue parse(String value) throws ParseValueException {
			try {
                Pattern pattern = Pattern.compile("(-?[0-9]+(\\.([0-9]+)?(E[0-9]+)?)?)([+-][0-9]+(\\.([0-9]+)?(E[0-9]+)?)?)\\*i");
                Matcher matcher = pattern.matcher(value);
                if (matcher.matches()){
        double r = Double.parseDouble(matcher.group(1));
        double i = Double.parseDouble(matcher.group(5));
        return  new ComplexValue(r, i) ;
                }
                else{
        throw new ParseValueException();
                }
        } catch (NumberFormatException exception) {
                throw new ParseValueException();
        }
	}

	public String getDatatypeName() {
		return "комплексные числа";
	}
}
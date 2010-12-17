package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.DivisionByZeroException;
import calculator.ParseValueException;


import java.util.regex.*;
import calculator.datatypes.rational.RationalValue.Natural;

public class RationalValueParser implements AbstractValueParser {
	private static Pattern pattern = Pattern.compile("([1-9][0-9]*)(/([1-9][0-9]*))?");
	public AbstractValue parse(String value) throws ParseValueException {
        try {
                Matcher matcher = pattern.matcher(value);
                if (matcher.matches() ){
                       	Long n = Long.parseLong(matcher.group(1));
                        Long d = Long.parseLong(matcher.group(3));
                        Natural num = null;
						try {
							num = new Natural(n);
						} catch (DivisionByZeroException e) {
							
							e.printStackTrace();
						}
                        Natural den = null;
						try {
							den = new Natural(d);
						} catch (DivisionByZeroException e) {
							e.printStackTrace();
						}
                        return RationalValue.get(num, den) ;
                 }
  
            	else{
                    throw new ParseValueException("Не подходит под regexp!");
            	}
                
                
        } catch (NumberFormatException exception) {
                throw new ParseValueException();
        }
}

	public String getDatatypeName() {
		return "рациональные числа";
	}

}

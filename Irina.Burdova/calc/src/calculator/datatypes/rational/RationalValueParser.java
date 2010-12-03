package calculator.datatypes.rational;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;


import java.util.regex.*;

public class RationalValueParser implements AbstractValueParser {
	private static Pattern pattern = Pattern.compile("(-?[0-9]+)(/([0-9]+))?");
	public AbstractValue parse(String value) throws ParseValueException {
        try {
                Matcher matcher = pattern.matcher(value);
                if (matcher.matches() ){
                        int n = Integer.parseInt(matcher.group(1));
                        if (n == 0)
                        	return new RationalValue(0, 1);
                        int d = Integer.parseInt(matcher.group(3));
                        if (d == 0)
                                throw new ParseValueException();
                        
                        return  new RationalValue(n, d) ;
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

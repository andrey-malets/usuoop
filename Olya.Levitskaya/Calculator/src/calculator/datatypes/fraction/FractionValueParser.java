package calculator.datatypes.fraction;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class FractionValueParser implements AbstractValueParser{
  
  public AbstractValue parse(String value) throws ParseValueException {
    Pattern pattern = Pattern.compile("^((.+)(/)(.+))|(.+)$");
    Matcher matcher = pattern.matcher(value);
    int p,q;
    if (matcher.find()) {
      try {
    	if (matcher.group(3) != null) {
    		p = Integer.parseInt(matcher.group(2));
    		q = Integer.parseInt(matcher.group(4));
    	} else {
    		p = Integer.parseInt(matcher.group(5));
    		q = 1;
    	}
      } catch (Exception ex) {
        throw new ParseValueException(ex);
      }
      
    } else {
      throw new ParseValueException();
    }
    return new FractionValue(p,q);
  }
  public String getDatatypeName() {
    return "Fractional";
  }

}

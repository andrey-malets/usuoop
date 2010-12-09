package calculator.datatypes.complex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class ComplexValueParser implements AbstractValueParser {  
  public AbstractValue parse(String value) throws ParseValueException {
    Pattern pattern = Pattern.compile("^(.+)([\\+\\-\\/\\*])(.+)i$");
    Matcher matcher = pattern.matcher(value);
    double re,im;
    if (matcher.find()) {      
      re = Double.parseDouble(matcher.group(1));
      im = Double.parseDouble(matcher.group(2) + matcher.group(3));
    } else {
      throw new ParseValueException();
    }
    return new ComplexValue(re,im);
  }

  public String getDatatypeName() {
    return "Complex";
  }

}

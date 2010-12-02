package calculator.datatypes.fractional;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.AbstractValue;
import calculator.AbstractValueParser;
import calculator.ParseValueException;

public class FractionalValueParser implements AbstractValueParser{
  
  public AbstractValue parse(String value) throws ParseValueException {
    Pattern pattern = Pattern.compile("^(.+)/(.+)$");
    Matcher matcher = pattern.matcher(value);
    int p,q;
    if (matcher.find()) {
      try {
        p = Integer.parseInt(matcher.group(1));
        q = Integer.parseInt(matcher.group(2));
      } catch (Exception ex) {
        throw new ParseValueException();
      }
    } else {
      throw new ParseValueException();
    }
    return new FractionalValue(p,q);
  }

  public String getDatatypeName() {
    return "Fractional";
  }

}

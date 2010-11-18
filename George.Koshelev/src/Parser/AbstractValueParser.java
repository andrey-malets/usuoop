package Parser;
import Fields.AbstractField;
import Exceptions.ParseValueException;
import Exceptions.ZeroDiscr;

public interface AbstractValueParser {
	AbstractField parse(String value) throws ParseValueException, ZeroDiscr;
	String getDatatypeName();
}

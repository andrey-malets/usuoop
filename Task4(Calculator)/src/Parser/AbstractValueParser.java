package Parser;
import Fields.AbstractField;
import Exceptions.ParseValueException;

public interface AbstractValueParser {
	AbstractField parse(String value) throws ParseValueException;
	String getDatatypeName();
}

package Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
	private static final Pattern pat = Pattern.compile("[^0-9+*;().=/<>:-]");

	public static void validString(String a) throws Exception {
		Matcher m = pat.matcher(a);
		if (m.find()) {
			throw new Exception("Wrong symbols in string");
		}
	}
}

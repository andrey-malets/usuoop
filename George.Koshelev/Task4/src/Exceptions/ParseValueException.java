package Exceptions;

public class ParseValueException extends Exception {

	private static final long serialVersionUID = 6148164264266328147L;

	public ParseValueException() {
		super("Parse Value Exception");
	}

	public ParseValueException(String details) {
		super("Parse Value Exception:" + details);
	}
}

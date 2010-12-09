package calculator;

@SuppressWarnings("serial")
public class ParseValueException extends Exception {
	public ParseValueException() {
		super("Неверный формат строки");
	}
	public ParseValueException(Exception cause) {
		super("Неверный формат строки. :" + cause.getLocalizedMessage());
	}
}

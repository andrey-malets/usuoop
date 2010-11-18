package Exceptions;

public class DivisionByZeroException extends Exception {

	private static final long serialVersionUID = -6671317106093237551L;

	public DivisionByZeroException() {
		super("Division by zero");
	}
}

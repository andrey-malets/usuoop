package Exceptions;

public class OperationNotSupportedException extends Exception {

	private static final long serialVersionUID = -7133412959360328320L;

	public OperationNotSupportedException(String operation) {
		super("Operation" + operation + "not supported!");
	}

}

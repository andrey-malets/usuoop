package calculator;

@SuppressWarnings("serial")
public class DivisionByZeroException extends OperationNotSupportedException{
	public DivisionByZeroException() {
		super("������� �� ����");
	}
}

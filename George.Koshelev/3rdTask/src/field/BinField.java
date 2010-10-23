package field;

import exceptions.MyException;
import fieldsInterfaces.MyField;

public class BinField implements MyField<Integer> {
	private Integer elem;

	public BinField() {
		this.elem = 0;
	}

	public BinField(Integer i) throws MyException {
		if (checkOne(i) || checkZero(i)) {
			this.elem = new Integer(i);
		} else {
			throw new MyException("The argument should be binary");
		}
	}

	public boolean checkOne(Integer i) {
		if (i == 1) {
			return true;
		}
		return false;
	}

	public boolean checkZero(Integer i) {
		if (i == 0) {
			return true;
		}
		return false;
	}

	public Integer getElem() {
		return new Integer(this.elem);
	}

	public BinField add(MyField<Integer> var) throws MyException {
		return new BinField(
				(this.elem.intValue() + var.getElem().intValue()) % 2);
	}

	public BinField mul(MyField<Integer> var) throws MyException {
		return new BinField(this.elem.intValue() * var.getElem().intValue());
	}

	public MyField<Integer> oppositeNumb() throws MyException {
		return new BinField((this.elem.intValue() + 1) % 2);
	}

	public MyField<Integer> negativeNumb() throws MyException {
		return new BinField(-this.elem.intValue());
	}
}

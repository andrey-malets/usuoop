package field;

import exceptions.MyException;
import fieldsInterfaces.MyField;

/**
 * Binary Field.
 * 
 * @author Georgy
 * 
 */
public class BinField implements MyField<Integer> {
	private Integer elem;

	public BinField() {
		this.elem = 0;
	}

	public BinField(Integer i) throws MyException {
		if (checkOne(i) || checkZero(i)) {
			this.elem = new Integer(i);
		} else {
			throw new MyException("The argument should be 0 or 1");
		}
	}

	public boolean checkOne(Integer i) {
		if (Math.abs(i) == 1) {
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

	/**
	 * Sum of binary data
	 */
	public BinField add(MyField<Integer> var) throws MyException {
		return new BinField(
				(this.elem.intValue() + var.getElem().intValue()) % 2);
	}

	/**
	 * Multiply of binary data.
	 */
	public BinField mul(MyField<Integer> var) throws MyException {
		return new BinField(this.elem.intValue() * var.getElem().intValue());
	}
	/**
	 * Get opposite number
	 */
	public MyField<Integer> oppositeNumb() throws MyException {
		return new BinField((this.elem.intValue() + 1) % 2);
	}
	/**
	 * Get negative number
	 */
	public MyField<Integer> negativeNumb() throws MyException {
		return new BinField(-this.elem.intValue());
	}

	public Double divide(Double d) throws MyException {
		if(checkOne(d.intValue()) || checkZero(d.intValue())){
			if (checkZero(d.intValue())){
				throw new MyException("Division by zero");
			}
			else{ 
				return this.elem/d;
			}
		}
		else{
			throw new MyException("Parametr  should be 0 or 1");
		}
	}
}

package Fields;


import Exceptions.DifferentDimensions;
import Exceptions.DivisionByZeroException;
import Exceptions.OperationNotSupportedException;
import Exceptions.ZeroDiscr;

public class FractionValue extends AbstractField {
	public final int ch;
	public final int di;

	public FractionValue(int a, int b) throws ZeroDiscr {
		if (b == 0) {
			throw new ZeroDiscr();
		}
		int c = gcd(a, b);
		ch = a/c;
		di = b/c;
	}

	public int getCh() {
		return this.ch;
	}

	public int getDi() {
		return this.di;
	}

	public AbstractField add(AbstractField operand)
			throws OperationNotSupportedException, DifferentDimensions, ZeroDiscr {
		return new FractionValue(this.ch * ((FractionValue)operand).getDi() + this.di
				* ((FractionValue)operand).getCh(), this.di*((FractionValue)operand).getDi());
	}

	public boolean checkZero(){
		return true;
	}

	public AbstractField div(AbstractField operand)
			throws DivisionByZeroException, OperationNotSupportedException, ZeroDiscr {
		return new FractionValue(this.ch*((FractionValue)operand).getDi(), this.di*((FractionValue)operand).getCh());
	}

	public AbstractField mul(AbstractField operand)
			throws OperationNotSupportedException, ZeroDiscr {
		return new FractionValue(this.ch*((FractionValue)operand).getCh(), this.di*((FractionValue)operand).getDi());
	}

	public AbstractField sub(AbstractField operand)
			throws OperationNotSupportedException, DifferentDimensions, ZeroDiscr {
		return new FractionValue(this.ch * ((FractionValue)operand).getDi() - this.di
				* ((FractionValue)operand).getCh(), this.di*((FractionValue)operand).getDi());
	}

	public String toString() {
		StringBuffer st = new StringBuffer();
		st.append(this.ch+":"+this.di);
		return st.toString();
	}
	  
	public static int gcd(int a,int b) {
	    if (a>b){
	    	int c = a;
	    	a = b;
	    	b = c;
	    }
		while (b !=0) {
	            int tmp = a%b;
	            a = b;
	            b = tmp;
	        }
	        return a;
	    }
}

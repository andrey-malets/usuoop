package field;

import fieldsInterfaces.MyFieldCompl;

public class ComplField implements MyFieldCompl<Double, Double> {
	private Double re;
	private Double im;

	public ComplField() {
		this.re = 0.;
		this.im = 0.;
	}

	public ComplField(Integer a, Integer b) {
		this.re = a.doubleValue();
		this.im = b.doubleValue();
	}

	public ComplField(Integer a, Double b) {
		this.re = a.doubleValue();
		this.im = new Double(b);
	}

	public ComplField(Double a, Integer b) {
		this.re = new Double(a);
		this.im = b.doubleValue();
	}

	public ComplField(Double a, Double b) {
		this.re = new Double(a);
		this.im = new Double(b);
	}

	public Double getReElem() {
		return new Double(re);
	}

	public Double getImElem() {
		return new Double(im);
	}

	public ComplField add(MyFieldCompl<Double, Double> var) {
		return new ComplField(
				(var.getReElem().doubleValue() + this.re.doubleValue()), (var
						.getImElem().doubleValue() + this.im.doubleValue()));
	}

	public ComplField mul(MyFieldCompl<Double, Double> var) {
		return new ComplField((this.re.doubleValue()
				* var.getReElem().doubleValue() + this.im.doubleValue()
				* var.getImElem().doubleValue()), (this.im.doubleValue()
				* var.getReElem().doubleValue() + this.re.doubleValue()
				* var.getImElem().doubleValue()));
	}

	public ComplField negativeNumb() {
		return new ComplField(-this.re, -this.im);
	}
	public String toString(){
		StringBuffer a = new StringBuffer();
		a.append('<');
		a.append(this.im);
		a.append(',');
		a.append(this.re);
		a.append('>');
		return a.toString();		
	}
}

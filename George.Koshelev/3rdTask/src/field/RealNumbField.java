package field;

import exceptions.MyException;
import fieldsInterfaces.MyField;

public class RealNumbField implements MyField<Double> {
	private Double numb;

	public RealNumbField(Integer i) {
		this.numb = i.doubleValue();
	}

	public RealNumbField(Double i) {
		this.numb = i;
	}

	public RealNumbField(Float i) {
		this.numb = i.doubleValue();
	}

	public RealNumbField() {
		this.numb = 0.;
	}

	public RealNumbField add(MyField<Double> var) {
		return new RealNumbField(this.numb.doubleValue()
				+ var.getElem().doubleValue());
	}

	public Double getElem() {
		return new Double(numb.doubleValue());
	}

	public RealNumbField sub(MyField<Double> var) {
		return new RealNumbField(this.numb.doubleValue()
				- var.getElem().doubleValue());
	}

	public RealNumbField mul(MyField<Double> var) {
		return new RealNumbField(this.numb.doubleValue()
				* var.getElem().doubleValue());
	}

	public MyField<Double> oppositeNumb() throws MyException {
		if (this.numb == 0) {
			throw new MyException("Ilegal division by zero");
		}
		return new RealNumbField(1/this.numb.doubleValue());
	}

	public MyField<Double> negativeNumb() {
		return new RealNumbField(-this.numb.doubleValue());
	}
	public String toString(){
			StringBuffer a = new StringBuffer();
			//a.append('<');
			a.append(this.numb);
			//a.append('>');
			return a.toString();
	}

}

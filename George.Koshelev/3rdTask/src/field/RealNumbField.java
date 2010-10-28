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
/**
 * Sum of values
 */
	public RealNumbField add(MyField<Double> var) {
		return new RealNumbField(this.numb.doubleValue()
				+ var.getElem().doubleValue());
	}
/**
 * Get value
 */
	public Double getElem() {
		return new Double(numb.doubleValue());
	}
/**
 * Subtraction of values 
 * @param var
 * @return
 */
	public RealNumbField sub(MyField<Double> var) {
		return new RealNumbField(this.numb.doubleValue()
				- var.getElem().doubleValue());
	}
/**
 * Multiply values
 */
	public RealNumbField mul(MyField<Double> var) {
		return new RealNumbField(this.numb.doubleValue()
				* var.getElem().doubleValue());
	}
/**
 * Get opposite value
 */
	public MyField<Double> oppositeNumb() {
		if (this.numb == 0) {
			return new RealNumbField(0.);
		}
		return new RealNumbField(1/this.numb.doubleValue());
	}
/**
 * Get negative value
 */
	public MyField<Double> negativeNumb() {
		return new RealNumbField(-this.numb.doubleValue());
	}
	public String toString(){
			StringBuffer a = new StringBuffer();
			a.append(this.numb);
			return a.toString();
	}
/**
 * Divizion by double value
 */
	public Double divide(Double d) throws MyException {
		if (d==0.){
			return 0.;
		}
		return this.numb/d;
	}

}

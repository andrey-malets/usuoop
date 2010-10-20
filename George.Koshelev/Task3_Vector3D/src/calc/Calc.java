package calc;

public class Calc implements Calculator<Integer,Integer>{

	public Double add(Integer a, Double b) {
		return a.doubleValue()+b;
	}
	public Double add(Double a, Integer b) {
		return a+b.doubleValue();
	}
	public Integer add(Integer a, Integer b) {
		return a+b;
	}
	public Double add(Double a, Double b) {
		return a+b;
	}

}

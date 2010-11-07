package Exceptions;

public class DifferentDimensions extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3360066067314167990L;
	public DifferentDimensions(){
		super("Dimensions should be equal");
	}
}

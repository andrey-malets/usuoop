package vector;

import exceptions.MyException;
import fieldsInterfaces.MyField;

public interface Vector<K> {
	public int dimension();

	public MyField<K> getComponent(int i);

	public MyField<K> scalar(Vector<K> v) throws MyException;

	public Double len() throws MyException;

	public Vector<K> multiply(MyField<K> factor) throws MyException;

	public Vector<K> add(Vector<K> v) throws MyException;

	public Vector<K> sub(Vector<K> v) throws MyException;

	public String getVecToString();
	
	public Vector<K> getNegVec() throws MyException;
}

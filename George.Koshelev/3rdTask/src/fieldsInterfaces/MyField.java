package fieldsInterfaces;

import exceptions.MyException;

public interface MyField<K> {
	public K getElem();

	public MyField<K> add(MyField<K> var) throws MyException;

	public MyField<K> mul(MyField<K> var) throws MyException;

	public MyField<K> oppositeNumb() throws MyException;
	
	public MyField<K> negativeNumb() throws MyException;

	public Double divide(Double d) throws MyException;

}

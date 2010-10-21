package fieldsInterfaces;

import exceptions.MyException;

public interface MyField<K> {

	public Double getElem();

	public MyField<K> add(MyField<K> var);

	public MyField<K> mul(MyField<K> var);

	public MyField<K> oppositeNumb() throws MyException;

	public MyField<K> negativeNumb();

}

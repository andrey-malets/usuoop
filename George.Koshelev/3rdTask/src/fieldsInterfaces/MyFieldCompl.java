package fieldsInterfaces;

public interface MyFieldCompl<K> {

	public Double getReElem();

	public Double getImElem();

	public MyFieldCompl<K> add(MyFieldCompl<K> var);

	public MyFieldCompl<K> mul(MyFieldCompl<K> var);

	public MyFieldCompl<K> negativeNumb();
}

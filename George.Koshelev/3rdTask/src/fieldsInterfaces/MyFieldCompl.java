package fieldsInterfaces;

public interface MyFieldCompl<K, V> {

	public Double getReElem();

	public Double getImElem();

	public MyFieldCompl<K, V> add(MyFieldCompl<K, V> var);

	public MyFieldCompl<K, V> mul(MyFieldCompl<K, V> var);

	public MyFieldCompl<K, V> negativeNumb();
}
